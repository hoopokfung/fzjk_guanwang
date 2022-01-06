package com.fzjk.guanwang.controller.admin;


import com.fzjk.guanwang.pojo.Admin;
import com.fzjk.guanwang.pojo.Article;
import com.fzjk.guanwang.service.ArticleService;
import com.fzjk.guanwang.service.SubTypeService;
import com.fzjk.guanwang.service.TypeService;
import com.fzjk.guanwang.vo.ArticleQuery;
import javafx.application.Application;
import org.apache.tomcat.util.http.fileupload.FileItemFactory;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.system.ApplicationHome;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Controller
@RequestMapping("/admin")
public class ArticleController {

    private static final String INPUT = "admin/article-input";
    private static final String LIST = "admin/articles";
    private static final String REDIRECT_LIST = "redirect:/admin/articles/";

    //上传的绝对路径
    @Value("${spring.servlet.multipart.location}")
    private String staticImgPath;

    //虚拟路径
    @Value("/upload/imgs/")
    private String imgPath;


    @Autowired
    private ArticleService articleService;

    @Autowired
    private TypeService typeService;

    @Autowired
    private SubTypeService subTypeService;

    /**
     * 文章列表页面
     * @param pageable
     * @param article
     * @param model
     * @return
     */
    @GetMapping("/articles/{subTypeId}")
    public String ArticlePage(@PageableDefault(size = 5, sort = {"updateTime"}, direction = Sort.Direction.DESC)Pageable pageable,
                              ArticleQuery  article, @PathVariable Long subTypeId, Model model){
        model.addAttribute("subTypeId",subTypeId);
        model.addAttribute("page",articleService.listArticlesBySubTypeId(pageable,subTypeId));
        return LIST;
    }

    /**
     * 处理上传的函数
     * @param file
     * @return
     */
    public String uploadImg(MultipartFile file){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm");//设置日期格式
        String date = sdf.format(new Date());//得到一个类似于202112161723的string
        //换一个名字
        String name = date + "-" + file.getOriginalFilename();

//        //在任意类里通过以下代码获取resource文件夹下的某个文件（夹）的路径
//        String staticPath = this.getClass().getClassLoader().getResource("static").getFile();
//        String dirPath = staticPath + imgPath;

        //新建一个全路径名的文件
        File outFile = new File(staticImgPath,name);
        //判断路径是否存在，如果不存在就创建一个
        if (!outFile.getParentFile().exists()){
            outFile.getParentFile().mkdirs();
        }
        try{
            //写入文件
            file.transferTo(outFile);
        } catch (IOException e){
            e.printStackTrace();
        }
        return imgPath+name;
    }

    /**
     * 提交表单，新增一个article
     * @param article
     * @param attributes
     * @return
     */
    @PostMapping("/articles")
    public String post(Article article, RedirectAttributes attributes,
                       @RequestParam("image")MultipartFile file){
        if (file.getSize() != 0){
            article.setFirstPicture(uploadImg(file));
        }
        article.setType(typeService.getType(article.getType().getId()));
        article.setSubType(subTypeService.findById(article.getSubType().getId()));
        Article a;
        if (article.getId() == null) {

            a =  articleService.save(article); //id为空，执行新建操作
            attributes.addFlashAttribute("subTypeId", article.getSubType().getId());
        } else {
            a = articleService.update(article.getId(), article); //id有值，执行更新操作
        }
        if(a == null){
            attributes.addFlashAttribute("message","操作失败");
        }else {
            attributes.addFlashAttribute("message","操作成功");
        }
        return REDIRECT_LIST + a.getSubType().getId();
    }


    /**
     * 进入编辑页面
     * @param model
     * @return
     */
    @GetMapping("/articles/input")
    public String articleInput(Model model){
        model.addAttribute("types",typeService.listType());
        model.addAttribute("subTypes",subTypeService.findAll());
        model.addAttribute("Article",new Article());
        return INPUT;
    }

    /**
     * 修改页面：获取对应id的article
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/articles/{id}/input")
    public String editInput(@PathVariable Long id, Model model){
        model.addAttribute("types",typeService.listType());
        model.addAttribute("subTypes",subTypeService.findAll());
        model.addAttribute("Article", articleService.findById(id));
        return INPUT;
    }

    /**
     * 删除方法
     * @param id
     * @param attributes
     * @return
     */
    @GetMapping("/articles/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes attributes){
        Long subTypeId = articleService.findById(id).getSubType().getId();
        articleService.delete(id);
        attributes.addFlashAttribute("message","删除成功");
        return REDIRECT_LIST + subTypeId;
    }

}

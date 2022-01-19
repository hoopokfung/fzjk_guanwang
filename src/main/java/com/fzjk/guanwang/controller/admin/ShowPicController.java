package com.fzjk.guanwang.controller.admin;

import com.fzjk.guanwang.pojo.Relay;
import com.fzjk.guanwang.pojo.ShowPic;
import com.fzjk.guanwang.service.ShowPicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/admin")
public class ShowPicController {

    @Autowired
    private ShowPicService showPicService;


    //上传的绝对路径
    @Value("${spring.servlet.multipart.location}")
    private String staticImgPath;

    //虚拟路径
    @Value("/upload/imgs/")
    private String imgPath;

    @GetMapping("/showPic")
    public String showPicPage(@PageableDefault(size = 10, sort = {"id"}, direction = Sort.Direction.ASC) Pageable pageable,
                            Model model){
        model.addAttribute("page",showPicService.findAll(pageable));
        return "admin/showPic";
    }


    /**
     * 进入新增页面
     * @param model
     * @return
     */
    @GetMapping("/showPic/input")
    public String showPicInput(Model model){
        model.addAttribute("showPic",new ShowPic());
        return "admin/showPic-input";
    }


    /**
     * 提交表单，新增一个showPic
     * @param showPic
     * @param attributes
     * @return
     */
    @PostMapping("/addShowPic")
    public String addShowPic(ShowPic showPic, RedirectAttributes attributes,
                             @RequestParam("image")MultipartFile file){
        if (file.getSize() != 0){
            showPic.setPic(uploadImg(file));
        }
        ShowPic showPic1 = showPicService.save(showPic);
        if (showPic1 == null){
           attributes.addFlashAttribute("message","哦欧~ 新增失败！");
        } else {
           attributes.addFlashAttribute("message","恭喜！新增成功！");
        }
        return "redirect:/admin/showPic";
    }


    @GetMapping("/showPic/{id}/edit")
    public String editShowPic(@PathVariable Long id, Model model){
        model.addAttribute("showPic",showPicService.getById(id));
        return "admin/showPic-input";
    }



    @GetMapping("/showPic/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes attributes){
        showPicService.delete(id);
        attributes.addFlashAttribute("message","删除成功");
        return "redirect:/admin/showPic";
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
}

package com.fzjk.guanwang.controller.admin;


import com.fzjk.guanwang.pojo.Article;
import com.fzjk.guanwang.service.ArticleService;
import com.fzjk.guanwang.service.SubTypeService;
import com.fzjk.guanwang.service.TypeService;
import com.fzjk.guanwang.vo.ArticleQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private TypeService typeService;

    @Autowired
    private SubTypeService subTypeService;

    @GetMapping("/articles")
    public String ArticlePage(@PageableDefault(size = 5, sort = {"updateTime"}, direction = Sort.Direction.DESC)Pageable pageable,
                              ArticleQuery  article, Model model){
        model.addAttribute("page",articleService.listArticle(pageable));
        return "admin/articles";
    }


    @GetMapping("/articles/input")
    public String articleInput(Model model){
        model.addAttribute("types",typeService.listType());
        model.addAttribute("subTypes",subTypeService.findAll());
        model.addAttribute("Article",new Article());
        return "admin/article-input";
    }

    /**
     * 请求编辑：获取对应id的type
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/articles/{id}/input")
    public String editInput(@PathVariable Long id, Model model){
        model.addAttribute("Article", articleService.findById(id));
        return "admin/article-input";
    }
}

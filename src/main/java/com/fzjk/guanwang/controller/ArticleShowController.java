package com.fzjk.guanwang.controller;

import com.fzjk.guanwang.pojo.Article;
import com.fzjk.guanwang.service.ArticleService;
import com.fzjk.guanwang.vo.PreAndNextArticle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/Article")
public class ArticleShowController {

    @Autowired
    ArticleService articleService;

    @GetMapping("/articleShow/{id}")
    public String articlePassage(@PathVariable Long id, Model model){
        String targetPage = null;
        articleService.updateViews(id);
        Article a = articleService.findById(id);
        String typeName =  a.getType().getName();
        model.addAttribute("Article",a);
        model.addAttribute("pre",articleService.getPreArticle(id,a.getSubType().getId()));
        model.addAttribute("next",articleService.getNextArticle(id,a.getSubType().getId()));
        switch (typeName){
            case "新闻中心":
                targetPage = "/list/news_passage";
                break;
            case "党的建设":
                targetPage = "/list/party_passage";
                break;
            case "通知公告":
                targetPage = "/list/inform_passage";
                break;
        }
        return targetPage;
    }


    /**
     * 人物详情页展示
     * @param title
     * @param model
     * @return
     */
    @GetMapping("/figureShow/{title}")
    public String figureShow(@PathVariable String title, Model model){
        Article a = articleService.findByTitle(title);
        model.addAttribute("Article",a);
        return "/list/figure";
    }


}

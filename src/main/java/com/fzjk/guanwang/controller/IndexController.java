package com.fzjk.guanwang.controller;


import com.fzjk.guanwang.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


//在templates目录下的所有页面，只能通过controller来跳转
@Controller
@RequestMapping("/index")
public class IndexController {

    @Autowired
    private ArticleService articleService;

    @GetMapping()
    public String index(Model model) {
        //获取各类文章信息
        //一线快讯
        model.addAttribute("flashInfo",articleService.findTop(Long.valueOf(10)));
        //行业动态
        model.addAttribute("industryInfo",articleService.findTop(Long.valueOf(11)));
        //集团动态
        model.addAttribute("groupInfo",articleService.findTop(Long.valueOf(9)));
        //通知公告
        model.addAttribute("informInfo",articleService.findTop(Long.valueOf(18)));
        return "index";
    }

}

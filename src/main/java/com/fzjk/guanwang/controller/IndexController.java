package com.fzjk.guanwang.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


//在templates目录下的所有页面，只能通过controller来跳转
@Controller
public class IndexController {



    @RequestMapping("/index")
    public String index(Model model) {
        model.addAttribute("msg","hello,world");
        return "index";
    }
}

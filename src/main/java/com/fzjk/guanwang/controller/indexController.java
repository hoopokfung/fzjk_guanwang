package com.fzjk.guanwang.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


//在templates目录下的所有页面，只能通过controller来跳转
@Controller
public class indexController {



    @RequestMapping("/index")
    public String index() {
        return "index";
    }
}

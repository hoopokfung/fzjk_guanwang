package com.fzjk.guanwang.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @RequestMapping("/admin/login")
    public String login(Model model){
        return "admin/login";
    }
}

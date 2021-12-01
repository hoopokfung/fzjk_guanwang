package com.fzjk.guanwang.controller.admin;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TypeController {


    @RequestMapping("/type")
    public String Type(Model model){
        return "admin/type";
    }


}

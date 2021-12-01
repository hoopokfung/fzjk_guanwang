package com.fzjk.guanwang.controller.admin;

import com.fzjk.guanwang.pojo.Admin;
import com.fzjk.guanwang.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class LoginController {


    @Autowired
    private AdminService adminService;


    //获取登录页面
    @GetMapping()
    public String loginPage(Model model){
        return "admin/login";
    }


    //登录方法
    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password, HttpSession session,
                        RedirectAttributes attributes){
        Admin admin = adminService.checkAdmin(username,password);
        if (admin != null){
            admin.setPassword(null);
            session.setAttribute("user",admin);
            return "admin/adminIndex";
        } else {
            attributes.addFlashAttribute("message","用户名和密码错误");
            return "redirect:/admin";
        }

    }

    //注销方法
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        return "redirect:/admin";
    }

}

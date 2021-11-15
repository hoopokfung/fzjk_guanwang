package com.fzjk.guanwang.controller.admin;


import com.fzjk.guanwang.mapper.AdminMapper;
import com.fzjk.guanwang.pojo.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private AdminMapper adminMapper;

    @RequestMapping("/admin")
    public String admin(Model model){
        return "admin/adminIndex";  //使用thymeleaf模板引擎之后，将自动识别template文件下的页面，不用动手在web.xml和spring-servlet.xml中映射关系
    }




    /**
    * 这个需要使用@RestController注解,这个注解可以将返回结构性数据形式，不能返回视图
    * @GetMapping相当于@RequestMapping(method = RequestMethod.GET, value="/queryAdminList")
    * */

    @GetMapping("/queryAdminList")
    public List<Admin> queryAdminList(){
        List<Admin> adminList = adminMapper.queryAdminList();
        for (Admin admin : adminList){
            System.out.println(admin);
        }
        return adminList;
    }

}

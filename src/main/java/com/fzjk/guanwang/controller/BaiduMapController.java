package com.fzjk.guanwang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BaiduMapController {

    @GetMapping("/baiduMap")
    public String baiduMap(){
        return "baiduMap";
    }
}

package com.fzjk.guanwang.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/list")
public class ListController {


    @GetMapping("/1")
    public String about_1(){
        return "/list/about_1";
    }

    @GetMapping("/2")
    public String about_2(){
        return "/list/about_2";
    }

    @GetMapping("/3")
    public String about_3(){
        return "/list/about_3";
    }

    @GetMapping("/4")
    public String about_4(){
        return "/list/about_4";
    }

    @GetMapping("/5")
    public String news_1(){
        return "/list/news_1";
    }

    @GetMapping("/6")
    public String news_2(){
        return "/list/news_2";
    }

    @GetMapping("/7")
    public String news_3(){
        return "/list/news_3";
    }

    @GetMapping("/8")
    public String business(){
        return "/business";
    }

    @GetMapping("/9")
    public String business_1(){
        return "/list/business_1";
    }

    @GetMapping("/10")
    public String business_2(){
        return "/list/business_2";
    }

    @GetMapping("/11")
    public String business_3(){
        return "list/business_3";
    }

    @GetMapping("/12")
    public String business_4(){
        return "/list/business_4";
    }

    @GetMapping("/13")
    public String business_5(){
        return "/list/business_5";
    }

    @GetMapping("/14")
    public String business_6(){
        return "/list/business_6";
    }

    @GetMapping("/15")
    public String party_1(){
        return "/list/party_1";
    }

    @GetMapping("/16")
    public String party_2(){
        return "/list/party_2";
    }

    @GetMapping("/17")
    public String party_3(){
        return "/list/party_3";
    }

    @GetMapping("/18")
    public String inform_1(){
        return "/list/inform_1";
    }

    @GetMapping("/19")
    public String inform_2(){
        return "/list/inform_2";
    }

    @GetMapping("/20")
    public String contact(){
        return "/contact";
    }
}

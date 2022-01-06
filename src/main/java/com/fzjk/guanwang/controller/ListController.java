package com.fzjk.guanwang.controller;


import com.fzjk.guanwang.pojo.Article;
import com.fzjk.guanwang.service.ArticleService;
import com.fzjk.guanwang.service.SubTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/list")
public class ListController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private SubTypeService subTypeService;

    /**
     * 集团简介
     * @return
     */
    @GetMapping("/1")
    public String about_1(){
        return "/list/about_1";
    }


    /**
     * 集团领导
     * @return
     */
    @GetMapping("/2")
    public String about_2(){
        return "/list/about_2";
    }


    /**
     * 成员企业
     * @return
     */
    @GetMapping("/3")
    public String about_3(){
        return "/list/about_3";
    }


    /**
     * 组织架构
     * @return
     */
    @GetMapping("/4")
    public String about_4(){
        return "/list/about_4";
    }

    /**
     * 新闻中心:集团动态
     * @return
     */
    @GetMapping("/5")
    public String news_1(@PageableDefault(size = 5,sort = {"updateTime"}, direction = Sort.Direction.DESC)Pageable pageable,
                         Model model){
        Long subTypeId = subTypeService.findByName("集团动态").getId();
        Page<Article> articles = articleService.listArticlesBySubTypeId(pageable,subTypeId);
        model.addAttribute("page",articles);
        return "/list/news_1";
    }

    /**
     * 新闻中心：一线快讯
     * @return
     */
    @GetMapping("/6")
    public String news_2(@PageableDefault(size = 5,sort = {"updateTime"}, direction = Sort.Direction.DESC)Pageable pageable,
                         Model model){
        Long subTypeId = subTypeService.findByName("一线快讯").getId();
        Page<Article> articles = articleService.listArticlesBySubTypeId(pageable,subTypeId);
        model.addAttribute("page",articles);
        return "/list/news_2";
    }

    /**
     * 新闻中心：行业动态
     * @return
     */
    @GetMapping("/7")
    public String news_3(@PageableDefault(size = 5,sort = {"updateTime"}, direction = Sort.Direction.DESC)Pageable pageable,
                         Model model){
        Long subTypeId = subTypeService.findByName("行业动态").getId();
        Page<Article> articles = articleService.listArticlesBySubTypeId(pageable,subTypeId);
        model.addAttribute("page",articles);
        return "/list/news_3";
    }


    /**
     * 业务领域
     * @return
     */
    @GetMapping("/8")
    public String business(){
        return "/business";
    }


    /**
     * 业务领域：基金管理
     * @return
     */
    @GetMapping("/9")
    public String business_1(){
        return "/list/business_1";
    }


    /**
     * 业务领域：融资担保
     * @return
     */
    @GetMapping("/10")
    public String business_2(){
        return "/list/business_2";
    }


    /**
     * 业务领域：融资租赁
     * @return
     */
    @GetMapping("/11")
    public String business_3(){
        return "list/business_3";
    }


    /**
     * 业务领域：资产管理
     * @return
     */
    @GetMapping("/12")
    public String business_4(){
        return "/list/business_4";
    }


    /**
     * 业务领域：商业保理
     * @return
     */
    @GetMapping("/13")
    public String business_5(){
        return "/list/business_5";
    }


    /**
     * 业务领域：供应链服务
     * @return
     */
    @GetMapping("/14")
    public String business_6(){
        return "/list/business_6";
    }


    /**
     * 党的建设：党建工作
     * @return
     */
    @GetMapping("/15")
    public String party_1(@PageableDefault(size = 5,sort = {"updateTime"}, direction = Sort.Direction.DESC)Pageable pageable,
                          Model model){
        Long subTypeId = subTypeService.findByName("党建工作").getId();
        Page<Article> articles = articleService.listArticlesBySubTypeId(pageable,subTypeId);
        model.addAttribute("page",articles);
        return "/list/party_1";
    }


    /**
     * 党的建设：在线学习
     * @return
     */
    @GetMapping("/16")
    public String party_2(@PageableDefault(size = 5,sort = {"updateTime"}, direction = Sort.Direction.DESC)Pageable pageable,
                          Model model){
        Long subTypeId = subTypeService.findByName("在线学习").getId();
        Page<Article> articles = articleService.listArticlesBySubTypeId(pageable,subTypeId);
        model.addAttribute("page",articles);
        return "/list/party_2";
    }


    /**
     * 党的建设：群团工作
     * @return
     */
    @GetMapping("/17")
    public String party_3(@PageableDefault(size = 5,sort = {"updateTime"}, direction = Sort.Direction.DESC)Pageable pageable,
                          Model model){
        Long subTypeId = subTypeService.findByName("群团工作").getId();
        Page<Article> articles = articleService.listArticlesBySubTypeId(pageable,subTypeId);
        model.addAttribute("page",articles);
        return "/list/party_3";
    }


    /**
     * 通知公告：公示公告
     * @return
     */
    @GetMapping("/18")
    public String inform_1(@PageableDefault(size = 5,sort = {"updateTime"}, direction = Sort.Direction.DESC)Pageable pageable,
                           Model model){
        Long subTypeId = subTypeService.findByName("公示公告").getId();
        Page<Article> articles = articleService.listArticlesBySubTypeId(pageable,subTypeId);
        model.addAttribute("page",articles);
        return "/list/inform_1";
    }


    /**
     * 通知公告：消息披露
     * @return
     */
    @GetMapping("/19")
    public String inform_2(@PageableDefault(size = 5,sort = {"updateTime"}, direction = Sort.Direction.DESC)Pageable pageable,
                           Model model){
        Long subTypeId = subTypeService.findByName("消息披露").getId();
        Page<Article> articles = articleService.listArticlesBySubTypeId(pageable,subTypeId);
        model.addAttribute("page",articles);
        return "/list/inform_2";
    }


    /**
     * 联系我们
     * @return
     */
    @GetMapping("/20")
    public String contact(){
        return "/contact";
    }

    /**
     * 人才招聘
     * @return
     */
    @GetMapping("/21")
    public String inform_3(){
        return "/list/inform_3";
    }

    /**
     * 企业文化
     * @return
     */
    @GetMapping("/22")
    public String about_5(){
        return "/list/about_5";
    }

    /**
     * 业务领域其他
     * @return
     */
    @GetMapping("/23")
    public String business_sub(){
        return "/business_sub";
    }


}

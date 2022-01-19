package com.fzjk.guanwang.controller;


import com.fzjk.guanwang.service.ArticleService;
import com.fzjk.guanwang.service.RelayService;
import com.fzjk.guanwang.service.ShowPicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


//在templates目录下的所有页面，只能通过controller来跳转
@Controller
@RequestMapping("/")
public class IndexController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private RelayService relayService;

    @Autowired
    private ShowPicService showPicService;

    @GetMapping(value = {"","/","/index","/index.html"})
    public String index(Model model) {
        //获取各类文章信息,数字是subTypeId,可查看数据库获得
        //领导要闻
        model.addAttribute("leaderInfo",articleService.findTop(Long.valueOf(10),3));
        //行业动态
        model.addAttribute("industryInfo",articleService.findTop(Long.valueOf(11),3));
        //集团动态
        model.addAttribute("groupInfo",articleService.findTop(Long.valueOf(9),3));
        //通知公告
        model.addAttribute("informInfo",articleService.findTopByTypeId(Long.valueOf(3)));
        //党建工作
        model.addAttribute("partySmallCard",articleService.findTop(Long.valueOf(12),6));
        //党的法规
        model.addAttribute("lawSmallCard",articleService.findTop(Long.valueOf(13),6));
        //群团工作
        model.addAttribute("massSmallCard",articleService.findTop(Long.valueOf(14),6));
        //公示公告
        model.addAttribute("postSmallCard",articleService.findTop(Long.valueOf(15),6));
        //信息披露
        model.addAttribute("publicSmallCard",articleService.findTop(Long.valueOf(38),6));
        //人才招聘
        model.addAttribute("RecruitmentSmallCard",articleService.findTop(Long.valueOf(40),6));
        //转载文章
        model.addAttribute("relays",relayService.listAll());
        //图片展示
        model.addAttribute("showPics",showPicService.listAll());
        return "index";
    }

}

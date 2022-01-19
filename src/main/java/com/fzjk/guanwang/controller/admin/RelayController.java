package com.fzjk.guanwang.controller.admin;



import com.fzjk.guanwang.pojo.Relay;
import com.fzjk.guanwang.service.RelayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.print.DocFlavor;


@Controller
@RequestMapping("/admin")
public class RelayController {

    @Autowired
    private RelayService relayService;

    @GetMapping("/relay")
    public String relayPage(@PageableDefault(size = 3, sort = {"updateTime"}, direction = Sort.Direction.DESC)Pageable pageable,
                            Model model){
        model.addAttribute("page",relayService.findAll(pageable));
        return "admin/relay";
    }


    /**
     * 进入新增页面
     * @param model
     * @return
     */
    @GetMapping("/relay/input")
    public String relayInput(Model model){
        model.addAttribute("relay",new Relay());
        return "admin/relay-input";
    }


    /**
     * 提交表单，新增一个relay
     * @param relay
     * @param attributes
     * @return
     */
    @PostMapping("/addRelay")
    public String addRelay(Relay relay,RedirectAttributes attributes){
        Relay relay1 = relayService.save(relay);
        if (relay1 == null){
            attributes.addFlashAttribute("message","哦欧~ 新增失败！");
        } else {
            attributes.addFlashAttribute("message","恭喜！新增成功！");
        }
        return "redirect:/admin/relay";
    }


    @GetMapping("/relay/{id}/edit")
    public String editRelay(@PathVariable Long id, Model model){
        model.addAttribute("relay",relayService.getById(id));
        return "admin/relay-input";
    }


    @PostMapping("/relay/{id}/update")
    public String updateRelay(Relay relay, @PathVariable Long id,RedirectAttributes attributes){
        Relay relay1 = relayService.getById(id);
        if (relay1 == null){
            attributes.addFlashAttribute("message","不存在");
        }else {
            Relay r = relayService.update(id,relay);
            attributes.addFlashAttribute("message","更新成功！");
        }
        return "redirect:/admin/relay";
    }



    @GetMapping("/relay/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes attributes){
        relayService.delete(id);
        attributes.addFlashAttribute("message","删除成功");
        return "redirect:/admin/relay";
    }

}

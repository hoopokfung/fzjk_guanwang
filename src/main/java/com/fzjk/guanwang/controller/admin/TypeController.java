package com.fzjk.guanwang.controller.admin;


import com.fzjk.guanwang.pojo.Type;
import com.fzjk.guanwang.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin")
public class TypeController {

    @Autowired
    private TypeService typeService;

    @GetMapping("/types")
    public String types(@PageableDefault(size = 3, sort = {"id"},direction = Sort.Direction.DESC)
                                    Pageable pageable, Model model){
        model.addAttribute("page",typeService.listType(pageable));
        return "admin/types";
    }



    @GetMapping("/type/input")
    public String typeInput(Model model){
        model.addAttribute("type",new Type());
        return "admin/type-input";
    }

    /**
     * 请求编辑：获取对应id的type
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/types/{id}/input")
    public String editInput(@PathVariable Long id, Model model){
        model.addAttribute("type",typeService.getType(id));
        return "admin/type-input";
    }


    /**
     * 新增方法
     * 注意 @Valid Type type和 BindingResult result 两个参数必须比邻，中间不能插入其他参数，否则校验无效
     * @param type
     * @param result
     * @param attributes
     * @return
     */
    @PostMapping("/types")
    public String post(@Valid Type type, BindingResult result,
                       RedirectAttributes attributes){
        Type type1 =typeService.getTypeByName(type.getName());
        if (type1 != null){
            result.rejectValue("name","nameError","不能添加重复的分类");
        }
        if (result.hasErrors()){
            return "admin/type-input";
        }
        Type t = typeService.saveType(type);
        if (t == null){
            attributes.addFlashAttribute("message","哦欧~ 新增失败！");
        } else {
            attributes.addFlashAttribute("message","恭喜！新增成功！");
        }
        return "redirect:/admin/types";
    }

    /**
     * 修改方法
     * @param type
     * @param result
     * @param id
     * @param attributes
     * @return
     */
    @PostMapping("/types/{id}")
    public String editPost(@Valid Type type, BindingResult result,
                           @PathVariable Long id,RedirectAttributes attributes){
        Type type1 =typeService.getTypeByName(type.getName());
        if (type1 != null){
            /*rejectValue自定义验证错误结果,第一个参数s为校验的数据，
            第二个参数s1为自定义错误字符串，第三个参数s2为自定义错误信息*/
            result.rejectValue("name","nameError","不能添加重复的分类");
        }
        if (result.hasErrors()){//如果校验结果存在错误
            return "admin/type-input";
        }
        Type t = typeService.updateType(id,type);
        if (t == null){
            attributes.addFlashAttribute("message","哦欧~ 更新失败！");
        } else {
            attributes.addFlashAttribute("message","恭喜！更新成功！");
        }
        return "redirect:/admin/types";
    }


    @GetMapping("/types/{id}/delete")
    public String delete(@PathVariable Long id,RedirectAttributes attributes){
        typeService.deleteType(id);
        attributes.addFlashAttribute("message","删除成功");
        return "redirect:/admin/types";
    }


    /*子类*/

    @GetMapping("/subTypes")
    public String subType(){
        return "admin/subTypes";
    }

    @GetMapping("/subType/input")
    public String subTypeInput(){
        return "admin/subType-input";
    }


}

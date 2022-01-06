package com.fzjk.guanwang.controller.admin;


import com.fzjk.guanwang.pojo.SubType;
import com.fzjk.guanwang.pojo.Type;
import com.fzjk.guanwang.service.SubTypeService;
import com.fzjk.guanwang.service.TypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
import java.util.List;

@Controller
@RequestMapping("/admin")
public class SubTypeController {

    @Autowired
    private TypeService typeService;

    @Autowired
    private SubTypeService subTypeService;


    /**
     * 全列表
     * Q:这个地方存在一个问题：在subtypes.html页面，点击下一页，会载入loaddata()就
     * 变成了下一个方法即subTypesByTypeId,然而因为没有选择select选项，所以typeId是空的，
     * 这样就获取了【】空的数组，因此下一页刷不出来
     * @param pageable
     * @param model
     * @return
     */
    @GetMapping("/subTypes")
    public String subTypes(@PageableDefault(size = 10, sort = {"id"},direction = Sort.Direction.DESC)
                                Pageable pageable, Model model){
        model.addAttribute("types",typeService.listType());
        model.addAttribute("page",subTypeService.listSubType(pageable));
        return "admin/subTypes";
    }


    @PostMapping("/subTypesByTypeId")
    public String subTypesByType(@PageableDefault(size = 5, sort = {"id"},direction = Sort.Direction.DESC)
                                Pageable pageable, Long typeId, Model model){
        model.addAttribute("page",subTypeService.listSubTypesByTypeId(pageable,typeId));
        return "admin/subTypes :: subTypeList";
    }


    /**
     * 新增页面
     * @param model
     * @return
     */
    @GetMapping("/subTypes/input")
    public String subTypeInput(Model model){
        model.addAttribute("types",typeService.listType());
        model.addAttribute("subType",new SubType());
        return "admin/subType-input";
    }


    /**
     * 新增方法
     * 注意 @Valid Type type和 BindingResult result 两个参数必须比邻，中间不能插入其他参数，否则校验无效
     * @param subType
     * @param result
     * @param attributes
     * @return
     */
    @PostMapping("/subTypes")
    public String post(@Valid SubType subType, BindingResult result,
                       RedirectAttributes attributes){
        subType.setType(typeService.getType(subType.getType().getId()));
        SubType subType1 =subTypeService.findByName(subType.getName());
        if (subType1 != null){
            result.rejectValue("name","nameError","不能添加重复的分类");
        }
        if (result.hasErrors()){
            return "admin/subType-input";
        }
        SubType st = subTypeService.save(subType);
        if (st == null){
            attributes.addFlashAttribute("message","哦欧~ 新增失败！");
        } else {
            attributes.addFlashAttribute("message","恭喜！新增成功！");
        }
        return "redirect:/admin/subTypes";
    }



    /**
     * 请求编辑页面：获取对应id的subType
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/subTypes/{id}/input")
    public String editInput(@PathVariable Long id, Model model){
        //返回subType数据后要使得，select的option对应到type.id
        model.addAttribute("subType",subTypeService.findById(id));
        return "admin/subType-input";
    }




    /**
     * 修改方法
     * @param subType
     * @param result
     * @param id
     * @param attributes
     * @return
     */
    @PostMapping("/subTypes/{id}")
    public String editPost(@Valid SubType subType, BindingResult result,
                           @PathVariable Long id,RedirectAttributes attributes){
        SubType subType1 =subTypeService.findByName(subType.getName());
        if (subType1 != null){
            /*rejectValue自定义验证错误结果,第一个参数s为校验的数据，
            第二个参数s1为自定义错误字符串，第三个参数s2为自定义错误信息*/
            result.rejectValue("name","nameError","不能添加重复的分类");
        }
        if (result.hasErrors()){//如果校验结果存在错误
            return "admin/subType-input";
        }
        SubType t = subTypeService.update(id,subType);
        if (t == null){
            attributes.addFlashAttribute("message","哦欧~ 更新失败！");
        } else {
            attributes.addFlashAttribute("message","恭喜！更新成功！");
        }
        return "redirect:/admin/subTypes";
    }


    /**
     * 删除方法
     * @param id
     * @param attributes
     * @return
     */
    @GetMapping("/subTypes/{id}/delete")
    public String delete(@PathVariable Long id,RedirectAttributes attributes){
        subTypeService.delete(id);
        attributes.addFlashAttribute("message","删除成功");
        return "redirect:/admin/subTypes";
    }

}

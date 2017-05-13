package com.suny.association.controller;

import com.suny.association.annotation.SystemControllerLog;
import com.suny.association.enums.BaseEnum;
import com.suny.association.pojo.po.MemberRoles;
import com.suny.association.service.interfaces.IMemberRolesService;
import com.suny.association.service.interfaces.IMemberService;
import com.suny.association.utils.ConversionUtil;
import com.suny.association.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

import static com.suny.association.utils.JsonResult.failResult;
import static com.suny.association.utils.JsonResult.successResult;

/**
 * Comments:   协会角色管理
 * Author:   孙建荣
 * Create Date: 2017/04/22 22:34
 */
@Controller
@RequestMapping("/member/role")
public class MemberRoleController extends BaseController {
    private final IMemberRolesService memberRolesService;

    private final IMemberService memberService;

    @Autowired
    public MemberRoleController(IMemberRolesService memberRolesService, IMemberService memberService) {
        this.memberRolesService = memberRolesService;
        this.memberService = memberService;
    }

    @SystemControllerLog(description = "删除成员角色")
    @RequestMapping(value = "/delete.json/{memberRoleId}", method = RequestMethod.GET)
    @ResponseBody
    public JsonResult delete(@PathVariable("memberRoleId") Integer memberRoleId) {
        if (memberService.quoteByMemberRoleId(memberRoleId).size() >= 1) {
            return failResult(BaseEnum.HAVE_QUOTE);
        } else if (memberRolesService.queryById(memberRoleId) == null) {
            return failResult(BaseEnum.DELETE_FAILURE);
        }
        memberRolesService.deleteById(memberRoleId);
        return successResult(BaseEnum.DELETE_SUCCESS);
    }

    @SystemControllerLog(description = "更新成员角色")
    @ResponseBody
    @RequestMapping(value = "/update.json", method = RequestMethod.POST)
    public JsonResult update(@RequestBody MemberRoles memberRoles) {
        if (memberRoles.getMemberRoleId() == null || memberRolesService.queryById(memberRoles.getMemberRoleId()) == null) {
            return failResult(BaseEnum.SELECT_FAILURE);
        }
        if ("".equals(memberRoles.getMemberRoleName()) || memberRoles.getMemberRoleName() == null) {
            return failResult(BaseEnum.FIELD_NULL);
        }
        memberRolesService.update(memberRoles);
        return successResult(BaseEnum.UPDATE_SUCCESS);
    }

    @RequestMapping(value = "/update.html/{memberRoleId}", method = RequestMethod.GET)
    public ModelAndView updatePage(@PathVariable int memberRoleId
            , ModelAndView modelAndView) {
        MemberRoles memberRoles = memberRolesService.queryById(memberRoleId);
        if (memberRoles == null) {
            memberRoles = memberRolesService.queryById(0);
            modelAndView.addObject("role", memberRoles);
            return modelAndView;
        }
        modelAndView.addObject("role", memberRoles);
        modelAndView.setViewName("/memberInfo/role/roleUpdate");
        return modelAndView;
    }


    /**
     * 插入数据请求
     *
     * @param memberRoles 数据
     * @return 插入数据的结果
     */
    @SystemControllerLog(description = "新增成员角色")
    @ResponseBody
    @RequestMapping(value = "/insert.json", method = RequestMethod.POST)
    public JsonResult insert(@RequestBody MemberRoles memberRoles) {
        if ("".equals(memberRoles.getMemberRoleName()) || memberRoles.getMemberRoleName() == null) {
            return failResult(BaseEnum.FIELD_NULL);
        }
        if (memberRolesService.queryByName(memberRoles.getMemberRoleName()) != null) {
            return failResult(BaseEnum.REPEAT_ADD);
        }
        memberRolesService.insert(memberRoles);
        return successResult(BaseEnum.ADD_SUCCESS);
    }

    @RequestMapping(value = "/insert.html", method = RequestMethod.GET)
    public ModelAndView insertPage(ModelAndView modelAndView) {
        modelAndView.setViewName("/memberInfo/role/roleInsert");
        return modelAndView;
    }

    /**
     * 带查询条件的查询
     *
     * @param offset 从第几条记录开始查询
     * @param limit  查询几条数据
     * @return 带查询条件的数据
     */
    @SystemControllerLog(description = "查询成员角色")
    @RequestMapping(value = "/list.json", method = RequestMethod.GET)
    @ResponseBody
    public Map<Object, Object> query(@RequestParam(value = "offset", required = false, defaultValue = "0") int offset,
                                     @RequestParam(value = "limit", required = false, defaultValue = "10") int limit) {
        List<MemberRoles> rolesList = memberRolesService.list(ConversionUtil.convertToCriteriaMap(offset, limit));
        int total = memberRolesService.queryCount();
        return ConversionUtil.convertToBootstrapTableResult(rolesList, total);
    }

    @SystemControllerLog(description = "查看成员角色页面")
    @RequestMapping(value = "/index.html", method = RequestMethod.GET)
    public String index() {
        return "/memberInfo/role/roleList";
    }
}

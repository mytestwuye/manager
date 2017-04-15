package com.suny.association.controller;

import com.suny.association.enums.MemberEnum;
import com.suny.association.pojo.po.Department;
import com.suny.association.pojo.po.Member;
import com.suny.association.pojo.po.MemberRoles;
import com.suny.association.service.interfaces.IDepartmentService;
import com.suny.association.service.interfaces.IMemberRolesService;
import com.suny.association.service.interfaces.IMemberService;
import com.suny.association.utils.CustomDate;
import com.suny.association.utils.DecideUtil;
import com.suny.association.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Comments:   成员信息管理类Controller
 * Author:   孙建荣
 * Create Date: 2017/03/15 20:46
 */
@Controller
@RequestMapping("/member")
public class MemberController {

    private final IMemberService memberService;

    private final IDepartmentService departmentService;

    private final IMemberRolesService memberRolesService;


    @Autowired
    public MemberController(IDepartmentService departmentService, IMemberService memberService, IMemberRolesService memberRolesService) {
        this.departmentService = departmentService;
        this.memberService = memberService;
        this.memberRolesService = memberRolesService;
    }


    @RequestMapping(value = "/insert.json", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult insert(@RequestBody Member member) {
        memberService.insert(member);
        return JsonResult.successResult(MemberEnum.SUCCESS_INSERT_MEMBER_INFO);
    }


    @RequestMapping(value = "/insert.html")
    public ModelAndView insertPage(ModelAndView modelAndView) {
        List<Member> managerList = memberService.queryNormalManager();
        List<Department> departmentList = departmentService.queryAll();
        List<MemberRoles> memberRolesList = memberRolesService.queryAll();
        modelAndView.addObject("departmentList", departmentList);
        modelAndView.addObject("memberRolesList", memberRolesList);
        modelAndView.addObject("managerList", managerList);
        modelAndView.addObject("memberGradeList", CustomDate.getLastYearAndThisYears());
        modelAndView.setViewName("memberInfo/memberInsert");
        return modelAndView;
    }


    @RequestMapping(value = "/deleteById.json/{id}")
    @ResponseBody
    public JsonResult deleteById(@PathVariable("id") Integer id) {
        if (memberService.queryById(id) == null) {
            return JsonResult.failResult(MemberEnum.NOT_HAVE_THIS_MEMBER_INFO);
        }
        memberService.deleteById(id);
        return JsonResult.successResult(MemberEnum.SUCCESS_DELETE_MEMBER_INFO);
    }


    @RequestMapping(value = "/update.json", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult update(@RequestBody Member member) {
        memberService.update(member);
        return JsonResult.successResult(MemberEnum.SUCCESS_UPDATE_MEMBER_INFO);
    }


    @RequestMapping(value = "/update.html/{id}", method = RequestMethod.GET)
    public ModelAndView updatePage(@PathVariable("id") Integer id, ModelAndView modelAndView) {
        Member member = memberService.queryById(id);
        List<Member> managerList = memberService.queryNormalManager();
        List<Department> departmentList = departmentService.queryAll();
        List<MemberRoles> memberRolesList = memberRolesService.queryAll();
        modelAndView.addObject("member", member);
        modelAndView.addObject("departmentList", departmentList);
        modelAndView.addObject("memberRolesList", memberRolesList);
        modelAndView.addObject("managerList", managerList);
        modelAndView.setViewName("memberInfo/memberUpdate");
        return modelAndView;
    }


    @RequestMapping(value = "/queryFreeze.json")
    @ResponseBody
    public JsonResult queryFreeze() {
        List<Member> memberList = memberService.queryNormalMember();
        if (memberList != null) {
            return JsonResult.successResultAndData(MemberEnum.SUCCESS_SELECT_MEMBER_INFO, memberList);
        }
        return JsonResult.failResult(MemberEnum.FAIL_SELECT_MEMBER_INFO);
    }


    @RequestMapping(value = "/queryNormal.json")
    @ResponseBody
    public JsonResult queryNormal() {
        List<Member> memberList = memberService.queryNormalMember();
        if (memberList != null) {
            return JsonResult.successResultAndData(MemberEnum.SUCCESS_SELECT_MEMBER_INFO, memberList);
        }
        return JsonResult.failResult(MemberEnum.FAIL_SELECT_MEMBER_INFO);
    }


    @RequestMapping(value = "/queryAll.json", method = RequestMethod.GET)
    @ResponseBody
    public Map<Object, Object> queryAll(@RequestParam(value = "offset", required = false, defaultValue = "0") int offset,
                                        @RequestParam(value = "limit", required = false, defaultValue = "10") int limit,
                                        @RequestParam(value = "departmentname", required = false) String departmentname,
                                        @RequestParam(value = "status", required = false) int status) {
        Map<Object, Object> tableDate = new HashMap<>();
        if ("".equals(departmentname)) {
            departmentname = null;
        }
        List<Member> memberList = memberService.queryAllByCriteria(DecideUtil.pushToMap(offset, limit, departmentname, status));
        if (memberList.size() != 0 && !memberList.isEmpty()) {
            int total = memberService.queryCount();
            tableDate.put("rows", memberList);
            tableDate.put("total", total);
            return tableDate;
        }
        tableDate.put("rows", null);
        tableDate.put("total", 0);
        return tableDate;
    }


    @RequestMapping(value = "/queryById.do")
    public JsonResult queryById(Integer memberId) {
        Member member = memberService.queryById(memberId);
        return JsonResult.successResultAndData(MemberEnum.SUCCESS_SELECT_MEMBER_INFO, member);
    }


    @RequestMapping(value = "/memberManager.html")
    public String managerPage() {
        return "memberInfo/memberManager";
    }

}

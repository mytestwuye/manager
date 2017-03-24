package com.suny.association.controller;

import com.suny.association.enums.MemberEnum;
import com.suny.association.pojo.po.Account;
import com.suny.association.pojo.po.Department;
import com.suny.association.pojo.po.Member;
import com.suny.association.pojo.po.MemberRoles;
import com.suny.association.service.interfaces.IAccountService;
import com.suny.association.service.interfaces.IDepartmentService;
import com.suny.association.service.interfaces.IMemberRolesService;
import com.suny.association.service.interfaces.IMemberService;
import com.suny.association.utils.CustomDate;
import com.suny.association.utils.JsonResult;
import com.suny.association.utils.RandomID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

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
    
    private final IAccountService accountService;
    
    @Autowired
    public MemberController(IDepartmentService departmentService, IMemberService memberService, IMemberRolesService memberRolesService, IAccountService accountService) {
        this.departmentService = departmentService;
        this.memberService = memberService;
        this.memberRolesService = memberRolesService;
        this.accountService = accountService;
    }
    
    
    @RequestMapping(value = "/insert.json")
    @ResponseBody public JsonResult insert(Member member) {
        memberService.insertReturnCount(member);
        createAccount(member.getMemberId());
        return JsonResult.successResult(MemberEnum.SUCCESS_INSERT_MEMBER_INFO);
    }
    
    
    private void createAccount(int memberId) {
        Account autoAccount = new Account();
        autoAccount.getAccountMember().setMemberId(memberId);
        autoAccount.setAccountName(RandomID.getOrderIdByUUId());
        accountService.insert(autoAccount);
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
        modelAndView.setViewName("Member/MemberInsert");
        return modelAndView;
    }
    
    
    @RequestMapping(value = "/deleteById.json/{id}")
    @ResponseBody
    public JsonResult deleteById(@PathVariable("id") Integer id) {
        memberService.deleteById(id);
        return JsonResult.successResult(MemberEnum.SUCCESS_DELETE_MEMBER_INFO);
    }
    
    
    @RequestMapping(value = "/update.json")
    @ResponseBody
    public JsonResult update(Member member) {
        memberService.update(member);
        return JsonResult.successResult(MemberEnum.SUCCESS_UPDATE_MEMBER_INFO);
    }
    
    
    @RequestMapping(value = "/update.html/{id}")
    public ModelAndView updatePage(@PathVariable("id") Integer id, ModelAndView modelAndView) {
        Member member = memberService.queryById(id);
        List<Member> managerList = memberService.queryNormalManager();
        List<Department> departmentList = departmentService.queryAll();
        List<MemberRoles> memberRolesList = memberRolesService.queryAll();
        modelAndView.addObject("member", member);
        modelAndView.addObject("departmentList", departmentList);
        modelAndView.addObject("memberRolesList", memberRolesList);
        modelAndView.addObject("managerList", managerList);
        modelAndView.setViewName("Member/MemberUpdate");
        return modelAndView;
    }
    
    
    @RequestMapping(value = "/querytFreeze.json")
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
    
    
    @RequestMapping(value = "/queryAll.json")
    @ResponseBody
    public JsonResult queryAll() {
        List<Member> memberList = memberService.queryAll();
        if (memberList != null) {
            return JsonResult.successResultAndData(MemberEnum.SUCCESS_SELECT_MEMBER_INFO, memberList);
        }
        return JsonResult.failResult(MemberEnum.FAIL_SELECT_MEMBER_INFO);
    }
    
    
    @RequestMapping(value = "/memberManager.html")
    public String managerPage() {
        return "Member/MemberManager";
    }
    
    
    @RequestMapping(value = "/queryById.do")
    public JsonResult queryById(Integer memberId) {
        Member member = memberService.queryById(memberId);
        return JsonResult.successResultAndData(MemberEnum.SUCCESS_SELECT_MEMBER_INFO, member);
    }
    
    
}

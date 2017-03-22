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
import com.suny.association.utils.JSONResultUtil;
import com.suny.association.utils.LocalDateUtil;
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
@RequestMapping("/Member")
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
    
    
    /**
     * 插入一条成员信息
     *
     * @param member 成员信息
     * @return 结果
     */
    @RequestMapping(value = "/InsertMemberInfo.json")
    @ResponseBody
    public JSONResultUtil insertMemberInfo(Member member) {
        memberService.insertAndGetId(member);
        autoCreateAccount(member.getMemberId());
        return JSONResultUtil.successResult(MemberEnum.SUCCESS_INSERT_MEMBER_INFO);
    }
    
    /**
     * 产生一个account账号
     *
     * @param memberId 对应的成员id
     */
    private void autoCreateAccount(int memberId) {
        Account autoAccount = new Account();
        autoAccount.setAccountMemberId(memberId);
        autoAccount.setAccountName(RandomID.getOrderIdByUUId());
        accountService.insert(autoAccount);
    }
    
    /**
     * 进行新增一条成员信息页面
     *
     * @return 结果
     */
    @RequestMapping(value = "/InsertMember.html")
    public ModelAndView insertMemberPage(ModelAndView modelAndView) {
        List<Member> managerList = memberService.selectNormalManager();
        List<Department> departmentList = departmentService.selectForAll();
        List<MemberRoles> memberRolesList = memberRolesService.selectForAll();
        modelAndView.addObject("departmentList", departmentList);
        modelAndView.addObject("memberRolesList", memberRolesList);
        modelAndView.addObject("managerList", managerList);
        modelAndView.addObject("memberGradeList", LocalDateUtil.getLastYearAndThisYears());
        modelAndView.setViewName("Member/MemberInsert");
        return modelAndView;
    }
    
    
    /**
     * 删除一个成员的信息
     *
     * @param id 成员的id
     * @return JSON数据结果
     */
    @RequestMapping(value = "/DeleteMemberById.json/{id}")
    @ResponseBody
    public JSONResultUtil deleteMemberById(@PathVariable("id") Integer id) {
        memberService.deleteById(id);
        return JSONResultUtil.successResult(MemberEnum.SUCCESS_DELETE_MEMBER_INFO);
    }
    
    /**
     * 更新一条信息
     *
     * @param member 要更新的实体
     * @return 结果
     */
    @RequestMapping(value = "/UpdateMemberInfo.json")
    @ResponseBody
    public JSONResultUtil updateMemberInfo(Member member) {
        memberService.update(member);
        return JSONResultUtil.successResult(MemberEnum.SUCCESS_UPDATE_MEMBER_INFO);
    }
    
    
    /**
     * 更新一个成员的信息
     *
     * @param id           要修改信息的成员id
     * @param modelAndView 模型和视图数据
     * @return 视图跟数据
     */
    @RequestMapping(value = "/UpdateMember.html/{id}")
    public ModelAndView updateMemberPage(@PathVariable("id") Integer id, ModelAndView modelAndView) {
        Member member = memberService.selectById(id);
        List<Member> managerList = memberService.selectNormalManager();
        List<Department> departmentList = departmentService.selectForAll();
        List<MemberRoles> memberRolesList = memberRolesService.selectForAll();
        modelAndView.addObject("member", member);
        modelAndView.addObject("departmentList", departmentList);
        modelAndView.addObject("memberRolesList", memberRolesList);
        modelAndView.addObject("managerList", managerList);
        modelAndView.setViewName("Member/MemberUpdate");
        return modelAndView;
    }
    
    /**
     * 请求查询member数据库中所有冻结的成员信息
     *
     * @return json格式的数据
     */
    @RequestMapping(value = "/SelectFreeze.json")
    @ResponseBody
    public JSONResultUtil selectFreeze() {
        List<Member> memberList = memberService.selectNormalMember();
        if (memberList != null) {
            return JSONResultUtil.successResultAndData(MemberEnum.SUCCESS_SELECT_MEMBER_INFO, memberList);
        }
        return JSONResultUtil.failResult(MemberEnum.FAIL_SELECT_MEMBER_INFO);
    }
    
    /**
     * 请求查询member数据库中所有的未冻结的成员信息
     *
     * @return json格式的数据
     */
    @RequestMapping(value = "/SelectNormal.json")
    @ResponseBody
    public JSONResultUtil selectNormal() {
        List<Member> memberList = memberService.selectNormalMember();
        if (memberList != null) {
            return JSONResultUtil.successResultAndData(MemberEnum.SUCCESS_SELECT_MEMBER_INFO, memberList);
        }
        return JSONResultUtil.failResult(MemberEnum.FAIL_SELECT_MEMBER_INFO);
    }
    
    
    /**
     * 请求查询member数据库中所有的数据
     *
     * @return json格式的数据
     */
    @RequestMapping(value = "/SelectForAll.json")
    @ResponseBody
    public JSONResultUtil selectForAll() {
        List<Member> memberList = memberService.selectForAll();
        if (memberList != null) {
            return JSONResultUtil.successResultAndData(MemberEnum.SUCCESS_SELECT_MEMBER_INFO, memberList);
        }
        return JSONResultUtil.failResult(MemberEnum.FAIL_SELECT_MEMBER_INFO);
    }
    
    
    /**
     * 进入成员管理页面的请求
     *
     * @return 成员管理页面
     */
    @RequestMapping(value = "/MemberManager.html")
    public String memberManager() {
        return "Member/MemberManager";
    }
    
    /**
     * 查询对应成员的一条信息
     *
     * @param memberId 成员的id
     * @return JSON格式的成员信息
     */
    @RequestMapping(value = "/SelectMemberInfo.do")
    public JSONResultUtil selectMemberInfo(Integer memberId) {
        Member member = memberService.selectById(memberId);
        return JSONResultUtil.successResultAndData(MemberEnum.SUCCESS_SELECT_MEMBER_INFO, member);
    }
    
    
}

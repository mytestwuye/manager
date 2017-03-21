package com.suny.association.controller;

import com.suny.association.enums.MemberStatusCode;
import com.suny.association.exception.BusinessException;
import com.suny.association.pojo.po.Account;
import com.suny.association.pojo.po.Department;
import com.suny.association.pojo.po.Member;
import com.suny.association.pojo.po.MemberRoles;
import com.suny.association.service.interfaces.IAccountService;
import com.suny.association.service.interfaces.IDepartmentService;
import com.suny.association.service.interfaces.IMemberRolesService;
import com.suny.association.service.interfaces.IMemberService;
import com.suny.association.utils.JSONResponseUtil;
import com.suny.association.utils.LocalDateUtils;
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
    
    
    
    
    
    /**
     * 插入一条成员信息
     *
     * @param member 成员信息
     * @return 结果
     */
    @RequestMapping(value = "/insertMemberInfo.json")
    @ResponseBody
    public JSONResponseUtil insertMemberInfo( Member member) {
        if (member == null) {
            throw  new BusinessException(MemberStatusCode.FAIL_INSERT_MEMBER_INFO);
        }
        //插入一条成员信息
        memberService.insertAndGetId(member);
        int memberId = member.getMemberId();
        Account account=accountService.selectByMemberId(memberId);
        if(account==null){
            //准备自动生成一个账号信息
            Account accountAuto = new Account();
            accountAuto.setAccountMemberId(memberId);
            accountService.insertAndGetId(account);
        }
        return JSONResponseUtil.responseSuccessResult(MemberStatusCode.SUCCESS_INSERT_MEMBER_INFO);
    }
    
    /**
     * 进行新增一条成员信息页面
     *
     * @return 结果
     */
    @RequestMapping(value = "/insertMember.html")
    public ModelAndView insertMemberInfo(ModelAndView modelAndView) {
        List<Member> managerList = memberService.selectNormalManager();
        List<Department> departmentList = departmentService.selectForAll();
        List<MemberRoles> memberRolesList = memberRolesService.selectForAll();
        modelAndView.addObject("departmentList", departmentList);
        modelAndView.addObject("memberRolesList", memberRolesList);
        modelAndView.addObject("managerList", managerList);
        modelAndView.addObject("memberGradeList", LocalDateUtils.getLastYearAndThisYears());
        modelAndView.setViewName("/admin/inser-member-info");
        return modelAndView;
    }
    
    
    /**
     * 删除一个成员的信息
     *
     * @param id 成员的id
     * @return JSON数据结果
     */
    @RequestMapping(value = "/deleteById.json/{id}")
    @ResponseBody
    public JSONResponseUtil deleteById(@PathVariable("id") Integer id) {
        if (memberService.selectById(id) != null) {
            memberService.deleteById(id);
            return JSONResponseUtil.responseSuccessResult(MemberStatusCode.SUCCESS_DELETE_MEMBER_INFO);
        }
        return JSONResponseUtil.responseSuccessResult(MemberStatusCode.FAIL_DELETE_MEMBER_INFO);
    }
    
    /**
     * 更新一条信息
     *
     * @param member 要更新的实体
     * @return 结果
     */
    @RequestMapping(value = "/updateMemberInfo.json")
    @ResponseBody
    public JSONResponseUtil updateMemberInfo(Member member) {
        if (member.getMemberId() == null) {
            throw  new BusinessException(MemberStatusCode.FAIL_UPDATE_MEMBER_INFO);
        }
        memberService.update(member);
        return JSONResponseUtil.responseSuccessResult(MemberStatusCode.SUCCESS_UPDATE_MEMBER_INFO);
    }
    
    
    /**
     * 修改一个成员的信息
     *
     * @param id           要修改信息的成员id
     * @param modelAndView 模型和视图数据
     * @return 视图跟数据
     */
    @RequestMapping(value = "/editMember.html/{id}")
    public ModelAndView editMember(@PathVariable("id") Integer id, ModelAndView modelAndView) {
        Member member = memberService.selectById(id);
        List<Member> managerList = memberService.selectNormalManager();
        List<Department> departmentList = departmentService.selectForAll();
        List<MemberRoles> memberRolesList = memberRolesService.selectForAll();
        modelAndView.addObject("member", member);
        modelAndView.addObject("departmentList", departmentList);
        modelAndView.addObject("memberRolesList", memberRolesList);
        modelAndView.addObject("managerList", managerList);
        modelAndView.setViewName("/admin/edit-member");
        return modelAndView;
    }
    
    /**
     * 请求查询member数据库中所有冻结的成员信息
     *
     * @return json格式的数据
     */
    @RequestMapping(value = "/selectFreeze.json")
    @ResponseBody
    public JSONResponseUtil selectFreeze() {
        List<Member> memberList = memberService.selectNormalMember();
        if (memberList != null) {
            return JSONResponseUtil.responseSuccessResultAndResultData(MemberStatusCode.SUCCESS_SELECT_MEMBER_INFO,memberList);
        }
        throw  new BusinessException(MemberStatusCode.FAIL_SELECT_MEMBER_INFO);
    }
    
    /**
     * 请求查询member数据库中所有的未冻结的成员信息
     *
     * @return json格式的数据
     */
    @RequestMapping(value = "/selectNormal.json")
    @ResponseBody
    public JSONResponseUtil selectNormal() {
        List<Member> memberList = memberService.selectNormalMember();
        if (memberList != null) {
            return JSONResponseUtil.responseSuccessResultAndResultData(MemberStatusCode.SUCCESS_SELECT_MEMBER_INFO,memberList);
        }
        throw  new BusinessException(MemberStatusCode.FAIL_SELECT_MEMBER_INFO);
    }
    
    
    /**
     * 请求查询member数据库中所有的数据
     *
     * @return json格式的数据
     */
    @RequestMapping(value = "/selectForAll.json")
    @ResponseBody
    public JSONResponseUtil selectForAll() {
        List<Member> memberList = memberService.selectForAll();
        if (memberList != null) {
            return JSONResponseUtil.responseSuccessResultAndResultData(MemberStatusCode.SUCCESS_SELECT_MEMBER_INFO,memberList);
        }
        throw  new BusinessException(MemberStatusCode.FAIL_SELECT_MEMBER_INFO);
    }
    
    
    /**
     * 进入成员管理页面的请求
     *
     * @return 成员管理页面
     */
    @RequestMapping(value = "/member-manager.html")
    public String systemConfig() {
        return "admin/member-manager";
    }
    
    /**
     * 查询对应成员的一条信息
     *
     * @param memberId 成员的id
     * @return JSON格式的成员信息
     */
    @RequestMapping(value = "/SelectMemberInfo.do")
    public JSONResponseUtil SelectMemberInfo(Integer memberId) {
        Member member = memberService.selectById(memberId);
        return JSONResponseUtil.responseSuccessResultAndResultData(MemberStatusCode.SUCCESS_SELECT_MEMBER_INFO,member);
    }
    
    
    
}

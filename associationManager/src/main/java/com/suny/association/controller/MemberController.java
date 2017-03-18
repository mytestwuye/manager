package com.suny.association.controller;

import com.suny.association.pojo.po.Department;
import com.suny.association.pojo.po.Member;
import com.suny.association.pojo.po.MemberRoles;
import com.suny.association.service.interfaces.IDepartmentService;
import com.suny.association.service.interfaces.IMemberRolesService;
import com.suny.association.service.interfaces.IMemberService;
import com.suny.association.utils.JSONResponseUtil;
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
    
    @Autowired
    private IMemberService memberService;
    
    @Autowired
    private IDepartmentService departmentService;
    
    @Autowired
    private IMemberRolesService memberRolesService;
    
    /**
     * 更新一条信息
     * @param member  要更新的实体
     * @return
     */
    @RequestMapping(value = "/updateMemberInfo.json")
    @ResponseBody
    public JSONResponseUtil updateMemberInfo(Member member) {
        if(member.getMemberId()==null || member == null){
            return JSONResponseUtil.error("没信息怎么更新");
        }
        memberService.update(member);
        return JSONResponseUtil.successMessage("更新成功了");
    }
    
    /**
     * 删除一个成员的信息
     *
     * @param id 成员的id
     * @return JSON数据结果
     */
    @RequestMapping(value = "/deleteById/{id}")
    @ResponseBody
    public JSONResponseUtil deleteById(@PathVariable("id") Integer id) {
        if (memberService.queryById(id) != null) {
            memberService.deleteById(id);
            return JSONResponseUtil.successMessage("删除成功了");
        }
        return JSONResponseUtil.successMessage("删除失败了");
    }
    
    @RequestMapping(value = "/editMember.html/{id}")
    public ModelAndView editMember(@PathVariable("id") Integer id, ModelAndView modelAndView) {
        Member member = memberService.queryById(id);
        List<Member> managerList = memberService.selectNormalManager();
        List<Department> departmentList = departmentService.queryForAll();
        List<MemberRoles> memberRolesList = memberRolesService.queryForAll();
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
            return JSONResponseUtil.success(memberList);
        }
        return JSONResponseUtil.error("出错了，没有查询到");
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
            return JSONResponseUtil.success(memberList);
        }
        return JSONResponseUtil.error("出错了，没有查询到");
    }
    
    
    /**
     * 请求查询member数据库中所有的数据
     *
     * @return json格式的数据
     */
    @RequestMapping(value = "/queryForAll.json")
    @ResponseBody
    public JSONResponseUtil queryForAll() {
        List<Member> memberList = memberService.queryForAll();
        if (memberList != null) {
            return JSONResponseUtil.success(memberList);
        }
        return JSONResponseUtil.error("出错了，没有查询到");
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
        Member member = memberService.queryById(memberId);
        return JSONResponseUtil.success(member);
    }
    
    
}

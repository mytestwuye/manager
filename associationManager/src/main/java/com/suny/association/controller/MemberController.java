package com.suny.association.controller;

import com.suny.association.pojo.po.Member;
import com.suny.association.service.interfaces.IMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    
    
    @RequestMapping("/queryForAll.json")
    public @ResponseBody
    List<Member> queryForAll(){
        List<Member> memberList = memberService.queryForAll();
        return memberList;
    }
    @RequestMapping("/selectForAll.json")
    public @ResponseBody
    List<Member> selectForAll(){
        List<Member> memberList = memberService.queryForAll();
        return memberList;
    }
    
    @RequestMapping("/member-manager.html")
    public String memberManager(){
        List<Member> memberList = memberService.queryForAll();
        return "/admin/member-manager";
    }
    
    
}

package com.suny.association.controller;

import com.suny.association.enums.MemberEnum;
import com.suny.association.pojo.po.Account;
import com.suny.association.service.interfaces.IAccountService;
import com.suny.association.utils.JSONResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Comments:
 * Author:   孙建荣
 * Create Date: 2017/03/22 22:12
 */
@Controller
@RequestMapping("/Account")
public class AccountController {
    
    private final IAccountService accountService;
    
    @Autowired
    public AccountController(IAccountService accountService) {
        this.accountService = accountService;
    }
    
    /**
     * 请求查询member数据库中所有的数据
     *
     * @return json格式的数据
     */
    @RequestMapping(value = "/SelectForAll.json")
    @ResponseBody
    public JSONResultUtil selectForAll() {
        List<Account> accountList = accountService.selectForAll();
        if (accountList != null) {
            return JSONResultUtil.successResultAndData(MemberEnum.SUCCESS_SELECT_MEMBER_INFO, accountList);
        }
        return JSONResultUtil.failResult(MemberEnum.FAIL_SELECT_MEMBER_INFO);
    }
    
    /**
     * 进入账号管理页面的请求
     *
     * @return 成员管理页面
     */
    @RequestMapping(value = "/AccountManager.html")
    public String accountManager() {
        return "/Account/AccountManager";
    }
}

package com.suny.association.controller;

import com.suny.association.enums.MemberEnum;
import com.suny.association.pojo.po.Account;
import com.suny.association.service.interfaces.IAccountService;
import com.suny.association.utils.JsonResult;
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
@RequestMapping("/account")
public class AccountController {
    
    private final IAccountService accountService;
    
    @Autowired
    public AccountController(IAccountService accountService) {
        this.accountService = accountService;
    }
    
    @RequestMapping(value = "/queryAll.json")
    @ResponseBody
    public JsonResult queryAll() {
        List<Account> accountList = accountService.queryAll();
        if (accountList != null) {
            return JsonResult.successResultAndData(MemberEnum.SUCCESS_SELECT_MEMBER_INFO, accountList);
        }
        return JsonResult.failResult(MemberEnum.FAIL_SELECT_MEMBER_INFO);
    }
    
   
    @RequestMapping(value = "/accountManager.html")
    public String accountManager() {
        return "/Account/AccountManager";
    }
}

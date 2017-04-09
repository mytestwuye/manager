package com.suny.association.controller;

import com.suny.association.enums.AccountEnum;
import com.suny.association.pojo.po.Account;
import com.suny.association.pojo.po.Member;
import com.suny.association.pojo.po.Roles;
import com.suny.association.service.interfaces.IAccountService;
import com.suny.association.service.interfaces.IMemberService;
import com.suny.association.service.interfaces.IRolesService;
import com.suny.association.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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

    private final IMemberService memberService;

    private final IRolesService rolesService;
    
    @Autowired
    public AccountController(IAccountService accountService, IMemberService memberService, IRolesService rolesService) {
        this.accountService = accountService;
        this.memberService = memberService;
        this.rolesService = rolesService;
    }

    @RequestMapping(value = "/insert.json",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult insert(@RequestBody Account account) {
        if(account.getAccountName().equals("") && account.getAccountName() == null){
            return JsonResult.failResult(AccountEnum.FAIL_INSERT_ACCOUNT_INFO);
        }
        if(accountService.queryByName(account.getAccountName()) != null){
            return JsonResult.failResult(AccountEnum.REPEAT_ADD);
        }
        accountService.insert(account);
        return JsonResult.successResult(AccountEnum.SUCCESS_INSERT_ACCOUNT_INFO);
    }



    @RequestMapping(value = "/insert.html",method = RequestMethod.GET)
    public ModelAndView insertPage(ModelAndView modelAndView) {
        List<Account> account = accountService.queryAll();
        List<Member> memberList = memberService.queryAll();
        List<Roles> rolesList = rolesService.queryAll();
        modelAndView.addObject("account", account);
        modelAndView.addObject("memberList", memberList);
        modelAndView.addObject("rolesList", rolesList);
        modelAndView.setViewName("accountInfo/accountInsert");
        return modelAndView;
    }


    @RequestMapping(value = "/deleteById.json/{id}",method = RequestMethod.GET)
    @ResponseBody
    public JsonResult deleteById(@PathVariable("id") Integer id) {
        if (accountService.queryById(id) == null) {
            return JsonResult.failResult(AccountEnum.NOT_HAVE_THIS_ACCOUNT_INFO);
        }
        accountService.deleteById(id);
        return JsonResult.successResult(AccountEnum.SUCCESS_DELETE_ACCOUNT_INFO);
    }


    @RequestMapping(value = "/update.json",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult update(@RequestBody Account account) {
        if (accountService.queryByName(account.getAccountName()) == null) {
            return JsonResult.failResult(AccountEnum.NOT_HAVE_THIS_ACCOUNT_INFO);
        }
        accountService.update(account);
        return JsonResult.successResult(AccountEnum.SUCCESS_UPDATE_ACCOUNT_INFO);
    }

    @RequestMapping(value = "/update.html/{id}",method = RequestMethod.GET)
    public ModelAndView updatePage(@PathVariable("id") Integer id, ModelAndView modelAndView) {
        Account account = accountService.queryById(id);
        List<Member> memberList = memberService.queryAll();
        List<Roles> rolesList = rolesService.queryAll();
        modelAndView.addObject("account", account);
        modelAndView.addObject("memberList", memberList);
        modelAndView.addObject("rolesList", rolesList);
        modelAndView.setViewName("/accountInfo/accountUpdate");
        return modelAndView;
    }


    @RequestMapping(value = "/queryAll.json",method = RequestMethod.GET)
    @ResponseBody
    public JsonResult queryAll() {
        List<Account> accountList = accountService.queryAll();
        if (accountList.size() >0 && accountList != null) {
            return JsonResult.successResultAndData(AccountEnum.SUCCESS_DELETE_ACCOUNT_INFO, accountList);
        }
        return JsonResult.failResult(AccountEnum.FAIL_SELECT_ACCOUNT_INFO);
    }
        public void main(){

        }
    
   
    @RequestMapping(value = "/accountManager.html")
    public String accountManager() {
        return "accountInfo/accountManager";
    }
}

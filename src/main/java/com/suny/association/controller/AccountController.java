package com.suny.association.controller;

import com.suny.association.enums.BaseEnum;
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

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static com.suny.association.utils.ConversionUtil.convertToBootstrapTableResult;
import static com.suny.association.utils.ConversionUtil.convertToCriteriaMap;
import static com.suny.association.utils.JsonResult.failResult;
import static com.suny.association.utils.JsonResult.successResult;

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

    @RequestMapping(value = "/insert.json", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult insert(@RequestBody Account account) {
        Map resultMap = updateOrInsert(account);
        if (!(Boolean) resultMap.get("status")) {
            return (JsonResult) resultMap.get("result");
        }
        if ("".equals(account.getAccountPassword())) {
            account.setAccountPassword(null);
        }
        accountService.insert(account);
        return successResult(BaseEnum.ADD_SUCCESS);
    }


    @RequestMapping(value = "/insert.html", method = RequestMethod.GET)
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


    @RequestMapping(value = "/deleteById.json/{accountId}", method = RequestMethod.GET)
    @ResponseBody
    public JsonResult deleteById(@PathVariable("accountId") Long accountId) {
        Account accountQuote = accountService.queryQuoteByAccountId(accountId);
        if (accountQuote != null && (null != accountQuote.getAccountMember())) {
            return failResult(BaseEnum.HAVE_QUOTE);
        }
        if (accountService.queryByLongId(accountId) == null) {
            return failResult(BaseEnum.SELECT_FAILURE);
        }
        accountService.deleteByLongId(accountId);
        return successResult(BaseEnum.DELETE_SUCCESS);
    }

    private Map updateOrInsert(Account account) {
        Map<Object, Object> resultMap = new HashMap<>();
        Account byNameResult = accountService.queryByName(account.getAccountName());
        Account byPhoneResult = accountService.queryByPhone(account.getAccountPhone());
        Account byMailResult = accountService.queryByMail(account.getAccountEmail());
        if ("".equals(account.getAccountName()) || (account.getAccountName() == null)) {
            resultMap.put("result", failResult(BaseEnum.FIELD_NULL));
            resultMap.put("status", Boolean.FALSE);
            return resultMap;
        }
        if (null != byNameResult && !Objects.equals(byNameResult.getAccountId(), account.getAccountId())) {
            resultMap.put("result", failResult(BaseEnum.REPEAT_USERNAME));
            resultMap.put("status", Boolean.FALSE);
            return resultMap;
        }
        if (null != byPhoneResult && !Objects.equals(byPhoneResult.getAccountId(), account.getAccountId())) {
            resultMap.put("result", failResult(BaseEnum.REPEAT_PHONE));
            resultMap.put("status", Boolean.FALSE);
            return resultMap;
        }
        if (null != byMailResult && !Objects.equals(byMailResult.getAccountId(), account.getAccountId())) {
            resultMap.put("result", failResult(BaseEnum.REPEAT_EMAIL));
            resultMap.put("status", Boolean.FALSE);
            return resultMap;
        }
        resultMap.put("status", Boolean.TRUE);
        return resultMap;
    }


    @RequestMapping(value = "/update.json", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult update(@RequestBody Account account) {
        Map resultMap = updateOrInsert(account);
        Account byIdResult = accountService.queryByLongId(account.getAccountId());
        if (byIdResult == null) {
            return failResult(BaseEnum.SELECT_FAILURE);
        }
        if (!(Boolean) resultMap.get("status")) {
            return (JsonResult) resultMap.get("result");
        }
        accountService.update(account);
        return successResult(BaseEnum.UPDATE_SUCCESS);
    }

    @RequestMapping(value = "/update.html/{id}", method = RequestMethod.GET)
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


    @RequestMapping(value = "/queryAll.json", method = RequestMethod.GET)
    @ResponseBody
    public Map<Object, Object> queryAll(@RequestParam(value = "offset", required = false, defaultValue = "0") int offset,
                                        @RequestParam(value = "limit", required = false, defaultValue = "10") int limit,
                                        @RequestParam(value = "status", required = false, defaultValue = "3") int status) {
        int totalCount = accountService.queryCount();
        Map<Object, Object> criteriaMap = convertToCriteriaMap(offset, limit, status);
        List<Account> accountList = accountService.queryAllByCriteria(criteriaMap);
        return convertToBootstrapTableResult(accountList, totalCount);
    }

    @RequestMapping(value = "/accountManager.html")
    public String accountManager() {
        return "accountInfo/accountManager";
    }
}

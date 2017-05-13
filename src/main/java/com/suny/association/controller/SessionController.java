package com.suny.association.controller;

import com.suny.association.annotation.SystemControllerLog;
import com.suny.association.pojo.po.LoginHistory;
import com.suny.association.service.interfaces.IAccountService;
import com.suny.association.service.interfaces.ILoginHistoryService;
import com.suny.association.utils.ConversionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * Comments:    登录记录控制器
 * Author:   孙建荣
 * Create Date: 2017/04/09 14:44
 */
@Controller
@RequestMapping("/session")
public class SessionController extends BaseController {

    private final ILoginHistoryService loginHistoryService;

    @Autowired
    public SessionController(ILoginHistoryService loginHistoryService, IAccountService accountService) {
        this.loginHistoryService = loginHistoryService;
    }

    @RequestMapping(value = "/list.json", method = RequestMethod.GET)
    @ResponseBody
    public Map<Object, Object> query(@RequestParam(value = "offset", required = false, defaultValue = "0") int offset,
                                     @RequestParam(value = "limit", required = false, defaultValue = "10") int limit) {
        List<LoginHistory> loginHistoryList = loginHistoryService.list(ConversionUtil.convertToCriteriaMap(offset, limit));
        int total = loginHistoryService.queryCount();
        return ConversionUtil.convertToBootstrapTableResult(loginHistoryList, total);
    }

    @SystemControllerLog(description = "查询指定账号登录记录")
    @RequestMapping(value = "/queryByMemberId.json", method = RequestMethod.GET)
    @ResponseBody
    public Map<Object, Object> queryById(@RequestParam("memberId") int memberId) {
        List<LoginHistory> loginHistoryList = loginHistoryService.queryByMemberId(memberId);
        return ConversionUtil.convertToBootstrapTableResult(loginHistoryList, 5);
    }

    @SystemControllerLog(description = "查看登录记录页面")
    @RequestMapping(value = "/index.html", method = RequestMethod.GET)
    public String index() {
        return "/session/sessionList";
    }
}




















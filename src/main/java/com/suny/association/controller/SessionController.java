package com.suny.association.controller;

import com.suny.association.enums.LoginHistoryEnum;
import com.suny.association.pojo.po.LoginHistory;
import com.suny.association.service.interfaces.ILoginHistoryService;
import com.suny.association.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Comments:
 * Author:   孙建荣
 * Create Date: 2017/04/09 14:44
 */
@Controller
@RequestMapping("/session")
public class SessionController {

    private final ILoginHistoryService loginHistoryService;

    @Autowired
    public SessionController(ILoginHistoryService loginHistoryService) {
        this.loginHistoryService = loginHistoryService;
    }

    @RequestMapping(value = "list" ,method = RequestMethod.GET)
    @ResponseBody
    public JsonResult query(@RequestParam(value = "offset",required = false,defaultValue = "0") int offset,
                            @RequestParam(value = "limit",required = false,defaultValue = "10") int limit){
        List<LoginHistory> loginHistoryList=loginHistoryService.list(offset,limit);
        int total = loginHistoryService.queryCount();
        Map tableDate = new HashMap();
        tableDate.put("rows", loginHistoryList);
        tableDate.put("total", total);
        return JsonResult.successResultAndData(LoginHistoryEnum.SUCCESS_QUERY,tableDate);
    }

    @RequestMapping(value = "/index" ,method = RequestMethod.GET)
    public String index(){
        return "/session/sessionList";
    }
}




















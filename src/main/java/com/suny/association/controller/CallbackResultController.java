package com.suny.association.controller;

import com.suny.association.pojo.po.CallbackResult;
import com.suny.association.service.interfaces.ICallbackResultService;
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
 * Comments:   审批结果控制
 * Author:   孙建荣
 * Create Date: 2017/04/19 12:50
 */
@Controller
@RequestMapping("/punchLog/applyForResult")
public class CallbackResultController {

    private final ICallbackResultService callbackResultService;

    @Autowired
    public CallbackResultController(ICallbackResultService callbackResultService) {
        this.callbackResultService = callbackResultService;
    }

    @RequestMapping(value = "/list.json", method = RequestMethod.GET)
    @ResponseBody
    public Map<Object, Object> query(@RequestParam(value = "offset", required = false, defaultValue = "0") int offset,
                                     @RequestParam(value = "limit", required = false, defaultValue = "10") int limit) {
        List<CallbackResult> callbackResultList = callbackResultService.list(ConversionUtil.convertToCriteriaMap(offset, limit));
        int total = callbackResultService.queryCount();
        return ConversionUtil.convertToBootstrapTableResult(callbackResultList, total);
    }


    /**
     * 异议考勤审批结果列表
     *
     * @return 当然是页面列表
     */
    @RequestMapping(value = "/index.html", method = RequestMethod.GET)
    public String index() {
        return "/punchLog/applyForResult/result";
    }


}

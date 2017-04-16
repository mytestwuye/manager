package com.suny.association.controller;

import com.suny.association.pojo.po.ApplicationMessage;
import com.suny.association.service.interfaces.IApplicationMessageService;
import com.suny.association.utils.ConversionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

import static com.suny.association.utils.ConversionUtil.convertToCriteriaMap;

/**
 * Comments:
 * Author:   孙建荣
 * Create Date: 2017/04/16 20:55
 */
@Controller
@RequestMapping("/punchLog/applicationMessage")
public class ApplicationController {

    private final IApplicationMessageService applicationMessageService;

    @Autowired
    public ApplicationController(IApplicationMessageService applicationMessageService) {
        this.applicationMessageService = applicationMessageService;
    }


    @RequestMapping(value = "/queryAll.json" ,method = RequestMethod.GET)
    @ResponseBody
    public Map query(@RequestParam(value = "offset",required = false,defaultValue = "0") int offset,
                     @RequestParam(value = "limit",required = false,defaultValue = "10") int limit){
        Map<Object, Object> criteriaMap = convertToCriteriaMap(offset, limit);
        List<ApplicationMessage> punchRecordList=applicationMessageService.queryAllByCriteria(criteriaMap);
        int total = applicationMessageService.queryCount();
        return ConversionUtil.convertToBootstrapTableResult(punchRecordList,total);
    }

    @RequestMapping(value = "/index.html" ,method = RequestMethod.GET)
    public String index(){
        return "/punchLog/application/messageList";
    }
}

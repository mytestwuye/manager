package com.suny.association.controller;

import com.suny.association.pojo.po.Operation;
import com.suny.association.service.interfaces.IOperationService;
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
 * Create Date: 2017/04/10 13:20
 */
@Controller
@RequestMapping(value = "/operations/log")
public class OperationInfoController {

    private final IOperationService operationService;

    @Autowired
    public OperationInfoController(IOperationService operationService) {
        this.operationService = operationService;
    }

    @RequestMapping(value = "list.json" ,method = RequestMethod.GET)
    @ResponseBody
    public Map query(@RequestParam(value = "offset",required = false,defaultValue = "0") int offset,
                     @RequestParam(value = "limit",required = false,defaultValue = "10") int limit){
        List<Operation> operationList=operationService.list(offset,limit);
        int total = operationService.queryCount();
        Map tableDate = new HashMap();
        tableDate.put("rows", operationList);
        tableDate.put("total", total);
        return tableDate;
    }

    @RequestMapping(value = "/index.html" ,method = RequestMethod.GET)
    public String index(){
        return "/operations/operationList";
    }
}

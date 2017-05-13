package com.suny.association.controller;

import com.suny.association.annotation.SystemControllerLog;
import com.suny.association.pojo.po.OperationLog;
import com.suny.association.service.interfaces.IOperationLogService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

import static com.suny.association.utils.ConversionUtil.convertToBootstrapTableResult;
import static com.suny.association.utils.ConversionUtil.convertToCriteriaMap;

/**
 * Comments:   操作记录控制器
 * Author:   孙建荣
 * Create Date: 2017/04/10 13:20
 */
@Controller
@RequestMapping(value = "/operations/log")
public class OperationLogController extends BaseController {

    private final IOperationLogService operationLogService;

    @Autowired
    public OperationLogController(IOperationLogService operationLogService) {
        this.operationLogService = operationLogService;
    }

    /**
     * 带查询条件的操作记录查询
     *
     * @param offset 从第几条开始查询
     * @param limit  查几个数据
     * @return 带查询条件的数据
     */
    @RequiresPermissions("operation:log:read")
    @RequestMapping(value = "/list.json", method = RequestMethod.GET)
    @ResponseBody
    public Map query(@RequestParam(value = "offset", required = false, defaultValue = "0") int offset,
                     @RequestParam(value = "limit", required = false, defaultValue = "10") int limit) {
        List<OperationLog> operationLogList = operationLogService.list(convertToCriteriaMap(offset, limit));
        int total = operationLogService.queryCount();
        return convertToBootstrapTableResult(operationLogList, total);
    }

    @RequiresPermissions("operation:log:read")
    @SystemControllerLog(description = "查看操作记录页面")
    @RequestMapping(value = "/index.html", method = RequestMethod.GET)
    public String index() {
        return "/operations/operationList";
    }
}

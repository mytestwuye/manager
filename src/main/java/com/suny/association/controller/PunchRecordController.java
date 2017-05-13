package com.suny.association.controller;

import com.suny.association.annotation.SystemControllerLog;
import com.suny.association.pojo.po.PunchRecord;
import com.suny.association.service.interfaces.IPunchRecordService;
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
 * Comments:  考勤记录控制器
 * Author:   孙建荣
 * Create Date: 2017/04/11 13:16
 */
@RequestMapping("/punchLog")
@Controller
public class PunchRecordController extends BaseController {

    private final IPunchRecordService punchRecordService;


    @Autowired
    public PunchRecordController(IPunchRecordService punchRecordService) {
        this.punchRecordService = punchRecordService;
    }

    @RequestMapping(value = "/list.json", method = RequestMethod.GET)
    @ResponseBody
    public Map query(@RequestParam(value = "offset", required = false, defaultValue = "0") int offset,
                     @RequestParam(value = "limit", required = false, defaultValue = "10") int limit) {
        List<PunchRecord> punchRecordList = punchRecordService.list(ConversionUtil.convertToCriteriaMap(offset, limit));
        int total = punchRecordService.queryCount();
        return ConversionUtil.convertToBootstrapTableResult(punchRecordList, total);
    }

    @SystemControllerLog(description = "查看考勤记录页面")
    @RequestMapping(value = "/index.html", method = RequestMethod.GET)
    public String index() {
        return "/punchLog/punchLogList";
    }
}

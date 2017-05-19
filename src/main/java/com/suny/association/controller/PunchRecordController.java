package com.suny.association.controller;

import com.suny.association.annotation.SystemControllerLog;
import com.suny.association.enums.BaseEnum;
import com.suny.association.pojo.po.Member;
import com.suny.association.pojo.po.PunchRecord;
import com.suny.association.service.interfaces.IMemberService;
import com.suny.association.service.interfaces.IPunchRecordService;
import com.suny.association.utils.ConversionUtil;
import com.suny.association.utils.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Comments:  考勤记录控制器
 * Author:   孙建荣
 * Create Date: 2017/04/11 13:16
 */
@RequestMapping("/punchLog")
@Controller
public class PunchRecordController extends BaseController {
    private static final Logger logger = LoggerFactory.getLogger(PunchRecordController.class);
    private final IPunchRecordService punchRecordService;
    private final IMemberService memberService;

    @Autowired
    public PunchRecordController(IPunchRecordService punchRecordService, IMemberService memberService) {
        this.punchRecordService = punchRecordService;
        this.memberService = memberService;
    }

    @SystemControllerLog(description = "考勤操作")
    @RequestMapping(value = "/update.json", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult update(HttpServletRequest request, @RequestParam("punchMemberId") Integer punchMemberId) {
        /*   获取session中的Member信息，用来判断用户是否恶意操作   */
        Member member = (Member) request.getSession().getAttribute("member");
        if (member == null) {
            logger.error("987，没有登录，无法操作");
            return JsonResult.failResult(BaseEnum.NO_LOGIN_IN);
        }
        if (!Objects.equals(member.getMemberId(), punchMemberId)) {
            logger.info("211,要操作的Member主键Id与Session中保存的Member主键Id不同，属于恶意操作");
            return JsonResult.failResult(BaseEnum.MALICIOUS_OPERATION);
        } else {
            Member databaseMember = memberService.queryById(punchMemberId);
            if (databaseMember == null) {
                logger.info("005，数据库没有查询考勤的成员Id，恶意操作");
                return JsonResult.failResult(BaseEnum.SELECT_FAILURE);
            } else {
                PunchRecord punchRecord = punchRecordService.queryByMemberIdAndDate(punchMemberId);
                if (punchRecord != null) {
                    if (!punchRecord.getPunchTypeId().getPunchTypeId().equals(0)) {
                        logger.warn("212,{}今天已经签到过了", member.getMemberName());
                        return JsonResult.failResult(BaseEnum.REPEAT_PUNCH);
                    } else {
                        logger.info("{}开始进行考勤", member.getMemberName());
                        int successRow = punchRecordService.updatePunch(punchMemberId, punchRecord.getPunchRecordId());
                        if (successRow == 0) {
                            logger.info("215,{}考勤失败", member.getMemberName());
                            return JsonResult.successResult(BaseEnum.PUNCH_FAIL);
                        }
                    }
                } else {
                        /*   系统设计是考勤当天首先由管理员开始考勤，然后系统自动给每一个成员添加一条缺勤记录   */
                    logger.warn("213,管理员还没有开启签到！");
                    return JsonResult.failResult(BaseEnum.TIME_NOT_REACH);
                }
            }
        }
        logger.info("214,{}考勤成功", member.getMemberName());
        return JsonResult.successResult(BaseEnum.PUNCH_SUCCESS);
    }


    @SystemControllerLog(description = "考勤操作")
    @RequestMapping(value = "/insert.json", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult insert(@RequestParam("memberId") Long punchMemberId) {
        return null;
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

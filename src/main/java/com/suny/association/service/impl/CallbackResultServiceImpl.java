package com.suny.association.service.impl;

import com.suny.association.mapper.CallbackResultMapper;
import com.suny.association.mapper.MemberMapper;
import com.suny.association.pojo.po.ApplicationMessage;
import com.suny.association.pojo.po.CallbackResult;
import com.suny.association.pojo.po.Member;
import com.suny.association.service.AbstractBaseServiceImpl;
import com.suny.association.service.interfaces.ICallbackResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Comments:   审批结果逻辑控制
 * Author:   孙建荣
 * Create Date: 2017/03/07 22:33
 */
@Service
public class CallbackResultServiceImpl extends AbstractBaseServiceImpl<CallbackResult> implements ICallbackResultService {

    private CallbackResultMapper callbackResultMapper;

    private MemberMapper memberMapper;

    @Autowired
    public CallbackResultServiceImpl(CallbackResultMapper callbackResultMapper, MemberMapper memberMapper) {
        this.callbackResultMapper = callbackResultMapper;
        this.memberMapper = memberMapper;
    }

    public CallbackResultServiceImpl() {
    }

    /**
     * 组成一条审批结果
     *
     * @param applicationMessage 一条异议申请记录
     * @param managerId          审批的管理员
     * @param resultStatus       审批的结果
     */
    @Transactional(rollbackFor = {Exception.class})
    public CallbackResult makeUpCallBackResult(ApplicationMessage applicationMessage, int managerId, Boolean resultStatus) {
        Member manager = memberMapper.queryById(managerId);
        CallbackResult callbackResult = new CallbackResult();
        callbackResult.setApplicationMessageId(applicationMessage);
        callbackResult.setCallbackManagerId(manager);
        callbackResult.setCallbackResult(resultStatus);
        return callbackResult;
    }


    /**
     * 插入一条审批结果
     *
     * @param callbackResult 审批结果
     */
    @Transactional(rollbackFor = {Exception.class})
    @Override
    public void insert(CallbackResult callbackResult) {
        callbackResultMapper.insert(callbackResult);
    }

    @Override
    public CallbackResult queryById(int id) {
        return callbackResultMapper.queryById(id);
    }

    @Override
    public CallbackResult queryByName(String name) {
        return callbackResultMapper.queryByName(name);
    }

    @Override
    public int queryCount() {
        return callbackResultMapper.queryCount();
    }

    /**
     * 条件查询审批记录
     *
     * @param criteriaMap 封装的查询条件
     * @return 审批记录
     */
    @Override
    public List<CallbackResult> list(Map criteriaMap) {
        return callbackResultMapper.list(criteriaMap);
    }
}

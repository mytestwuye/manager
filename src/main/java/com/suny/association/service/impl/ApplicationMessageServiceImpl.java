package com.suny.association.service.impl;

import com.suny.association.mapper.ApplicationMessageMapper;
import com.suny.association.pojo.po.ApplicationMessage;
import com.suny.association.pojo.po.CallbackResult;
import com.suny.association.service.AbstractBaseServiceImpl;
import com.suny.association.service.interfaces.IApplicationMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Comments:   考勤记录异议申请业务逻辑
 * Author:   孙建荣
 * Create Date: 2017/03/07 22:30
 */
@Service
public class ApplicationMessageServiceImpl extends AbstractBaseServiceImpl<ApplicationMessage> implements IApplicationMessageService {

    private ApplicationMessageMapper applicationMessageMapper;

    @Autowired
    public ApplicationMessageServiceImpl(ApplicationMessageMapper applicationMessageMapper) {
        this.applicationMessageMapper = applicationMessageMapper;
    }

    public ApplicationMessageServiceImpl() {
    }


    @Override
    public void insert(ApplicationMessage applicationMessage) {
        applicationMessageMapper.insert(applicationMessage);
    }

    @Override
    public ApplicationMessage queryById(int id) {
        return applicationMessageMapper.queryById(id);
    }

    @Override
    public ApplicationMessage queryByName(String name) {
        return applicationMessageMapper.queryByName(name);
    }

    @Override
    public int queryCount() {
        return applicationMessageMapper.queryCount();
    }

    /**
     * 条件查询异议考勤记录
     *
     * @param criteriaMap 封装查询条件
     * @return 带查询条件的记录
     */
    @Override
    public List<ApplicationMessage> list(Map<Object, Object> criteriaMap) {
        return applicationMessageMapper.list(criteriaMap);
    }


    /**
     * 更新异议考勤申请数据中的结果
     *
     * @param applicationMessage 要更新的一条数据
     * @param callbackResult     审批结果
     */
    @Override
    public void updateApplyForResult(ApplicationMessage applicationMessage, CallbackResult callbackResult) {
        applicationMessage.setApplicationResult(callbackResult);
        this.update(applicationMessage);
    }

    /**
     * 更新一条异议考勤申请记录
     *
     * @param applicationMessage 异议考勤信息
     */
    @Transactional(rollbackFor = {Exception.class})
    @Override
    public void update(ApplicationMessage applicationMessage) {
        applicationMessageMapper.update(applicationMessage);
    }
}

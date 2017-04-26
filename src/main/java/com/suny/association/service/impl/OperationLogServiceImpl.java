package com.suny.association.service.impl;

import com.suny.association.annotation.SystemServiceLog;
import com.suny.association.mapper.OperationLogMapper;
import com.suny.association.pojo.po.OperationLog;
import com.suny.association.service.AbstractBaseServiceImpl;
import com.suny.association.service.interfaces.IOperationLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Comments:  操作记录业务逻辑
 * Author:   孙建荣
 * Create Date: 2017/03/07 22:38
 */
@Service
public class OperationLogServiceImpl extends AbstractBaseServiceImpl<OperationLog> implements IOperationLogService {

    private final OperationLogMapper operationLogMapper;


    @Autowired
    public OperationLogServiceImpl(OperationLogMapper operationLogMapper) {
        this.operationLogMapper = operationLogMapper;
    }

    /*   通过名字去查询操作记录   */
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    @Override
    public OperationLog queryByName(String name) {
        return operationLogMapper.queryByName(name);
    }

    /*   查询操作记录的总记录数   */
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    @Override
    public int queryCount() {
        return operationLogMapper.queryCount();
    }

    /*   通过查询条件查询操作记录   */
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    @Override
    public List<OperationLog> list(Map<Object, Object> criteriaMap) {
        return operationLogMapper.list(criteriaMap);
    }

    /*   插入一条操作记录   */
    @SystemServiceLog(description = "插入一条操作记录失败")
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void insert(OperationLog operationLog) {
        operationLogMapper.insert(operationLog);
    }
}

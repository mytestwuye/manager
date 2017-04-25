package com.suny.association.service.impl;

import com.suny.association.mapper.OperationLogMapper;
import com.suny.association.pojo.po.OperationLog;
import com.suny.association.service.AbstractBaseServiceImpl;
import com.suny.association.service.interfaces.IOperationLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


    @Override
    public OperationLog queryByName(String name) {
        return operationLogMapper.queryByName(name);
    }

    @Override
    public int queryCount() {
        return operationLogMapper.queryCount();
    }

    @Override
    public List<OperationLog> list(Map<Object, Object> criteriaMap) {
        return operationLogMapper.list(criteriaMap);
    }

    @Override
    public void insert(OperationLog operationLog) {
        operationLogMapper.insert(operationLog);
    }
}

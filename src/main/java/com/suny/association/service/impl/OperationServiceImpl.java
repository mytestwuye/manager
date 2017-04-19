package com.suny.association.service.impl;

import com.suny.association.mapper.OperationMapper;
import com.suny.association.pojo.po.Operation;
import com.suny.association.service.AbstractBaseServiceImpl;
import com.suny.association.service.interfaces.IOperationService;
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
public class OperationServiceImpl extends AbstractBaseServiceImpl<Operation> implements IOperationService {

    private final OperationMapper operationMapper;


    @Autowired
    public OperationServiceImpl(OperationMapper operationMapper) {
        this.operationMapper = operationMapper;
    }


    @Override
    public Operation queryByName(String name) {
        return operationMapper.queryByName(name);
    }

    @Override
    public int queryCount() {
        return operationMapper.queryCount();
    }

    @Override
    public List<Operation> list(Map<Object, Object> criteriaMap) {
        return operationMapper.list(criteriaMap);
    }
}

package com.suny.association.service.impl;

import com.suny.association.mapper.OperationMapper;
import com.suny.association.pojo.po.Operation;
import com.suny.association.service.AbstractBaseServiceImpl;
import com.suny.association.service.interfaces.IOperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Comments:
 * Author:   孙建荣
 * Create Date: 2017/03/07 22:38
 */
@Service
public class OperationServiceImpl extends AbstractBaseServiceImpl<Operation> implements IOperationService {
    private  OperationMapper operationMapper;
    
    @Autowired
    public OperationServiceImpl(OperationMapper operationMapper) {
        this.operationMapper = operationMapper;
    }
    
    public OperationServiceImpl() {
    }
    
    
}

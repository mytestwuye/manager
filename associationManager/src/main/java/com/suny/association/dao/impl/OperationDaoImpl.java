package com.suny.association.dao.impl;

import com.suny.association.dao.AbstractBaseDaoImpl;
import com.suny.association.dao.interfaces.IOperationDao;
import com.suny.association.mapper.OperationMapper;
import com.suny.association.mapper.interfaces.IMapper;
import com.suny.association.pojo.po.Operation;

/**
 * Comments:
 * Author:   孙建荣
 * Create Date: 2017/03/07 21:30
 */
public class OperationDaoImpl extends AbstractBaseDaoImpl<Operation> implements IOperationDao {
    private OperationMapper operationMapper;

    public OperationDaoImpl(IMapper<Operation> mapper, OperationMapper operationMapper) {
        super(mapper);
        this.operationMapper = operationMapper;
    }

    public OperationMapper getOperationMapper() {
        return operationMapper;
    }

    public void setOperationMapper(OperationMapper operationMapper) {
        this.operationMapper = operationMapper;
    }
}

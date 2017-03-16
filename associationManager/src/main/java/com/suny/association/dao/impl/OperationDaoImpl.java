package com.suny.association.dao.impl;

import com.suny.association.dao.AbstractBaseDaoImpl;
import com.suny.association.dao.interfaces.IOperationDao;
import com.suny.association.mapper.OperationMapper;
import com.suny.association.mapper.interfaces.IMapper;
import com.suny.association.pojo.po.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Comments:
 * Author:   孙建荣
 * Create Date: 2017/03/07 21:30
 */
@Repository
public  class OperationDaoImpl extends AbstractBaseDaoImpl<Operation> implements IOperationDao {
    @Autowired
    private OperationMapper operationMapper;
    
    public OperationDaoImpl(){
        
    }
    
    public OperationDaoImpl(OperationMapper operationMapper) {
        this.operationMapper = operationMapper;
    }
    
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
    
    public void create(Operation operation) {
        if(operation != null){
            operationMapper.create(operation);
        }
    }
    
    public Operation select(int id) {
        return operationMapper.select(id);
    }
    
    public void update(Operation operation) {
        if(operation != null){
            operationMapper.update(operation);
        }
    }
    
    public void delete(int id) {
        operationMapper.delete(id);
    }
    
    public List<Operation> selectAll() {
        return operationMapper.selectAll();
    }
}

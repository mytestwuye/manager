package com.suny.association.dao.impl;

import com.suny.association.dao.AbstractBaseDaoImpl;
import com.suny.association.dao.interfaces.IApplicationMessageDao;
import com.suny.association.mapper.ApplicationMessageMapper;
import com.suny.association.mapper.interfaces.IMapper;
import com.suny.association.pojo.po.ApplicationMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Comments:   申请表dao
 * Author:   孙建荣
 * Create Date: 2017/03/07 21:19
 */
@Repository
public  class ApplicationMessageDaoImpl extends AbstractBaseDaoImpl<ApplicationMessage> implements IApplicationMessageDao {
    
    @Autowired
    private ApplicationMessageMapper applicationMessageMapper;
    
    public ApplicationMessageDaoImpl() {
    }
    
    public ApplicationMessageDaoImpl(IMapper<ApplicationMessage> mapper) {
        super(mapper);
    }
    
    public ApplicationMessageMapper getApplicationMessageMapper() {
        return applicationMessageMapper;
    }
    
    public void setApplicationMessageMapper(ApplicationMessageMapper applicationMessageMapper) {
        this.applicationMessageMapper = applicationMessageMapper;
    }
    
    @Override
    public void create(ApplicationMessage applicationMessage) {
        if(applicationMessage != null){
            applicationMessageMapper.create(applicationMessage);
        }
    }
    
    @Override
    public ApplicationMessage select(int id) {
        return applicationMessageMapper.select(id);
    }
    
    @Override
    public void update(ApplicationMessage applicationMessage) {
        if(applicationMessage != null){
            applicationMessageMapper.update(applicationMessage);
        }
    }
    
    @Override
    public void delete(int id) {
        applicationMessageMapper.delete(id);
    }
    
    @Override
    public List<ApplicationMessage> selectAll() {
        return applicationMessageMapper.selectAll();
    }
}

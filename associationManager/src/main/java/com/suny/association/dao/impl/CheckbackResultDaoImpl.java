package com.suny.association.dao.impl;

import com.suny.association.dao.AbstractBaseDaoImpl;
import com.suny.association.dao.interfaces.ICheckbackResultDao;
import com.suny.association.mapper.CheckbackResultMapper;
import com.suny.association.mapper.interfaces.IMapper;
import com.suny.association.pojo.po.CheckbackResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Comments:
 * Author:   孙建荣
 * Create Date: 2017/03/07 21:23
 */
@Repository
public  class CheckbackResultDaoImpl extends AbstractBaseDaoImpl<CheckbackResult> implements ICheckbackResultDao {
    
    @Autowired
    private CheckbackResultMapper checkbackResultMapper;
    
    public CheckbackResultDaoImpl(){
        
    }
    
    public CheckbackResultDaoImpl(CheckbackResultMapper checkbackResultMapper) {
        this.checkbackResultMapper = checkbackResultMapper;
    }
    

    public CheckbackResultDaoImpl(IMapper<CheckbackResult> mapper, CheckbackResultMapper checkbackResultMapper) {

        super(mapper);
        this.checkbackResultMapper = checkbackResultMapper;
    }
    
    public CheckbackResultMapper getCheckbackResultMapper() {
        return checkbackResultMapper;
    }
    
    public void setCheckbackResultMapper(CheckbackResultMapper checkbackResultMapper) {
        this.checkbackResultMapper = checkbackResultMapper;
    }
    
    @Override
    public void create(CheckbackResult checkbackResult) {
        if(checkbackResult != null){
            checkbackResultMapper.create(checkbackResult);
        }
    }
    
    @Override
    public CheckbackResult select(int id) {
        return checkbackResultMapper.select(id);
    }
    
    @Override
    public void update(CheckbackResult checkbackResult) {
        if(checkbackResult != null){
            checkbackResultMapper.update(checkbackResult);
        }
    }
    
    @Override
    public void delete(int id) {
        checkbackResultMapper.delete(id);
    }
    
    @Override
    public List<CheckbackResult> selectAll() {
        return checkbackResultMapper.selectAll();
    }
}

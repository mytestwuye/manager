package com.suny.association.dao.impl;

import com.suny.association.dao.AbstractBaseDaoImpl;
import com.suny.association.dao.interfaces.IPunchTypeDao;
import com.suny.association.mapper.PunchTypeMapper;
import com.suny.association.mapper.interfaces.IMapper;
import com.suny.association.pojo.po.PunchType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Comments:
 * Author:   孙建荣
 * Create Date: 2017/03/07 21:31
 */
@Repository
public  class PunchTypeDaoImpl extends AbstractBaseDaoImpl<PunchType> implements IPunchTypeDao{
    
     @Autowired
    private PunchTypeMapper punchTypeMapper;
    
    public PunchTypeDaoImpl() {
    }
    
    public PunchTypeDaoImpl(IMapper<PunchType> mapper, PunchTypeMapper punchTypeMapper) {

        super(mapper);
        this.punchTypeMapper = punchTypeMapper;
    }
    
    public PunchTypeMapper getPunchTypeMapper() {
        return punchTypeMapper;
    }
    
    public void setPunchTypeMapper(PunchTypeMapper punchTypeMapper) {
        this.punchTypeMapper = punchTypeMapper;
    }
    
    @Override
    public void create(PunchType punchType) {
        if(punchType !=  null){
            punchTypeMapper.create(punchType);
        }
    }
    
    @Override
    public PunchType select(int id) {
        return punchTypeMapper.select(id);
    }
    
    @Override
    public void update(PunchType punchType) {
        if(punchType != null){
            punchTypeMapper.update(punchType);
        }
    }
    
    @Override
    public void delete(int id) {
        punchTypeMapper.delete(id);
    }
    
    @Override
    public List<PunchType> selectAll() {
        return punchTypeMapper.selectAll();
    }
}

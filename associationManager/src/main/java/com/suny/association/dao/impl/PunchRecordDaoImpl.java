package com.suny.association.dao.impl;

import com.suny.association.dao.AbstractBaseDaoImpl;
import com.suny.association.dao.interfaces.IPunchRecordDao;
import com.suny.association.mapper.PunchRecordMapper;
import com.suny.association.mapper.interfaces.IMapper;
import com.suny.association.pojo.po.PunchRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Comments:
 * Author:   孙建荣
 * Create Date: 2017/03/07 21:31
 */
@Repository
public  class PunchRecordDaoImpl extends AbstractBaseDaoImpl<PunchRecord> implements IPunchRecordDao {
    
    @Autowired
    private PunchRecordMapper punchRecordMapper;
    
    
    public PunchRecordDaoImpl() {
    }
    
    public PunchRecordDaoImpl(IMapper<PunchRecord> mapper, PunchRecordMapper punchRecordMapper) {

        super(mapper);
        this.punchRecordMapper = punchRecordMapper;
    }
    
    public PunchRecordMapper getPunchRecordMapper() {
        return punchRecordMapper;
    }
    
    public void setPunchRecordMapper(PunchRecordMapper punchRecordMapper) {
        this.punchRecordMapper = punchRecordMapper;
    }
    
    @Override
    public void create(PunchRecord punchRecord) {
        if(punchRecord != null){
            punchRecordMapper.create(punchRecord);
        }
    }
    
    @Override
    public PunchRecord select(int id) {
        return punchRecordMapper.select(id);
    }
    
    @Override
    public void update(PunchRecord punchRecord) {
        if(punchRecord != null){
            punchRecordMapper.update(punchRecord);
        }
    }
    
    @Override
    public void delete(int id) {
        punchRecordMapper.delete(id);
    }
    
    @Override
    public List<PunchRecord> selectAll() {
        return punchRecordMapper.selectAll();
    }
}

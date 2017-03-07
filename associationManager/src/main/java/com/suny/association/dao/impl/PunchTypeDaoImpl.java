package com.suny.association.dao.impl;

import com.suny.association.dao.AbstractBaseDaoImpl;
import com.suny.association.dao.interfaces.IPunchTypeDao;
import com.suny.association.mapper.PunchTypeMapper;
import com.suny.association.mapper.interfaces.IMapper;
import com.suny.association.pojo.po.PunchType;

/**
 * Comments:
 * Author:   孙建荣
 * Create Date: 2017/03/07 21:31
 */
public class PunchTypeDaoImpl extends AbstractBaseDaoImpl<PunchType> implements IPunchTypeDao{

    private PunchTypeMapper punchTypeMapper;

    public PunchTypeMapper getPunchTypeMapper() {
        return punchTypeMapper;
    }

    public void setPunchTypeMapper(PunchTypeMapper punchTypeMapper) {
        this.punchTypeMapper = punchTypeMapper;
    }

    public PunchTypeDaoImpl(IMapper<PunchType> mapper, PunchTypeMapper punchTypeMapper) {

        super(mapper);
        this.punchTypeMapper = punchTypeMapper;
    }
}

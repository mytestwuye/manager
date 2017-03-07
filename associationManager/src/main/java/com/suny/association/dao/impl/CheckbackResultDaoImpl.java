package com.suny.association.dao.impl;

import com.suny.association.dao.AbstractBaseDaoImpl;
import com.suny.association.dao.interfaces.ICheckbackResultDao;
import com.suny.association.mapper.CheckbackResultMapper;
import com.suny.association.mapper.interfaces.IMapper;
import com.suny.association.pojo.po.CheckbackResult;

/**
 * Comments:
 * Author:   孙建荣
 * Create Date: 2017/03/07 21:23
 */
public class CheckbackResultDaoImpl extends AbstractBaseDaoImpl<CheckbackResult> implements ICheckbackResultDao {
    private CheckbackResultMapper checkbackResultMapper;

    public CheckbackResultMapper getCheckbackResultMapper() {
        return checkbackResultMapper;
    }

    public void setCheckbackResultMapper(CheckbackResultMapper checkbackResultMapper) {
        this.checkbackResultMapper = checkbackResultMapper;
    }

    public CheckbackResultDaoImpl(IMapper<CheckbackResult> mapper, CheckbackResultMapper checkbackResultMapper) {

        super(mapper);
        this.checkbackResultMapper = checkbackResultMapper;
    }
}

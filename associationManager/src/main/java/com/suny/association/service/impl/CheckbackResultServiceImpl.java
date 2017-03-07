package com.suny.association.service.impl;

import com.suny.association.dao.IBaseDao;
import com.suny.association.dao.interfaces.ICheckbackResultDao;
import com.suny.association.pojo.po.CheckbackResult;
import com.suny.association.service.AbstractBaseServiceImpl;
import com.suny.association.service.interfaces.ICheckbackResultService;

/**
 * Comments:
 * Author:   孙建荣
 * Create Date: 2017/03/07 22:33
 */
public class CheckbackResultServiceImpl extends AbstractBaseServiceImpl<CheckbackResult> implements ICheckbackResultService {

    private ICheckbackResultDao iCheckbackResultDao;

    public ICheckbackResultDao getiCheckbackResultDao() {
        return iCheckbackResultDao;
    }

    public void setiCheckbackResultDao(ICheckbackResultDao iCheckbackResultDao) {
        this.iCheckbackResultDao = iCheckbackResultDao;
    }

    public CheckbackResultServiceImpl(IBaseDao<CheckbackResult> iBaseDao, ICheckbackResultDao iCheckbackResultDao) {

        super(iBaseDao);
        this.iCheckbackResultDao = iCheckbackResultDao;
    }
}

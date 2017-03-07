package com.suny.association.service.impl;

import com.suny.association.dao.IBaseDao;
import com.suny.association.dao.interfaces.IOperationDao;
import com.suny.association.pojo.po.Operation;
import com.suny.association.service.AbstractBaseServiceImpl;
import com.suny.association.service.interfaces.IOperationService;

/**
 * Comments:
 * Author:   孙建荣
 * Create Date: 2017/03/07 22:38
 */
public class OperationServiceImpl extends AbstractBaseServiceImpl<Operation> implements IOperationService {

    private IOperationDao iOperationDao;

    public IOperationDao getiOperationDao() {
        return iOperationDao;
    }

    public void setiOperationDao(IOperationDao iOperationDao) {
        this.iOperationDao = iOperationDao;
    }

    public OperationServiceImpl(IBaseDao<Operation> iBaseDao, IOperationDao iOperationDao) {

        super(iBaseDao);
        this.iOperationDao = iOperationDao;
    }
}

package com.suny.association.service.impl;

import com.suny.association.dao.IBaseDao;
import com.suny.association.pojo.po.LoginHistory;
import com.suny.association.service.AbstractBaseServiceImpl;
import com.suny.association.service.interfaces.ILoginHistoryService;

/**
 * Comments:
 * Author:   孙建荣
 * Create Date: 2017/03/07 22:34
 */
public class LoginHistoryServiceImpl extends AbstractBaseServiceImpl<LoginHistory> implements ILoginHistoryService {
    private ILoginHistoryService iLoginHistoryService;

    public ILoginHistoryService getiLoginHistoryService() {
        return iLoginHistoryService;
    }

    public void setiLoginHistoryService(ILoginHistoryService iLoginHistoryService) {
        this.iLoginHistoryService = iLoginHistoryService;
    }

    public LoginHistoryServiceImpl(IBaseDao<LoginHistory> iBaseDao, ILoginHistoryService iLoginHistoryService) {
        super(iBaseDao);

        this.iLoginHistoryService = iLoginHistoryService;
    }
}

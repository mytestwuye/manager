package com.suny.association.service.impl;

import com.suny.association.dao.IBaseDao;
import com.suny.association.dao.interfaces.ILoginHistoryDao;
import com.suny.association.pojo.po.LoginHistory;
import com.suny.association.service.AbstractBaseServiceImpl;
import com.suny.association.service.interfaces.ILoginHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Comments:
 * Author:   孙建荣
 * Create Date: 2017/03/07 22:34
 */
@Service
public class LoginHistoryServiceImpl extends AbstractBaseServiceImpl<LoginHistory> implements ILoginHistoryService {
    @Autowired
    private ILoginHistoryDao loginHistoryDao;
    
    public LoginHistoryServiceImpl() {
    }
    
    public LoginHistoryServiceImpl(IBaseDao<LoginHistory> iBaseDao) {
        super(iBaseDao);
    }
    
    public ILoginHistoryDao getLoginHistoryDao() {
        return loginHistoryDao;
    }
    
    public void setLoginHistoryDao(ILoginHistoryDao loginHistoryDao) {
        this.loginHistoryDao = loginHistoryDao;
    }
}

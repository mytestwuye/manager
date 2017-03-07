package com.suny.association.service.impl;

import com.suny.association.dao.IBaseDao;
import com.suny.association.dao.interfaces.IAccountDao;
import com.suny.association.pojo.po.Account;
import com.suny.association.service.AbstractBaseServiceImpl;
import com.suny.association.service.interfaces.IAccountService;

/**
 * Comments:
 * Author:   孙建荣
 * Create Date: 2017/03/07 22:18
 */
public class AccountServiceImpl extends AbstractBaseServiceImpl<Account> implements IAccountService {

    private IAccountDao iAccountDao;

    public AccountServiceImpl(IBaseDao<Account> iBaseDao, IAccountDao iAccountDao) {
        super(iBaseDao);
        this.iAccountDao = iAccountDao;
    }

    public IAccountDao getiAccountDao() {
        return iAccountDao;
    }

    public void setiAccountDao(IAccountDao iAccountDao) {
        this.iAccountDao = iAccountDao;
    }
}

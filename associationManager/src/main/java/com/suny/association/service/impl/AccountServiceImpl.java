package com.suny.association.service.impl;

import com.suny.association.dao.IBaseDao;
import com.suny.association.dao.interfaces.IAccountDao;
import com.suny.association.pojo.po.Account;
import com.suny.association.service.AbstractBaseServiceImpl;
import com.suny.association.service.interfaces.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Comments:  账号表service类
 * Author:   孙建荣
 * Create Date: 2017/03/07 22:18
 */
@Service
public class AccountServiceImpl extends AbstractBaseServiceImpl<Account> implements IAccountService {

    @Autowired
    private IAccountDao accountDao;

    @Override
    public Account selectByUserName(String username) {
        return accountDao.selectByUserName(username);
    }
    
    @Override
    public void add(Account account) {
        accountDao.create(account);
    }
    
    public AccountServiceImpl() {

    }
    
    public AccountServiceImpl(IBaseDao<Account> iBaseDao) {
        super(iBaseDao);
    }
    
    public IAccountDao getAccountDao() {
        return accountDao;
    }
    
    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }
}

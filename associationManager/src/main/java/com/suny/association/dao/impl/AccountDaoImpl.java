package com.suny.association.dao.impl;

import com.suny.association.dao.AbstractBaseDaoImpl;
import com.suny.association.dao.interfaces.IAccountDao;
import com.suny.association.mapper.AccountMapper;
import com.suny.association.mapper.interfaces.IMapper;
import com.suny.association.pojo.po.Account;

/**
 * Comments:
 * Author:   孙建荣
 * Create Date: 2017/03/07 21:15
 */
public class AccountDaoImpl  extends AbstractBaseDaoImpl<Account> implements IAccountDao {

    private AccountMapper accountMapper;

    public AccountDaoImpl(IMapper<Account> mapper, AccountMapper accountMapper) {
        super(mapper);
        this.accountMapper = accountMapper;
    }

    public AccountMapper getAccountMapper() {

        return accountMapper;
    }

    public void setAccountMapper(AccountMapper accountMapper) {
        this.accountMapper = accountMapper;
    }




}

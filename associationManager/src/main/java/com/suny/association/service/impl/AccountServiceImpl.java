package com.suny.association.service.impl;

import com.suny.association.mapper.AccountMapper;
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
    
    private AccountMapper accountMapper;
    
    public AccountServiceImpl() {
    }
    
    @Autowired
    public AccountServiceImpl(AccountMapper accountMapper) {
        this.accountMapper = accountMapper;
    }
    
    @Override
    public Account selectByUserName(String username) {
        return accountMapper.selectByUserName(username);
    }
    
    @Override
    public void insert(Account account) {
        accountMapper.insert(account);
    }
    
    @Override
    public int insertAndGetId(Account account) {
        return accountMapper.insertAndGetId(account);
    }
    
   
    
    
}

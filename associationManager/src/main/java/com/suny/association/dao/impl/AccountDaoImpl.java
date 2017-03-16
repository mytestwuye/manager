package com.suny.association.dao.impl;

import com.suny.association.dao.AbstractBaseDaoImpl;
import com.suny.association.dao.interfaces.IAccountDao;
import com.suny.association.mapper.AccountMapper;
import com.suny.association.mapper.interfaces.IMapper;
import com.suny.association.pojo.po.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Comments:
 * Author:   孙建荣
 * Create Date: 2017/03/07 21:15
 */
@Repository
public class AccountDaoImpl extends AbstractBaseDaoImpl<Account> implements IAccountDao {
    
    @Autowired
    private AccountMapper accountMapper;
    
    /**
     * 通过用户名查询账号信息
     *
     * @param username 用户名
     * @return 账号对应的信息
     */
    @Override
    public Account selectByUserName(String username) {
        return accountMapper.selectByUserName(username);
        
    }
    
    @Override
    public void create(Account account) {
        if (account != null) {
            accountMapper.create(account);
        }
    }
    
    @Override
    public Account select(int id) {
        return accountMapper.select(id);
    }
    
    @Override
    public void update(Account account) {
        if (account != null) {
            accountMapper.update(account);
        }
    }
    
    @Override
    public void delete(int id) {
        accountMapper.delete(id);
    }
    
    @Override
    public List<Account> selectAll() {
        return accountMapper.selectAll();
    }
    
    
    
    public AccountDaoImpl() {
    }
    
    public AccountDaoImpl(IMapper<Account> mapper) {
        super(mapper);
    }
    
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

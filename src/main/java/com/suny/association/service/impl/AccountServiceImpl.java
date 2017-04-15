package com.suny.association.service.impl;

import com.suny.association.enums.BaseEnum;
import com.suny.association.enums.MemberEnum;
import com.suny.association.exception.BusinessException;
import com.suny.association.mapper.AccountMapper;
import com.suny.association.pojo.po.Account;
import com.suny.association.service.AbstractBaseServiceImpl;
import com.suny.association.service.interfaces.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Comments:  账号表service类
 * Author:   孙建荣
 * Create Date: 2017/03/07 22:18
 */
@Service
public class AccountServiceImpl extends AbstractBaseServiceImpl<Account> implements IAccountService {
    private final AccountMapper accountMapper;



    @Autowired
    public AccountServiceImpl(AccountMapper accountMapper) {
        this.accountMapper = accountMapper;
    }


    @Transactional
    @Override
    public void insert(Account account) {
        if (account == null) {
            throw new BusinessException(BaseEnum.ADD_FAILURE);
        }
        try {
            accountMapper.insert(account);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteById(int id) {
        accountMapper.deleteById(id);
    }

    @Override
    public void update(Account account) {
        accountMapper.update(account);
    }

    @Override
    public Account queryById(int id) {
        return accountMapper.queryById(id);
    }


    @Override
    public Account queryByPhone(Long phoneNumber) {
        return accountMapper.queryByPhone(phoneNumber);
    }


    @Override
    public Account queryByMail(String email) {
        return accountMapper.queryByMail(email);
    }

    @Override
    public Account queryByLongId(Long id) {
        return accountMapper.queryByLongId(id);
    }

    @Override
    public Account queryQuote(Long accountId) {
        return accountMapper.queryQuote(accountId);
    }

    @Override
    public Account queryByName(String name) {
        return accountMapper.queryByName(name);
    }

    @Override
    public void deleteByLongId(Long id) {
         accountMapper.deleteByLongId(id);
    }

    @Override
    public List<Account> queryAllByCriteria(Map<Object,Object> criteriaMap) {
        return accountMapper.queryAllByCriteria(criteriaMap);
    }
}

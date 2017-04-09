package com.suny.association.service.impl;

import com.suny.association.mapper.LoginHistoryMapper;
import com.suny.association.pojo.po.LoginHistory;
import com.suny.association.service.AbstractBaseServiceImpl;
import com.suny.association.service.interfaces.ILoginHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Comments:
 * Author:   孙建荣
 * Create Date: 2017/03/07 22:34
 */
@Service
public class LoginHistoryServiceImpl extends AbstractBaseServiceImpl<LoginHistory> implements ILoginHistoryService {
    private  LoginHistoryMapper loginHistoryMapper;
    
    @Autowired
    public LoginHistoryServiceImpl(LoginHistoryMapper loginHistoryMapper) {
        this.loginHistoryMapper = loginHistoryMapper;
    }


    @Override
    public List<LoginHistory> list(int offset,int limit){
        return loginHistoryMapper.list(offset,limit);
    }

    @Override
    public int queryCount() {
        return loginHistoryMapper.queryCount();
    }

    public LoginHistoryServiceImpl() {
    }
    
   
}

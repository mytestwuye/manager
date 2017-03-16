package com.suny.association.dao.impl;

import com.suny.association.dao.AbstractBaseDaoImpl;
import com.suny.association.dao.interfaces.ILoginHistoryDao;
import com.suny.association.mapper.LoginHistoryMapper;
import com.suny.association.mapper.interfaces.IMapper;
import com.suny.association.pojo.po.LoginHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Comments:
 * Author:   孙建荣
 * Create Date: 2017/03/07 21:25
 */
@Repository
public  class LoginHistoryDaoImpl extends AbstractBaseDaoImpl<LoginHistory> implements ILoginHistoryDao {
    @Autowired
    private LoginHistoryMapper loginHistoryMapper;
    
    public LoginHistoryDaoImpl(){
        
    }
    
    public LoginHistoryDaoImpl(LoginHistoryMapper loginHistoryMapper) {
        this.loginHistoryMapper = loginHistoryMapper;
    }
    
    public LoginHistoryDaoImpl(IMapper<LoginHistory> mapper, LoginHistoryMapper loginHistoryMapper) {

        super(mapper);
        this.loginHistoryMapper = loginHistoryMapper;
    }
    
    public LoginHistoryMapper getLoginHistoryMapper() {
        return loginHistoryMapper;
    }
    
    public void setLoginHistoryMapper(LoginHistoryMapper loginHistoryMapper) {
        this.loginHistoryMapper = loginHistoryMapper;
    }
    
    @Override
    public void create(LoginHistory loginHistory) {
        if(loginHistory != null){
            loginHistoryMapper.create(loginHistory);
        }
    }
    
    @Override
    public LoginHistory select(int id) {
        return loginHistoryMapper.select(id);
    }
    
    @Override
    public void update(LoginHistory loginHistory) {
        if(loginHistory != null){
            loginHistoryMapper.update(loginHistory);
        }
    }
    
    @Override
    public void delete(int id) {
        loginHistoryMapper.delete(id);
    }
    
    @Override
    public List<LoginHistory> selectAll() {
        return loginHistoryMapper.selectAll();
    }
}

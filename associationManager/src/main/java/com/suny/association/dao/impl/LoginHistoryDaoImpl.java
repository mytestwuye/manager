package com.suny.association.dao.impl;

import com.suny.association.dao.AbstractBaseDaoImpl;
import com.suny.association.dao.interfaces.ILoginHistoryDao;
import com.suny.association.mapper.LoginHistoryMapper;
import com.suny.association.mapper.interfaces.IMapper;
import com.suny.association.pojo.po.LoginHistory;

/**
 * Comments:
 * Author:   孙建荣
 * Create Date: 2017/03/07 21:25
 */
public class LoginHistoryDaoImpl extends AbstractBaseDaoImpl<LoginHistory> implements ILoginHistoryDao {
    private LoginHistoryMapper loginHistoryMapper;

    public LoginHistoryMapper getLoginHistoryMapper() {
        return loginHistoryMapper;
    }

    public void setLoginHistoryMapper(LoginHistoryMapper loginHistoryMapper) {
        this.loginHistoryMapper = loginHistoryMapper;
    }

    public LoginHistoryDaoImpl(IMapper<LoginHistory> mapper, LoginHistoryMapper loginHistoryMapper) {

        super(mapper);
        this.loginHistoryMapper = loginHistoryMapper;
    }
}

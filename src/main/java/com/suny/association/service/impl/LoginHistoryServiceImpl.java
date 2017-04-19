package com.suny.association.service.impl;

import com.suny.association.mapper.LoginHistoryMapper;
import com.suny.association.pojo.po.LoginHistory;
import com.suny.association.service.AbstractBaseServiceImpl;
import com.suny.association.service.interfaces.ILoginHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Comments:  登录历史记录业务逻辑
 * Author:   孙建荣
 * Create Date: 2017/03/07 22:34
 */
@Service
public class LoginHistoryServiceImpl extends AbstractBaseServiceImpl<LoginHistory> implements ILoginHistoryService {
    private LoginHistoryMapper loginHistoryMapper;

    @Autowired
    public LoginHistoryServiceImpl(LoginHistoryMapper loginHistoryMapper) {
        this.loginHistoryMapper = loginHistoryMapper;
    }

    public LoginHistoryServiceImpl() {
    }


    @Override
    public List<LoginHistory> list(Map<Object, Object> criteriaMap) {
        return loginHistoryMapper.list(criteriaMap);
    }

    @Override
    public LoginHistory queryByName(String name) {
        return loginHistoryMapper.queryByName(name);
    }

    @Override
    public int queryCount() {
        return loginHistoryMapper.queryCount();
    }


}

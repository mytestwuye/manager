package com.suny.association.service.impl;

import com.suny.association.mapper.AccountMapper;
import com.suny.association.mapper.LoginHistoryMapper;
import com.suny.association.pojo.po.Account;
import com.suny.association.pojo.po.LoginHistory;
import com.suny.association.pojo.po.baiduLocation.GeneralLocationResult;
import com.suny.association.service.AbstractBaseServiceImpl;
import com.suny.association.service.interfaces.ILoginHistoryService;
import com.suny.association.utils.CustomDate;
import com.suny.association.utils.LoginUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import static com.suny.association.utils.LoginUtils.getOSVersion;

/**
 * Comments:  登录历史记录业务逻辑
 * Author:   孙建荣
 * Create Date: 2017/03/07 22:34
 */
@Service
public class LoginHistoryServiceImpl extends AbstractBaseServiceImpl<LoginHistory> implements ILoginHistoryService {
    private LoginHistoryMapper loginHistoryMapper;

    private AccountMapper accountMapper;

    @Autowired
    public LoginHistoryServiceImpl(LoginHistoryMapper loginHistoryMapper, AccountMapper accountMapper) {
        this.loginHistoryMapper = loginHistoryMapper;
        this.accountMapper = accountMapper;
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

    @Override
    public void insert(LoginHistory loginHistory) {
        loginHistoryMapper.insert(loginHistory);
    }

    /**
     * 收集用户登录信息
     *
     * @param userAgent 用户代理
     * @param username  登录的用户名
     * @param loginIp   登录的ip
     */
    @Override
    public void makeUpLoginInfo(String userAgent, String username, String loginIp, boolean authStatus) {
        String loginBrowser = LoginUtils.getBrowserInfo(userAgent);
        LoginHistory loginHistory = new LoginHistory();
        loginHistory.setLoginUserAgent(userAgent);
        loginHistory.setLastLoginIp(loginIp);
        loginHistory.setLastLoginTime(CustomDate.getCurrentDateTime());
        loginHistory.setLoginBrowser(loginBrowser);
        loginHistory.setLoginOsVersion(getOSVersion(userAgent));
        loginHistory.setLoginStatus(authStatus);
        Account account = accountMapper.queryByName(username);
        loginHistory.setHistoryAccountId(account);
        GeneralLocationResult generalLocation = LoginUtils.getGeneralLocation(loginIp);
//        GeneralLocationResult generalLocation=new GeneralLocationResult();
//        generalLocation.setStatus(0);
//        generalLocation.setAddress("江西现代职业技术学院");
        if (generalLocation != null) {
            loginHistory.setLoginAddress(generalLocation.getStatus() == 0 ? generalLocation.getAddress() : "未知位置");
        } else {
            loginHistory.setLoginAddress("未知位置");
        }
        insert(loginHistory);
    }

    @Override
    public List<LoginHistory> queryByMemberId(int memberId) {
        return loginHistoryMapper.queryByMemberId(memberId);
    }
}

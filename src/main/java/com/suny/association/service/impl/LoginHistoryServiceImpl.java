package com.suny.association.service.impl;

import com.suny.association.annotation.SystemServiceLog;
import com.suny.association.mapper.AccountMapper;
import com.suny.association.mapper.LoginHistoryMapper;
import com.suny.association.pojo.po.Account;
import com.suny.association.pojo.po.LoginHistory;
import com.suny.association.pojo.po.baiduLocation.GeneralLocationResult;
import com.suny.association.service.AbstractBaseServiceImpl;
import com.suny.association.service.interfaces.ILoginHistoryService;
import com.suny.association.utils.CustomDate;
import com.suny.association.utils.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

import static com.suny.association.utils.WebUtils.getOSVersion;

/**
 * Comments:  登录历史记录业务逻辑
 * Author:   孙建荣
 * Create Date: 2017/03/07 22:34
 */
@Service
public class LoginHistoryServiceImpl extends AbstractBaseServiceImpl<LoginHistory> implements ILoginHistoryService {

    private static final Logger logger = LoggerFactory.getLogger(LoginHistoryServiceImpl.class);

    private LoginHistoryMapper loginHistoryMapper;

    private AccountMapper accountMapper;

    @Autowired
    public LoginHistoryServiceImpl(LoginHistoryMapper loginHistoryMapper, AccountMapper accountMapper) {
        this.loginHistoryMapper = loginHistoryMapper;
        this.accountMapper = accountMapper;
    }

    public LoginHistoryServiceImpl() {
    }

    /**
     * 通过查询条件查询账号登录记录
     *
     * @param criteriaMap 自己封装的查询条件
     * @return 带查询条件的登录记录
     */
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    @Override
    public List<LoginHistory> list(Map<Object, Object> criteriaMap) {
        return loginHistoryMapper.list(criteriaMap);
    }

    /*  通过登录用户名查询登录记录 */
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    @Override
    public LoginHistory queryByName(String name) {
        return loginHistoryMapper.queryByName(name);
    }

    /* 查询数据库里面的登录记录条数  */
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    @Override
    public int queryCount() {
        return loginHistoryMapper.queryCount();
    }

    /* 插入一条登录历史记录  */
    @SystemServiceLog(description = "插入登录历史记录失败")
    @Transactional(rollbackFor = Exception.class)
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
    @SystemServiceLog(description = "组装的登录信息插入失败")
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void makeUpLoginInfo(String userAgent, String username, String loginIp, boolean authStatus) {
         /*  通过userAgent分析触登录的浏览器  */
        String loginBrowser = WebUtils.getBrowserInfo(userAgent);
         /*  手动new一个登录历史对象，然后往里面填充对象     */
        LoginHistory loginHistory = new LoginHistory();
        /* 填充userAgent  */
        loginHistory.setLoginUserAgent(userAgent);
        /* 填充用户登录的ip  */
        loginHistory.setLastLoginIp(loginIp);
        /*  填充用户登录的时间，可选，不填充则数据库生成 */
        loginHistory.setLastLoginTime(CustomDate.getCurrentDateTime());
        /* 填充登录的浏览器信息  */
        loginHistory.setLoginBrowser(loginBrowser);
        /*  填充登录用户的浏览器版本 */
        loginHistory.setLoginOsVersion(getOSVersion(userAgent));
        /* 填充用户登录验证账号密码的状态   true为认证成功   false则为认证失败 */
        loginHistory.setLoginStatus(authStatus);
        /*  通过登录的用户名查询触对应的一条账号信息    */
        Account account = accountMapper.queryByName(username);
        /* 填充 字段 登录用户   */
        loginHistory.setHistoryAccountId(account);
        /*  通过ip地址去获取普通的定位地址  */
        GeneralLocationResult generalLocation = WebUtils.getGeneralLocation(loginIp);
        /*  如果得到的普通定位地址为空的话就给登录地址自动设置一个默认的值      */
        if (generalLocation != null) {
            loginHistory.setLoginAddress(generalLocation.getStatus() == 0 ? generalLocation.getAddress() : "未知位置");
        } else {
            logger.warn("连接网络可能出了点问题，把操作位置默认设为未知位置");
            loginHistory.setLoginAddress("未知位置");
        }
        insert(loginHistory);
    }

    /*  通过成员的id去查询一条登录历史记录  */
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    @Override
    public List<LoginHistory> queryByMemberId(int memberId) {
        return loginHistoryMapper.queryByMemberId(memberId);
    }
}

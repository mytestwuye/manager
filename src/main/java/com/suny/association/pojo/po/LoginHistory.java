package com.suny.association.pojo.po;

import java.util.Date;

public class LoginHistory {
    private Long loginHistoryId;

    private Account historyAccountId;

    private String lastLoginIp;

    private String loginAddress;

    private Date lastLoginTime;

    private String loginBrowser;

    private String loginOsVersion;

    private String loginUserAgent;

    private boolean loginStatus;

    public LoginHistory() {
    }

    public LoginHistory(Long loginHistoryId, Account historyAccountId, String lastLoginIp, String loginAddress, Date lastLoginTime, String loginBrowser, String loginOsVersion, String loginUserAgent, boolean loginStatus) {
        this.loginHistoryId = loginHistoryId;
        this.historyAccountId = historyAccountId;
        this.lastLoginIp = lastLoginIp;
        this.loginAddress = loginAddress;
        this.lastLoginTime = lastLoginTime;
        this.loginBrowser = loginBrowser;
        this.loginOsVersion = loginOsVersion;
        this.loginUserAgent = loginUserAgent;
        this.loginStatus = loginStatus;
    }

    public Long getLoginHistoryId() {
        return loginHistoryId;
    }

    public void setLoginHistoryId(Long loginHistoryId) {
        this.loginHistoryId = loginHistoryId;
    }

    public Account getHistoryAccountId() {
        return historyAccountId;
    }

    public void setHistoryAccountId(Account historyAccountId) {
        this.historyAccountId = historyAccountId;
    }

    public String getLastLoginIp() {
        return lastLoginIp;
    }

    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
    }

    public String getLoginAddress() {
        return loginAddress;
    }

    public void setLoginAddress(String loginAddress) {
        this.loginAddress = loginAddress;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getLoginBrowser() {
        return loginBrowser;
    }

    public void setLoginBrowser(String loginBrowser) {
        this.loginBrowser = loginBrowser;
    }

    public String getLoginOsVersion() {
        return loginOsVersion;
    }

    public void setLoginOsVersion(String loginOsVersion) {
        this.loginOsVersion = loginOsVersion;
    }

    public String getLoginUserAgent() {
        return loginUserAgent;
    }

    public void setLoginUserAgent(String loginUserAgent) {
        this.loginUserAgent = loginUserAgent;
    }

    public boolean isLoginStatus() {
        return loginStatus;
    }

    public void setLoginStatus(boolean loginStatus) {
        this.loginStatus = loginStatus;
    }
}
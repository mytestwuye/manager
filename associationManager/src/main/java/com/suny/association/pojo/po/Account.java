package com.suny.association.pojo.po;

import java.io.Serializable;

public class Account implements Serializable{
    private Long accountId;

    private String accountName;

    private String accountPassword;

    private Integer accountPhone;

    private String accountEmail;

    private Boolean accountStatus;

    private Integer accountRoleId;

    private Integer accountMemberId;

    public Account(Long accountId, String accountName, String accountPassword, Integer accountPhone, String accountEmail, Boolean accountStatus, Integer accountRoleId, Integer accountMemberId) {
        this.accountId = accountId;
        this.accountName = accountName;
        this.accountPassword = accountPassword;
        this.accountPhone = accountPhone;
        this.accountEmail = accountEmail;
        this.accountStatus = accountStatus;
        this.accountRoleId = accountRoleId;
        this.accountMemberId = accountMemberId;
    }

    public Account() {
        super();
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName == null ? null : accountName.trim();
    }

    public String getAccountPassword() {
        return accountPassword;
    }

    public void setAccountPassword(String accountPassword) {
        this.accountPassword = accountPassword == null ? null : accountPassword.trim();
    }

    public Integer getAccountPhone() {
        return accountPhone;
    }

    public void setAccountPhone(Integer accountPhone) {
        this.accountPhone = accountPhone;
    }

    public String getAccountEmail() {
        return accountEmail;
    }

    public void setAccountEmail(String accountEmail) {
        this.accountEmail = accountEmail == null ? null : accountEmail.trim();
    }

    public Boolean getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(Boolean accountStatus) {
        this.accountStatus = accountStatus;
    }

    public Integer getAccountRoleId() {
        return accountRoleId;
    }

    public void setAccountRoleId(Integer accountRoleId) {
        this.accountRoleId = accountRoleId;
    }

    public Integer getAccountMemberId() {
        return accountMemberId;
    }

    public void setAccountMemberId(Integer accountMemberId) {
        this.accountMemberId = accountMemberId;
    }
    
    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                ", accountName='" + accountName + '\'' +
                ", accountPassword='" + accountPassword + '\'' +
                ", accountPhone=" + accountPhone +
                ", accountEmail='" + accountEmail + '\'' +
                ", accountStatus=" + accountStatus +
                ", accountRoleId=" + accountRoleId +
                ", accountMemberId=" + accountMemberId +
                '}';
    }
}
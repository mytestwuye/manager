package com.suny.association.pojo.po;

import java.io.Serializable;

public class Account implements Serializable{
    
    private Long accountId;

    private String accountName;

    private String accountPassword;

    private Integer accountPhone;

    private String accountEmail;

    private Boolean accountStatus;

    private Roles accountRoles;

    private Member accountMember;
    
    
    public Account() {
    }
    
    
    public Account(Long accountId, String accountName, String accountPassword, Integer accountPhone, String accountEmail, Boolean accountStatus, Roles accountRoles, Member accountMember) {
        this.accountId = accountId;
        this.accountName = accountName;
        this.accountPassword = accountPassword;
        this.accountPhone = accountPhone;
        this.accountEmail = accountEmail;
        this.accountStatus = accountStatus;
        this.accountRoles = accountRoles;
        this.accountMember = accountMember;
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
        this.accountName = accountName;
    }
    
    public String getAccountPassword() {
        return accountPassword;
    }
    
    public void setAccountPassword(String accountPassword) {
        this.accountPassword = accountPassword;
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
        this.accountEmail = accountEmail;
    }
    
    public Boolean getAccountStatus() {
        return accountStatus;
    }
    
    public void setAccountStatus(Boolean accountStatus) {
        this.accountStatus = accountStatus;
    }
    
    public Roles getAccountRoles() {
        return accountRoles;
    }
    
    public void setAccountRoles(Roles accountRoles) {
        this.accountRoles = accountRoles;
    }
    
    public Member getAccountMember() {
        return accountMember;
    }
    
    public void setAccountMember(Member accountMember) {
        this.accountMember = accountMember;
    }
}

package com.suny.association.realm;

import com.suny.association.enums.BaseEnum;
import com.suny.association.exception.BusinessException;
import com.suny.association.service.interfaces.IAccountService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

/**
 * Comments:   判断用户登陆shiro
 * Author:   孙建荣
 * Create Date: 2017/03/08 16:37
 */
@Component
public class LoginRealm extends AuthorizingRealm {
    
    private final IAccountService accountService;
    
    @Autowired
    public LoginRealm(IAccountService accountService) {
        this.accountService = accountService;
    }
    
    /**
     * 授权
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        Set<String> roleNames = new HashSet<String>();
        Set<String> permissions = new HashSet<String>();
        roleNames.add("administrator");    //角色权限
        permissions.add("newPage.jhtml");    //添加权限
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo(roleNames);
        simpleAuthorizationInfo.setStringPermissions(permissions);
        System.out.println("授权认证被执行");
        return simpleAuthorizationInfo;
    }
    
    /**
     * 登陆验证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
        //根据用户名查询一个用户的信息
        com.suny.association.pojo.po.Account account = accountService.queryByName(usernamePasswordToken.getUsername());
        if (account != null) {
            return new SimpleAuthenticationInfo(account.getAccountName(), account.getAccountPassword(), getName());
        }
        throw new BusinessException(BaseEnum.LOGIN_VERIFY_FAILURE);
    }
}














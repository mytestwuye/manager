package com.suny.association.realm;

import com.suny.association.enums.BaseStatusCode;
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
    
    @Autowired
    private IAccountService accountService;
    
    
    
    /**
     * 授权
     *
     * @param principalCollection
     * @return
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
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
        //根据用户名查询一个用户的信息
        com.suny.association.pojo.po.Account account = accountService.selectByUserName(usernamePasswordToken.getUsername());
        if (account != null ) {
            return new SimpleAuthenticationInfo(account.getAccountName(), account.getAccountPassword(), getName());
        }
        throw new BusinessException(BaseStatusCode.LOGIN_VERIFY_FAILURE);
    }
}














package com.suny.association.shiro;

import com.suny.association.enums.BaseEnum;
import com.suny.association.exception.BusinessException;
import com.suny.association.pojo.po.Roles;
import com.suny.association.service.interfaces.IAccountService;
import com.suny.association.service.interfaces.IRolesService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger logger = LoggerFactory.getLogger(LoginRealm.class);

    private final IAccountService accountService;

    private final IRolesService rolesService;

    @Autowired
    public LoginRealm(IAccountService accountService, IRolesService rolesService) {
        this.accountService = accountService;
        this.rolesService = rolesService;
    }

    /**
     * 授权，验证权限
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("进入用户权限验证doGetAuthorizationInfo()方法");
        com.suny.association.pojo.po.Account token = accountService.queryByName((String) SecurityUtils.getSubject().getPrincipal());
        /* 等到账号的角色   */
        Integer roleId = token.getAccountRoles().getRoleId();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        /*   根据用户id去查询用户的角色   */
        Roles roles = rolesService.queryById(roleId);
        /*  构建一个角色集合，我这里一个账号就是对应着一个角色  */
        Set<String> roleNames = new HashSet<>();
        roleNames.add(roles.getRoleName());
        /*  把角色放进SimpleAuthorizationInfo里面去   */
        info.setRoles(roleNames);
        /*   根据用户id去查询权限(permission),放入到Authorization里面    */
        Set<String> permissions = new HashSet<String>();
        permissions.add("select");
        /*  把权限放进SimpleAuthorizationInfo里面去   */
        info.setStringPermissions(permissions);
//        roleNames.add("administrator");    //角色权限
//        permissions.add("newPage.jhtml");    //添加权限
//        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo(roleNames);
//        simpleAuthorizationInfo.setStringPermissions(permissions);
        System.out.println("授权认证被执行");
        return info;
    }

    /**
     * 登陆验证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("触发账号验证");
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
        //根据用户名查询一个用户的信息
        com.suny.association.pojo.po.Account account = accountService.queryByName(usernamePasswordToken.getUsername());
        if (account != null) {
            System.out.println("存在用户账号，准备验证密码是否正确");
            return new SimpleAuthenticationInfo(account.getAccountName(), account.getAccountPassword(), getName());
        }

        throw new BusinessException(BaseEnum.LOGIN_FAILURE);
    }
}














package com.suny.association.Filter;


import com.suny.association.pojo.po.Account;
import com.suny.association.pojo.po.Permission;
import com.suny.association.pojo.po.PermissionAllot;
import com.suny.association.pojo.po.Roles;
import com.suny.association.service.interfaces.IPermissionAllotService;
import com.suny.association.service.interfaces.IRolesService;
import org.slf4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Comments:   权限控制过滤器
 * Author:   孙建荣
 * Create Date: 2017/05/11 21:28
 */
public class PermissionFilter implements Filter {

    private static final Logger logger = org.slf4j.LoggerFactory.getLogger(PermissionFilter.class);

    private IRolesService rolesService;

    private IPermissionAllotService permissionAllotService;


    /**
     * 解决过滤器在SpringMVC之前运行
     *
     * @param filterConfig
     * @throws ServletException
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        ServletContext servletContext = filterConfig.getServletContext();
        ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(servletContext);
        rolesService = (IRolesService) context.getBean("rolesService");
        permissionAllotService = (IPermissionAllotService) context.getBean("permissionAllotService");
        logger.info("过滤器开始执行");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        Set<HashSet<String>> roleAndPermission = new HashSet<>();
        HttpServletRequest request1 = (HttpServletRequest) request;
        HttpServletResponse response1 = (HttpServletResponse) response;
        Account account = (Account) request1.getSession().getAttribute("account");
        if (account == null) {
            logger.error("未获取到用户的信息，没有登录");
            response1.sendRedirect("/index.jsp");
        } else {
        /* 等到账号的角色   */
            Integer roleId = account.getAccountRoles().getRoleId();
        /*   根据用户id去查询用户的角色   */
            Roles roles = rolesService.queryById(roleId);
        /*  构建一个角色集合，我这里一个账号就是对应着一个角色  */
            HashSet<String> roleNames = new HashSet<>();
            roleNames.add(roles.getRoleName());
        /*  把角色放进SimpleAuthorizationInfo里面去   */
            roleAndPermission.add(roleNames);
        /*   根据用户id去查询权限(permission),放入到Authorization里面    */
            HashSet<String> permissions = new HashSet<>();
            List<PermissionAllot> permissionAllotList = permissionAllotService.queryByRoleId(roleId);
            //  首先进行判断，防止角色没有权限导致数据下标溢出
            if (permissionAllotList.size() > 0) {
                List<Permission> permissionArrayList = permissionAllotList.get(0).getPermissionArrayList();
                permissions.addAll(permissionArrayList.stream().map(Permission::getpermissionName).collect(Collectors.toList()));
                  /*  把用户的所有权限放进SimpleAuthorizationInfo里面去   */
                roleAndPermission.add(permissions);
                for (int i = 0; i < permissionArrayList.size(); i++) {
                    logger.info("登录用户拥有的权限:" + permissionAllotList.get(0).getPermissionArrayList().get(i).getpermissionName());
                }
            } else {
                logger.error("用户没有权限访问这个页面");
                response1.sendRedirect("/403.jsp");
            }
        }
        chain.doFilter(request, response);

    }

    @Override
    public void destroy() {
        logger.info("过滤器开始销毁");
    }
}






























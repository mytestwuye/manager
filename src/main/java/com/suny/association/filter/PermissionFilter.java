package com.suny.association.filter;


import com.suny.association.pojo.po.*;
import com.suny.association.service.interfaces.IAccessPermissionService;
import com.suny.association.service.interfaces.IPermissionAllotService;
import com.suny.association.service.interfaces.IRolesService;
import org.slf4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
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

    private IAccessPermissionService accessPermissionService;


    /**
     * 解决过滤器在SpringMVC之前运行
     *
     * @param filterConfig 配置属性
     */
    @Override
    public void init(FilterConfig filterConfig) {
        ServletContext servletContext = filterConfig.getServletContext();
        ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(servletContext);
        rolesService = (IRolesService) context.getBean("rolesService");
        permissionAllotService = (IPermissionAllotService) context.getBean("permissionAllotService");
        accessPermissionService = (IAccessPermissionService) context.getBean("accessPermissionService");
        logger.info("===============权限验证过滤器开始初始化============");
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        String path = request.getRequestURI();
        Account account = (Account) request.getSession().getAttribute("account");
        HttpSession session = request.getSession(false);
        logger.info("session创建时间:" + session.getCreationTime());
        logger.info("session上次交互时间:" + session.getLastAccessedTime());
        logger.info("session最大过期时间:" + session.getMaxInactiveInterval());
        // session为空则会话过期
        if (path.endsWith("index.jsp") || path.endsWith("/base/loginPage.html")) {
            logger.info("============用户请求登录页面==================");
            chain.doFilter(req, resp);
        } else if (path.endsWith("/403.jsp")) {
            logger.info("=============没有权限页面=============");
            chain.doFilter(req, resp);
        } else if (path.endsWith("/code/generateCode.do")) {
            logger.info("==============请求验证码=================");
            chain.doFilter(req, resp);
        } else if (path.endsWith("/code/checkCode.do")) {
            logger.info("==============验证验证码正确性=================");
            chain.doFilter(req, resp);
        } else if (path.endsWith("/base/loginAction.json")) {
            logger.info("==============请求登录验证===============");
            chain.doFilter(req, resp);
        } else {
            // 如果账号不为空就说明登录过了，是请求操作
            if (account != null) {
                if (path.endsWith("/base/goAdminPage.html")) {
                    logger.info("==============进入管理页面===============");
                    chain.doFilter(req, resp);
                } else {
                         /* 等到账号的角色   */
                    Integer roleId = account.getAccountRoles().getRoleId();
                    /*   根据用户id去查询用户的角色   */
                    Roles roles = rolesService.queryById(roleId);
                 /*  构建一个角色集合，我这里一个账号就是对应着一个角色  */
                /*  把角色放进SimpleAuthorizationInfo里面去   */
                 /*   根据用户id去查询权限(permission),放入到Authorization里面    */
                    HashSet<String> permissions = new HashSet<>();
                    List<PermissionAllot> permissionAllotList = permissionAllotService.queryByRoleId(roleId);
                    //  首先进行判断，防止角色没有权限导致数据下标溢出
                    if (permissionAllotList.size() > 0) {
                        List<Permission> permissionArrayList = permissionAllotList.get(0).getPermissionArrayList();
                        permissions.addAll(permissionArrayList.stream().map(Permission::getpermissionName).collect(Collectors.toList()));
                    /*  把用户的所有权限放进SimpleAuthorizationInfo里面去   */
                        AccessPermission accessPermission = accessPermissionService.queryByName(path);
                        if (accessPermission == null) {
                            logger.info("这个页面不需要权限就可以访问");
                            chain.doFilter(req, resp);
                        } else {
                            //  获取当前操作所需要得到权限
                            String urlPermission = accessPermission.getAccessPermission();
                            boolean hasPermission = false;
                            for (Permission permission1 : permissionArrayList) {
                                hasPermission = permission1.getpermissionName().equals(urlPermission);
                                if (hasPermission) break;
                            }
                            if (hasPermission) {
                                logger.info("访问当前页面需要【" + urlPermission + "】用户有访问【" + urlPermission + "】这个权限，放行");
                                chain.doFilter(req, resp);
                            } else {
                                logger.warn("没有访问这个操作的权限");
                                response.sendRedirect("/403.jsp");
                            }
                        }
                    } else {
                        logger.error("用户没有任何操作权限");
                        response.sendRedirect(request.getContextPath() + "/403.jsp");
                    }
                }
            } else {
                logger.info("===============没有登录================");
                response.sendRedirect(request.getContextPath() + "/base/loginPage.html");
            }
        }

    }


    @Override
    public void destroy() {
        logger.warn("权限验证过滤器开始销毁");
    }
}






























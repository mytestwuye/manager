package com.suny.association.filter;

import com.suny.association.pojo.po.Account;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Comments:
 * Author:   孙建荣
 * Create Date: 2017/05/12 16:09
 */
public class LoginFilter implements Filter {

    private final static Logger logger = LoggerFactory.getLogger(LoginFilter.class);


    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("===============登录过滤器开始初始化============");
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        // 准备排除静态文件1
        String path = request.getRequestURI();
        Account account = (Account) request.getSession().getAttribute("account");
        String ext = path.substring(path.lastIndexOf("."));
        if (account != null) {
            logger.info("登录用户，直接放行,验证过操作权限");
            chain.doFilter(req, resp);
        } else {
            if (path.endsWith("index.jsp") || path.endsWith("/base/loginPage.html")) {
                logger.info("============用户请求登录页面==================");
                chain.doFilter(req, resp);
            } else if (path.endsWith("/403.jsp")) {
                logger.info("=============没有权限页面=============");
                chain.doFilter(req, resp);
            } else if (path.endsWith("/code/generateCode.do")) {
                logger.info("==============请求验证码=================");
                chain.doFilter(req, resp);
            } else if (path.endsWith("/code/checkCode.do.do")) {
                logger.info("==============验证验证码正确性=================");
                chain.doFilter(req, resp);
            } else if (path.endsWith("/base/loginAction.json")) {
                logger.info("==============请求登录验证===============");
                chain.doFilter(req, resp);
            } else if (path.endsWith("/base/goAdminPage.html")) {
                logger.info("==============验证成功进入管理页面===============");
                chain.doFilter(req, resp);
            } else {
                logger.error("==================没有登录，重定向到登录页面======");
                response.sendRedirect(request.getContextPath() + "/base/loginPage.html");
            }
        }

    }

    public void destroy() {
        logger.warn("登录过滤器开始销毁");
    }


}

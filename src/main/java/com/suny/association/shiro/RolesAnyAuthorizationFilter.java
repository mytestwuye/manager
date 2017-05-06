package com.suny.association.shiro;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Comments:    权限认证时的操作
 * Author:   孙建荣
 * Create Date: 2017/05/06 22:03
 */
class RolesAnyAuthorizationFilter extends AuthorizationFilter {
    private final Logger logger = LoggerFactory.getLogger(RolesAnyAuthorizationFilter.class);

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        String url = request.getParameter("url");
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        String reqUrl = httpServletRequest.getRequestURL().toString();
        logger.info("请求地址为" + reqUrl);
        logger.info("参数地址为" + url);
        String regex = "/(.*?)/";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(url);
        String server = "";
        int n = 0;
        while (matcher.find()) {
            server = matcher.group(1);
            if (n == 1) {
                break;
            }
            n++;
        }

        Subject subject = getSubject(request, response);
        logger.info("访问服务名" + server + "角色是否存在" + subject.hasRole(server));
        if (subject.hasRole(server)) {
            // 进一步查看是否可以访问分类
            String research_cid = request.getParameter("search_cid");
            if (research_cid != null) {
                try {
                    subject.checkPermission(server + "&" + research_cid);
                } catch (Exception e) {
                    logger.error("没有权限");
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}




















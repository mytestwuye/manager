package com.suny.association.controller;

import com.suny.association.utils.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

/**
 * Comments:    基础的控制器
 * Author:   孙建荣
 * Create Date: 2017/05/06 22:23
 */
public abstract class BaseController {
    private final Logger logger = LoggerFactory.getLogger(BaseController.class);


    /**
     * 当操作没有权限时处理结果
     *
     * @param request  请求
     * @param response 响应
     * @return 处理的结果
     */
    public String authorizationException(HttpServletRequest request, HttpServletResponse response) {
        /*Subject subject = SecurityUtils.getSubject();
        logger.info("是否认证:" + subject.isAuthenticated());
        logger.info("是否记住:" + subject.isRemembered());
        logger.info("用户信息是否为空" + subject.getPrincipal());
        RealmSecurityManager securityManager = (RealmSecurityManager) SecurityUtils.getSecurityManager();
        Realm next = securityManager.getRealms().iterator().next();
        logger.info(next.getName());
        CacheManager securityManagerCacheManager = securityManager.getCacheManager();
        Cache<Object, Object> cache = securityManagerCacheManager.getCache("com.suny.association.shiro.LoginRealm.authorizationCache");
        Member member = (Member) request.getSession().getAttribute("member");
        logger.error("成员名【" + member.getMemberName() + "】没有权限操作一个页面");
        if (LoginUtils.isAjaxRequest(request)) {
            Map<String, Object> map = new HashMap<>();
            map.put("code", "-998");
            map.put("message", "无权限");
            writeJson(map, response);
            return null;
        } else {
            return "redirect:/403.jsp";
        }*/
        return null;
    }


    /**
     * 输出json数据
     *
     * @param map      封装数据集合
     * @param response 响应
     */
    private void writeJson(Map<String, Object> map, HttpServletResponse response) {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=utf-8");
        try (PrintWriter printWriter = response.getWriter()) {
            assert printWriter != null;
            printWriter.write(JsonResult.toJson(map));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}














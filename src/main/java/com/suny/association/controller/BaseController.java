package com.suny.association.controller;

import com.suny.association.utils.JsonResult;
import com.suny.association.utils.LoginUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Comments:    基础的控制器
 * Author:   孙建荣
 * Create Date: 2017/05/06 22:23
 */
public abstract class BaseController {

    @ExceptionHandler({UnauthenticatedException.class, AuthenticationException.class})
    public String authenticationException(HttpServletRequest request, HttpServletResponse response) {
        if (LoginUtils.isAjaxRequest(request)) {
            Map<String, Object> map = new HashMap<>();
            map.put("code", "-999");
            map.put("message", "未登录");
            writeJson(map, response);
            return null;
        } else {
            return "redirect:/loginPage.html";
        }
    }

    @ExceptionHandler({UnauthorizedException.class, AuthorizationException.class})
    public String authorizationException(HttpServletRequest request, HttpServletResponse response) {
        if (LoginUtils.isAjaxRequest(request)) {
            Map<String, Object> map = new HashMap<>();
            map.put("code", "-998");
            map.put("message", "无权限");
            writeJson(map, response);
            return null;
        } else {
            return "redirect:/403.jsp";
        }
    }


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














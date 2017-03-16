package com.suny.association.exceptionsolver;

import com.suny.association.exception.BusinessException;
import com.suny.association.utils.JSONUtils;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Comments:   异常解决类
 * Author:   孙建荣
 * Create Date: 2017/03/08 18:18
 */
public class SimpleMappingExceptionSolver implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, Object handler, Exception ex) {
        //首先先判断是否为ajax请求
        if (request.getHeader("x-requested-with") == null ){
            //如果不是ajax的话，使用jsp页面返回
            Map<String, Object> objectMap = new HashMap<String, Object>();
            objectMap.put("success", false);
            if(ex instanceof BusinessException) {
                objectMap.put("errorMsg", ex.getMessage());
            }
            else {
                objectMap.put("errorMsg", "系统异常!");
            }
            //就打印出log来
            ex.printStackTrace();
            //非ajax请求就同意跳转到error.jsp页面
            return new ModelAndView("/error.jsp", objectMap);
        }else {
            //如果是ajax请求的话用json返回吧
            try {
                response.setContentType("application/json;charset=UTF-8");
                PrintWriter printWriter = response.getWriter();
                Map<String, Object> objectMap = new HashMap<String, Object>();
                objectMap.put("success", false);
                //业务异常对前端可见，否则同意为系统异常
                if( ex instanceof BusinessException) {
                    objectMap.put("errorMsg", ex.getMessage());
                }
                else {
                    objectMap.put("errorMsg", "系统异常!");
                }
                printWriter.write(JSONUtils.toJson(objectMap));
                printWriter.flush();
                printWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

            return null;
    }
}





















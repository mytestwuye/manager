package com.suny.association.exceptionSolver;

import com.suny.association.exception.BusinessException;
import com.suny.association.utils.JsonResult;
import org.slf4j.Logger;
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

    private static final Logger logger = org.slf4j.LoggerFactory.getLogger(SimpleMappingExceptionSolver.class);

    public ModelAndView resolveException(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, Object handler, Exception ex) {

        //首先先判断是否为ajax请求，不是的话使用jsp返回
        Map<String, Object> objectMap;
        if (request.getHeader("x-requested-with") == null) {
            objectMap = new HashMap<>();
            objectMap.put("success", false);
            putMessageInfo(ex, objectMap);
            //就打印出log来
            ex.printStackTrace();
            //非ajax请求就跳转到error.jsp页面
            logger.warn("普通请求异常，返回一个错误页面");
            return new ModelAndView("errorPage", objectMap);
        } else {
            //如果是ajax请求的话用json返回吧
            try {
                objectMap = new HashMap<>();
                objectMap.put("success", false);
                putMessageInfo(ex, objectMap);
                response.setContentType("application/json;charset=UTF-8");
                PrintWriter printWriter = response.getWriter();
                //业务异常对前端可见，否则同意为系统异常
                logger.warn("ajax请求异常，返回json异常数据");
                printWriter.write(JsonResult.toJson(objectMap));
                printWriter.flush();
                printWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        return null;
    }

    /**
     * 判断出错的类型添加出错信息
     */
    private void putMessageInfo(Exception ex, Map<String, Object> objectMap) {
        if (ex instanceof BusinessException) {
            objectMap.put("status", gerErrorCode(ex));
            objectMap.put("errorMessage", ex.getMessage());
        } else {
            objectMap.put("status", 999);
            objectMap.put("errorMessage", "系统异常!");
        }
    }

    /**
     * 获取异常中的异常状态码
     */
    private int gerErrorCode(Exception ex) {
        String errorMessage = ex.getMessage();
        int afterErrorCode = errorMessage.lastIndexOf(',');
        String errorCode = errorMessage.substring(5, afterErrorCode);
        return Integer.parseInt(errorCode);
    }
}





















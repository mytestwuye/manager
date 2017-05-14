package com.suny.association.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Comments:   在controller中存在大量重复代码，所以抽取出来组成一个静态的公共方法，组合成符合Bootstrap-table需要的分页结果
 * Author:   孙建荣
 * Create Date: 2017/04/15 19:40
 */
public class ConversionUtil {
    private static final Logger logger = LoggerFactory.getLogger(ConversionUtil.class);

    /**
     * 把前端传来的int类型的状态码转换为boolean类型的状态
     *
     * @param status int类型状态码
     * @return boolean类型状态
     */
    private static Boolean convertToBooleanStatus(int status) {
        Boolean booleanStatus;
        if (status == 0) booleanStatus = false;
        else if (status == 1) {
            booleanStatus = true;
        } else {
            booleanStatus = null;
        }
        return booleanStatus;
    }

    /**
     * 封装map查询条件
     *
     * @param args 查询条件的参数
     * @return map查询查询条件
     */
    public static Map<Object, Object> convertToCriteriaMap(Object... args) {
        Map<Object, Object> criteriaMap = new HashMap<>();
        criteriaMap.put("offset", args[0]);
        criteriaMap.put("limit", args[1]);
        if (args.length == 3) {
            criteriaMap.put("status", ConversionUtil.convertToBooleanStatus((Integer) args[2]));
            return criteriaMap;
        } else if (args.length == 4) {
            criteriaMap.put("departmentname", args[2]);
            criteriaMap.put("status", ConversionUtil.convertToBooleanStatus((Integer) args[3]));
            return criteriaMap;
        }
        return criteriaMap;
    }

    /**
     * 把查询出来的结果变成符合Bootstrap-table需要的服务器端分页数据
     *
     * @param resultList 查询出来的结果集数据
     * @param totalCount 查询出来的总行数
     * @return Mpa集合
     */
    public static Map<Object, Object> convertToBootstrapTableResult(List resultList, int totalCount) {
        Map<Object, Object> tableDate = new HashMap<>();
        if (resultList.size() != 0 && !resultList.isEmpty()) {
            tableDate.put("rows", resultList);
            tableDate.put("total", totalCount);
            return tableDate;
        }
        tableDate.put("rows", null);
        tableDate.put("total", 0);
        return tableDate;
    }

    /**
     * 根据反射动态封装查询条件
     *
     * @param clazz 反射的类
     * @return 动态封装查询条件
     */
    static Map<Object, Object> dynamicCriteriaMap(Class clazz) {
        String queryAllMethodName = "queryAll";
        String className = clazz.getSimpleName();
        Method[] methods = clazz.getDeclaredMethods();
        Object[] threeArrayParam = new Object[]{"String", "int", "int"};
        int i = 0;
        int j = 0;
        while (i < methods.length) {
            if (methods[i].getName().equals(queryAllMethodName)) {
                Method method = methods[i];
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (className.equals("AccountController")) {
                    logger.info("传过来的是" + className);
                    logger.info("是否匹配" + matchParameterType(parameterTypes, threeArrayParam));
                }
                while (j < parameterTypes.length) {
                    logger.info("参数类型是" + parameterTypes[j].getName());
                    j++;
                }
            }
            i++;
        }
        return null;
    }


    /**
     * 比较数组里面的状态是否全部相等
     *
     * @param parameterTypes  方法里面的参数
     * @param threeArrayParam 固定的三个参数的查询条件类型
     * @return 是否全部相等
     */
    private static Boolean matchParameterType(Object[] parameterTypes, Object[] threeArrayParam) {
        ArrayList<Boolean> matchStatus = new ArrayList<>();
        if (parameterTypes.length != threeArrayParam.length) {
            return false;
        }
        for (int i = 0; i < parameterTypes.length; i++) {
            matchStatus.add(i, ((Class) parameterTypes[i]).getName() == threeArrayParam[i]);
        }
        int statusSize = matchStatus.size();
        for (int i = statusSize - 1; i >= 0; i--) {
            while (statusSize > 0) {
                if (matchStatus.get(i) != matchStatus.get(statusSize - 1)) {
                    return false;
                }
                statusSize--;
            }
            return true;
        }
        return true;
    }
}











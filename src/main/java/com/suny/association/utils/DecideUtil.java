package com.suny.association.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * Comments:
 * Author:   孙建荣
 * Create Date: 2017/04/15 19:40
 */
public class DecideUtil {
    public static Boolean convertStatus(int status) {
        Boolean booleanStatus;
        if (status == 0) booleanStatus = false;
        else if (status == 1) {
            booleanStatus = true;
        } else{
            booleanStatus = null;
        }
        return booleanStatus;
    }

    public static Map<Object,Object> pushToMap(Object... args){
        Map<Object, Object> criteriaMap = new HashMap<>();
        if(args.length==3){
            criteriaMap.put("offset", args[0]);
            criteriaMap.put("limit", args[1]);
            criteriaMap.put("status", DecideUtil.convertStatus((Integer) args[2]));
            return criteriaMap;
        }
        else if(args.length==4){
            criteriaMap.put("offset",args[0]);
            criteriaMap.put("limit",args[1]);
            criteriaMap.put("departmentname",args[2]);
            criteriaMap.put("status", DecideUtil.convertStatus((Integer) args[3]));
            return criteriaMap;
        }
        return criteriaMap;
    }
}

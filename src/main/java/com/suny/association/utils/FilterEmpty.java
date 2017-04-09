package com.suny.association.utils;

import java.util.Collection;
import java.util.Map;

/**  判断是否为空封装工具类
 * Comments:
 * Author:   孙建荣
 * Create Date: 2017/03/30 17:44
 */
public class FilterEmpty {
    
    public static boolean isNullOrEmpty(Object object){
        if(object ==null){
            return true;
        }
        if(object instanceof CharSequence){
            return (((CharSequence) object).length() == 0);
        }
        if(object instanceof Collection){
            return ((Collection) object).isEmpty();
        }
        if(object instanceof Map){
            return ((Map) object).isEmpty();
        }
        
        if (object instanceof Object[]){
            Object[] objects = (Object[])object;
            if(objects.length ==0 ){
                return true;
            }
            boolean empty = true;
    
            for (int i = 0; i < objects.length ; i++) {
                if(!isNullOrEmpty(objects[i])){
                    empty = false;
                    break;
                }
               
            }
            return empty;
           
            
        }
        return false;
    }
}

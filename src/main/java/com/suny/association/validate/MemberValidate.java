package com.suny.association.validate;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Comments:  验证member实体的信息
 * Author:   孙建荣
 * Create Date: 2017/03/19 20:30
 */
public class MemberValidate<T> {
    
    public  void validateInfo(T clazz){
        //获取实体类的所有属性
        Field[] fields = clazz.getClass().getDeclaredFields();
        
        for (int i = 0; i < fields.length ; i++) {
            String fieldName = fields[i].getName();    // 获取字段的名字
            String fieldType = fields[i].getGenericType().toString();  //获取字段的属性
            // 把字段名首字母大写，构造set,get方法
            fieldName = fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
            
            //String类型
            if(fieldType.equals("class java.lang.String")){
                try {
                    Method method=clazz.getClass().getMethod("get"+fieldName);
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                }
            }
            
        }
    }
}

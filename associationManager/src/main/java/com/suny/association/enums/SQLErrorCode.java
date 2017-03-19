package com.suny.association.enums;

/**
 * Comments:   数据库类异常代码
 * Author:   孙建荣
 * Create Date: 2017/03/19 19:50
 */
public enum SQLErrorCode {
    
    ERROR_ADD_USER("0002","添加用户失败");
    
    String value;
    String desc;
    
    SQLErrorCode(String value, String desc) {
        this.value = value;
        this.desc = desc;
    }
    
    public String getValue() {
        return value;
    }
    
    public void setValue(String value) {
        this.value = value;
    }
    
    public String getDesc() {
        return desc;
    }
    
    public void setDesc(String desc) {
        this.desc = desc;
    }
}

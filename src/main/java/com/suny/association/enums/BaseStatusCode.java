package com.suny.association.enums;

/**
 * Comments:  基础错误代码枚举类
 * Author:   孙建荣
 * Create Date: 2017/03/08 18:10
 */
public enum BaseStatusCode {
    
    NULL_OBJ("0001","对象为空"),
    ERROR_ADD_USER("0002","添加用户失败"),
    ERROR_DELETE_USER("000","删除用户失败"),
    LOGIN_VERIFY_FAILURE("0003","登陆验证失败，请检查用户名密码是否正确"),
    UNKNOWN_ERROR("0999","系统繁忙....");

    String value;
    String desc;

    BaseStatusCode(String value, String desc) {
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
    
    @Override
    public String toString() {
        return "系统代码:" + value +"," + desc ;
    }
    
    
}

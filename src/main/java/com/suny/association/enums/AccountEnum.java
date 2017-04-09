package com.suny.association.enums;

/**
 * Comments:  账号枚举类
 * Author:   孙建荣
 * Create Date: 2017/03/31 14:25
 */
public enum  AccountEnum {
    
    UNKNOWN_ERROR("200","出现未知错误，请尝试重新操作！"),
    SUCCESS_DELETE_ACCOUNT_INFO("201","删除一条账号成功"),
    FAIL_DELETE_ACCOUNT_INFO("202","删除一条账号失败"),
    SUCCESS_UPDATE_ACCOUNT_INFO("203","更新一条账号成功"),
    FAIL_UPDATE_ACCOUNT_INFO("204","更新一条账号失败"),
    SUCCESS_INSERT_ACCOUNT_INFO("205","插入一条账号成功"),
    FAIL_INSERT_ACCOUNT_INFO("206","插入一条账号失败"),
    SUCCESS_SELECT_ACCOUNT_INFO("207","查询记录成功"),
    FAIL_SELECT_ACCOUNT_INFO("208","查询记录失败"),
    NOT_HAVE_THIS_ACCOUNT_INFO("209","没有这条账号信息"),
    REPEAT_ADD("210","重复添加");
    
    
    
    String value;
    String desc;
    
    
    AccountEnum(String value, String desc) {
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

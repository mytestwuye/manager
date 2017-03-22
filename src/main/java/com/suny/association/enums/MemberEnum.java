package com.suny.association.enums;

/**
 * Comments:  成员信息错误代码维护
 * Author:   孙建荣
 * Create Date: 2017/03/19 19:54
 */
public enum MemberEnum {
    
    UNKNOWN_ERROR("900","出现未知错误，请尝试重新操作！"),
    SUCCESS_DELETE_MEMBER_INFO("901","删除一条成员信息成功"),
    FAIL_DELETE_MEMBER_INFO("902","删除一条成员信息失败"),
    SUCCESS_UPDATE_MEMBER_INFO("903","更新一条成员信息成功"),
    FAIL_UPDATE_MEMBER_INFO("904","更新一条成员信息失败"),
    SUCCESS_INSERT_MEMBER_INFO("905","插入一条成员信息成功"),
    FAIL_INSERT_MEMBER_INFO("906","插入一条成员信息失败"),
    SUCCESS_SELECT_MEMBER_INFO("907","查询记录成功"),
    FAIL_SELECT_MEMBER_INFO("908","查询记录失败"),
    NOT_HAVE_THIS_MEMBER_INFO("909","没有这条账号信息");
    
    
    
    String value;
    String desc;
    
    
    MemberEnum(String value, String desc) {
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

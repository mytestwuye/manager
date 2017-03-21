package com.suny.association.enums;

/**
 * Comments: 登陆错误代码集合
 * Author:   孙建荣
 * Create Date: 2017/03/19 19:58
 */
public enum LoginStatusCode {
    
            LOGIN_SYSTEM("100","登录系统成功"),
            LOGOUT_SYSTEM_SUCCESS("199","注销系统成功"),
            USER_DOES_NOT_EXITS("101","登录用户不存在"),
            USER_NOT_BELONG_TO_ERERY_ROLE("102","登录用户不属于任何角色"),
            USER_NOT_HAVE_OPERATIE_AUTHORITY("103","登录用户无任何操作权限"),
            USER_NOT_HAVE_MANAGE_AREA("104","登录用户无任何管理区域"),
            NOT_HAVE_OPERATION_AUTHORITY("105","没有操作权限"),
            AFTER_LOGIN_HAVEING_OPERATE("106","此操作需要登录后进行"),
            WELCOME_TO_LOGIN("107","欢迎{0}登录系统！"),
            PLEASE_INPUT_USERID("110","请输入用户账号"),
            PLEASE_INPUT_PASSWORD("111","请输入密码"),
            PLEASE_INPUT_VALIDATE_CODE("112","请输入验证码"),
            VALIDATE_CODE_ERROR("113","验证码输入错误"),
            VALIDATE_CODE_SUCCESS("114","验证码输入正确"),
            USERID_OR_PASSWORD_ERROR("115","用户名或密码输入错误");
    
    String value;
    String desc;
    
    LoginStatusCode(String value, String desc) {
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

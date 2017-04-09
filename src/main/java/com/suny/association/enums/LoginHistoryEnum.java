package com.suny.association.enums;

/**
 * Comments:
 * Author:   孙建荣
 * Create Date: 2017/04/09 22:28
 */
public enum LoginHistoryEnum {

    SUCCESS_QUERY("300","查询成功");

    String value;
    String desc;


    LoginHistoryEnum(String value, String desc) {
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

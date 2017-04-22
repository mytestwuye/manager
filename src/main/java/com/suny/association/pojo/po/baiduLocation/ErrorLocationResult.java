package com.suny.association.pojo.po.baiduLocation;

/**
 * Comments:  百度定位返回的错误码
 * Author:   孙建荣
 * Create Date: 2017/04/22 10:33
 */
public class ErrorLocationResult {


    /**
     * status : 返回的状态码
     * message : 返回的状态
     */

    private int status;
    private String message;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

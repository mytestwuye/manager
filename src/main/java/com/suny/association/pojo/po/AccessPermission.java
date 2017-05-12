package com.suny.association.pojo.po;

import java.io.Serializable;

/**
 * Comments:   访问uri地址需要具备的权限
 * Author:   孙建荣
 * Create Date: 2017/05/12 22:06
 */
public class AccessPermission implements Serializable {

    private static final long serialVersionUID = 4330338228715931808L;
    /* 请求路径 */
    private String accessUrl;

    /* 请求所需要的权限*/
    private String accessPermission;

    public AccessPermission() {
    }

    public AccessPermission(String accessUrl, String accessPermission) {
        this.accessUrl = accessUrl;
        this.accessPermission = accessPermission;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getAccessUrl() {
        return accessUrl;
    }

    public void setAccessUrl(String accessUrl) {
        this.accessUrl = accessUrl;
    }

    public String getAccessPermission() {
        return accessPermission;
    }

    public void setAccessPermission(String accessPermission) {
        this.accessPermission = accessPermission;
    }
}

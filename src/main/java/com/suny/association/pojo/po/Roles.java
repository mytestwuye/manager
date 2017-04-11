package com.suny.association.pojo.po;

import java.util.Date;

public class Roles {
    private Integer roleId;

    private String roleName;

    private Date createTime;

    public Roles() {
    }

    public Roles(Integer roleId, String roleName, Date createTime) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.createTime = createTime;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
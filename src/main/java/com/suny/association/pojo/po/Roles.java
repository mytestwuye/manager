package com.suny.association.pojo.po;

import java.time.LocalDateTime;

public class Roles {
    /*账号主键id*/
    private Integer roleId;

    /* 账号的中文解释*/
    private String description;

    /* 账号的角色名字 */
    private String roleName;

    /*账号创建的时间*/
    private LocalDateTime createTime;

    public Roles() {
    }

    public Roles(Integer roleId, String description, String roleName, LocalDateTime createTime) {
        this.roleId = roleId;
        this.description = description;
        this.roleName = roleName;
        this.createTime = createTime;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }
}
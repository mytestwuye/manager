package com.suny.association.pojo.po;

public class Roles {
    private Integer roleId;

    private String roleName;

    public Roles(Integer roleId, String roleName) {
        this.roleId = roleId;
        this.roleName = roleName;
    }

    public Roles() {
        super();
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
        this.roleName = roleName == null ? null : roleName.trim();
    }
}
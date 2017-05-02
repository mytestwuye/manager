package com.suny.association.pojo.po;

import java.io.Serializable;
import java.util.Set;

/**
 * Comments:    角色权限角色中间表，给角色分配权限
 * Author:   孙建荣
 * Create Date: 2017/05/02 12:44
 */
public class PermissionAllot implements Serializable {

    private static final long serialVersionUID = -2433044880242889682L;
    private Integer id;   /* 主键id */
    private int roleId;   /* 角色id */
    private Set<Permission> permissionSet;   /* 权限id */

    public PermissionAllot() {
    }

    public PermissionAllot(Integer id, int roleId, Set<Permission> permissionSet) {
        this.id = id;
        this.roleId = roleId;
        this.permissionSet = permissionSet;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public Set<Permission> getPermissionSet() {
        return permissionSet;
    }

    public void setPermissionSet(Set<Permission> permissionSet) {
        this.permissionSet = permissionSet;
    }
}

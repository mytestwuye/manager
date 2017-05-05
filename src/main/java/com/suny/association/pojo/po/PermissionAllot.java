package com.suny.association.pojo.po;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Comments:    角色权限角色中间表，给角色分配权限
 * Author:   孙建荣
 * Create Date: 2017/05/02 12:44
 */
public class PermissionAllot implements Serializable {

    private static final long serialVersionUID = -2433044880242889682L;
    private Integer id;   /* 主键id */
    private Roles roleId;   /* 角色id */
    private List<Permission> permissionArrayList = new ArrayList<>();   /* 权限id */

    public PermissionAllot() {
    }

    public PermissionAllot(Integer id, Roles roleId, List<Permission> permissionArrayList) {
        this.id = id;
        this.roleId = roleId;
        this.permissionArrayList = permissionArrayList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Roles getRoleId() {
        return roleId;
    }

    public void setRoleId(Roles roleId) {
        this.roleId = roleId;
    }

    public List<Permission> getPermissionArrayList() {
        return permissionArrayList;
    }

    public void setPermissionArrayList(List<Permission> permissionArrayList) {
        this.permissionArrayList = permissionArrayList;
    }
}

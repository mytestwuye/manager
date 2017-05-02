package com.suny.association.service.interfaces;

import com.suny.association.pojo.po.Permission;
import com.suny.association.pojo.po.PermissionAllot;
import com.suny.association.service.IBaseService;

import java.util.List;

/**
 * Comments:    权限的具体管理接口
 * Author:   孙建荣
 * Create Date: 2017/05/02 13:03
 */
public interface IPermissionService extends IBaseService<Permission>  {
    List<PermissionAllot> queryPermissionQuote(int permissionId);
}

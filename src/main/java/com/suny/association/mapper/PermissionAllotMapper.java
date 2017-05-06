package com.suny.association.mapper;

import com.suny.association.mapper.interfaces.IMapper;
import com.suny.association.pojo.po.PermissionAllot;

import java.util.List;

/**
 * Comments:    权限分配mapper接口
 * Author:   孙建荣
 * Create Date: 2017/05/02 13:16
 */
public interface PermissionAllotMapper extends IMapper<PermissionAllot> {
    List<PermissionAllot> queryByRoleId(int roleId);
}

package com.suny.association.service.impl;

import com.suny.association.annotation.SystemServiceLog;
import com.suny.association.mapper.PermissionAllotMapper;
import com.suny.association.pojo.po.PermissionAllot;
import com.suny.association.service.AbstractBaseServiceImpl;
import com.suny.association.service.interfaces.IPermissionAllotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Comments:   权限分配业务逻辑实现类
 * Author:   孙建荣
 * Create Date: 2017/05/02 13:10
 */
@Service
public class PermissionAllotServiceImpl extends AbstractBaseServiceImpl<PermissionAllot> implements IPermissionAllotService {
    private final PermissionAllotMapper permissionAllotMapper;

    @Autowired
    public PermissionAllotServiceImpl(PermissionAllotMapper permissionAllotMapper) {
        this.permissionAllotMapper = permissionAllotMapper;
    }

    @Transactional(rollbackFor = Exception.class)
    @SystemServiceLog(description = "增加角色权限失败")
    @Override
    public void insert(PermissionAllot permissionAllot) {
        permissionAllotMapper.insert(permissionAllot);
    }


    @Transactional(rollbackFor = Exception.class)
    @SystemServiceLog(description = "删除角色所有权限失败")
    @Override
    public void deleteById(int id) {
        permissionAllotMapper.deleteById(id);
    }

    @Override
    public PermissionAllot queryByName(String name) {
        return permissionAllotMapper.queryByName(name);
    }

    @Override
    public int queryCount() {
        return permissionAllotMapper.queryCount();
    }

    @Override
    public List<PermissionAllot> list(Map<Object, Object> criteriaMap) {
        return null;
    }

    @Override
    public List<PermissionAllot> queryAll() {
        return permissionAllotMapper.queryAll();
    }

    @Override
    public List<PermissionAllot> queryByRoleId(int roleId) {
        return permissionAllotMapper.queryByRoleId(roleId);
    }
}

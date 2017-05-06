package com.suny.association.service.impl;

import com.suny.association.annotation.SystemServiceLog;
import com.suny.association.mapper.PermissionMapper;
import com.suny.association.pojo.po.Permission;
import com.suny.association.pojo.po.PermissionAllot;
import com.suny.association.service.AbstractBaseServiceImpl;
import com.suny.association.service.interfaces.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Comments:   权限管理业务逻辑控制
 * Author:   孙建荣
 * Create Date: 2017/05/02 13:04
 */
@Service
public class PermissionServiceImpl extends AbstractBaseServiceImpl<Permission> implements IPermissionService {

    private final PermissionMapper permissionMapper;

    @Autowired
    public PermissionServiceImpl(PermissionMapper permissionMapper) {
        this.permissionMapper = permissionMapper;
    }

    @SystemServiceLog(description = "插入权限失败")
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void insert(Permission permission) {
        permissionMapper.insert(permission);
    }

    @Transactional(rollbackFor = Exception.class)
    @SystemServiceLog(description = "删除权限失败")
    @Override
    public void deleteById(int id) {
        permissionMapper.deleteById(id);
    }

    @SystemServiceLog(description = "更新权限失败")
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void update(Permission permission) {
        permissionMapper.update(permission);
    }


    @Override
    public Permission queryByName(String name) {
        return permissionMapper.queryByName(name);
    }

    @Transactional(readOnly = true)
    @Override
    public int queryCount() {
        return permissionMapper.queryCount();
    }

    @Override
    public Permission queryById(int id) {
        return permissionMapper.queryById(id);
    }


    @Transactional(readOnly = true)
    @Override
    public List<Permission> list(Map<Object, Object> criteriaMap) {
        return permissionMapper.list(criteriaMap);
    }

    @Override
    public List<PermissionAllot> queryPermissionQuote(int permissionId) {
        return permissionMapper.queryPermissionQuote(permissionId);
    }

    @Override
    public List<Permission> queryAll() {
        return permissionMapper.queryAll();
    }
}

package com.suny.association.service.impl;

import com.suny.association.mapper.AccessPermissionMapper;
import com.suny.association.pojo.po.AccessPermission;
import com.suny.association.service.interfaces.IAccessPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Comments:   访问url地址所需要的权限业务逻辑层
 * Author:   孙建荣
 * Create Date: 2017/05/12 22:13
 */
@Service
public class AccessPermissionServiceImpl implements IAccessPermissionService {

    private final AccessPermissionMapper accessPermissionMapper;

    @Autowired
    public AccessPermissionServiceImpl(AccessPermissionMapper accessPermissionMapper) {
        this.accessPermissionMapper = accessPermissionMapper;
    }

    @Override
    public void insert(AccessPermission accessPermission) {

    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public void update(AccessPermission accessPermission) {

    }

    @Override
    public AccessPermission queryById(int id) {
        return null;
    }

    @Override
    public AccessPermission queryByName(String name) {
        return accessPermissionMapper.queryByName(name);
    }

    @Override
    public int queryCount() {
        return 0;
    }

    @Override
    public List<AccessPermission> queryAll() {
        return accessPermissionMapper.queryAll();
    }

    @Override
    public List<AccessPermission> list(Map<Object, Object> criteriaMap) {
        return null;
    }
}

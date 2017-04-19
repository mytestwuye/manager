package com.suny.association.service.impl;

import com.suny.association.mapper.RolesMapper;
import com.suny.association.pojo.po.Account;
import com.suny.association.pojo.po.Roles;
import com.suny.association.service.AbstractBaseServiceImpl;
import com.suny.association.service.interfaces.IRolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Comments:   账号角色业务逻辑
 * Author:   孙建荣
 * Create Date: 2017/03/07 22:41
 */
@Service
public class RolesServiceImpl extends AbstractBaseServiceImpl<Roles> implements IRolesService {

    private final RolesMapper rolesMapper;

    @Autowired
    public RolesServiceImpl(RolesMapper rolesMapper) {
        this.rolesMapper = rolesMapper;
    }

    @Override
    public void deleteById(int id) {
        rolesMapper.deleteById(id);
    }

    @Transactional
    @Override
    public void update(Roles roles) {
        if (roles.getRoleId() == null) {
            throw new RuntimeException();
        }
        rolesMapper.update(roles);
    }

    @Override
    public void insert(Roles roles) {
        rolesMapper.insert(roles);
    }

    @Override
    public List<Roles> queryAll() {
        return rolesMapper.queryAll();
    }

    @Override
    public List<Roles> list(Map criteriaMap) {
        return rolesMapper.list(criteriaMap);
    }

    @Override
    public Roles queryById(int id) {
        return rolesMapper.queryById(id);
    }


    @Override
    public int queryCount() {
        return rolesMapper.queryCount();
    }

    @Override
    public List<Account> queryQuote(Integer roleId) {
        return rolesMapper.queryQuote(roleId);
    }

    @Override
    public Roles queryByName(String name) {
        return rolesMapper.queryByName(name);
    }
}

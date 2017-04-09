package com.suny.association.service.impl;

import com.suny.association.mapper.RolesMapper;
import com.suny.association.pojo.po.Roles;
import com.suny.association.service.AbstractBaseServiceImpl;
import com.suny.association.service.interfaces.IRolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Comments:
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
    public List<Roles> queryAll() {
        return rolesMapper.queryAll();
    }

    @Override
    public Roles queryById(int id) {
        return rolesMapper.queryById(id);
    }
}

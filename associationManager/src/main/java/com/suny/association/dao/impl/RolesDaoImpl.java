package com.suny.association.dao.impl;

import com.suny.association.dao.AbstractBaseDaoImpl;
import com.suny.association.dao.interfaces.IRolesDao;
import com.suny.association.mapper.RolesMapper;
import com.suny.association.mapper.interfaces.IMapper;
import com.suny.association.pojo.po.Roles;

/**
 * Comments:
 * Author:   孙建荣
 * Create Date: 2017/03/07 21:33
 */
public class RolesDaoImpl extends AbstractBaseDaoImpl<Roles> implements IRolesDao {
    private RolesMapper rolesMapper;

    public RolesMapper getRolesMapper() {
        return rolesMapper;
    }

    public void setRolesMapper(RolesMapper rolesMapper) {
        this.rolesMapper = rolesMapper;
    }

    public RolesDaoImpl(IMapper<Roles> mapper, RolesMapper rolesMapper) {

        super(mapper);
        this.rolesMapper = rolesMapper;
    }
}

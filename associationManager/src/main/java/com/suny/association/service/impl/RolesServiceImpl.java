package com.suny.association.service.impl;

import com.suny.association.dao.IBaseDao;
import com.suny.association.dao.interfaces.IRolesDao;
import com.suny.association.pojo.po.Roles;
import com.suny.association.service.AbstractBaseServiceImpl;
import com.suny.association.service.interfaces.IRolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Comments:
 * Author:   孙建荣
 * Create Date: 2017/03/07 22:41
 */
@Service
public class RolesServiceImpl extends AbstractBaseServiceImpl<Roles> implements IRolesService {
    
    
    @Autowired
    private IRolesDao rolesDao;
    
    public RolesServiceImpl() {
    }
    
    public RolesServiceImpl(IBaseDao<Roles> iBaseDao) {
        super(iBaseDao);
    }
    
    public IRolesDao getRolesDao() {
        return rolesDao;
    }
    
    public void setRolesDao(IRolesDao rolesDao) {
        this.rolesDao = rolesDao;
    }
}

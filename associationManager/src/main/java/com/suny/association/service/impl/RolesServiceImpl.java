package com.suny.association.service.impl;

import com.suny.association.dao.IBaseDao;
import com.suny.association.dao.interfaces.IRolesDao;
import com.suny.association.pojo.po.Roles;
import com.suny.association.service.AbstractBaseServiceImpl;
import com.suny.association.service.interfaces.IRolesService;

/**
 * Comments:
 * Author:   孙建荣
 * Create Date: 2017/03/07 22:41
 */
public class RolesServiceImpl extends AbstractBaseServiceImpl<Roles> implements IRolesService {
    private IRolesDao iRolesDao;

    public IRolesDao getiRolesDao() {
        return iRolesDao;
    }

    public void setiRolesDao(IRolesDao iRolesDao) {
        this.iRolesDao = iRolesDao;
    }

    public RolesServiceImpl(IBaseDao<Roles> iBaseDao, IRolesDao iRolesDao) {

        super(iBaseDao);
        this.iRolesDao = iRolesDao;
    }
}

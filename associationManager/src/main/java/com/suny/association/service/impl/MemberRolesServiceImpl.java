package com.suny.association.service.impl;

import com.suny.association.dao.IBaseDao;
import com.suny.association.pojo.po.MemberRoles;
import com.suny.association.service.AbstractBaseServiceImpl;
import com.suny.association.service.interfaces.IMemberRolesService;

/**
 * Comments:
 * Author:   孙建荣
 * Create Date: 2017/03/07 22:36
 */
public class MemberRolesServiceImpl extends AbstractBaseServiceImpl<MemberRoles> implements IMemberRolesService {
    private IMemberRolesService iMemberRolesService;

    public IMemberRolesService getiMemberRolesService() {
        return iMemberRolesService;
    }

    public void setiMemberRolesService(IMemberRolesService iMemberRolesService) {
        this.iMemberRolesService = iMemberRolesService;
    }

    public MemberRolesServiceImpl(IBaseDao iBaseDao, IMemberRolesService iMemberRolesService) {

        super(iBaseDao);
        this.iMemberRolesService = iMemberRolesService;
    }
}

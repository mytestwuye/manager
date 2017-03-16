package com.suny.association.service.impl;

import com.suny.association.dao.IBaseDao;
import com.suny.association.dao.interfaces.IMemberRolesDao;
import com.suny.association.pojo.po.MemberRoles;
import com.suny.association.service.AbstractBaseServiceImpl;
import com.suny.association.service.interfaces.IMemberRolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Comments:
 * Author:   孙建荣
 * Create Date: 2017/03/07 22:36
 */
@Service
public class MemberRolesServiceImpl extends AbstractBaseServiceImpl<MemberRoles> implements IMemberRolesService {
    @Autowired
    private IMemberRolesDao memberRolesDao;
    
    public MemberRolesServiceImpl() {
    }
    
    public IMemberRolesDao getMemberRolesDao() {
        return memberRolesDao;
    }
    
    public void setMemberRolesDao(IMemberRolesDao memberRolesDao) {
        this.memberRolesDao = memberRolesDao;
    }
    
    public MemberRolesServiceImpl(IBaseDao<MemberRoles> iBaseDao) {
    
        super(iBaseDao);
    }
}

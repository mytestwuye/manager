package com.suny.association.dao.impl;

import com.suny.association.dao.AbstractBaseDaoImpl;
import com.suny.association.dao.interfaces.IMemberRolesDao;
import com.suny.association.mapper.interfaces.IMapper;
import com.suny.association.pojo.po.MemberRoles;

/**
 * Comments:
 * Author:   孙建荣
 * Create Date: 2017/03/07 21:29
 */
public class MemberRolesDaoImpl extends AbstractBaseDaoImpl<MemberRoles> implements IMemberRolesDao {
    private MemberRoles memberRoles;

    public MemberRoles getMemberRoles() {
        return memberRoles;
    }

    public void setMemberRoles(MemberRoles memberRoles) {
        this.memberRoles = memberRoles;
    }

    public MemberRolesDaoImpl(IMapper<MemberRoles> mapper, MemberRoles memberRoles) {

        super(mapper);
        this.memberRoles = memberRoles;
    }
}

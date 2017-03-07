package com.suny.association.service.impl;

import com.suny.association.dao.IBaseDao;
import com.suny.association.dao.interfaces.IMemberDao;
import com.suny.association.pojo.po.Member;
import com.suny.association.service.AbstractBaseServiceImpl;
import com.suny.association.service.interfaces.IMemberService;

/**
 * Comments:
 * Author:   孙建荣
 * Create Date: 2017/03/07 22:35
 */
public class MemberServiceImpl extends AbstractBaseServiceImpl<Member> implements IMemberService {

    private IMemberDao iMemberDao;

    public IMemberDao getiMemberDao() {
        return iMemberDao;
    }

    public void setiMemberDao(IMemberDao iMemberDao) {
        this.iMemberDao = iMemberDao;
    }

    public MemberServiceImpl(IBaseDao<Member> iBaseDao, IMemberDao iMemberDao) {

        super(iBaseDao);
        this.iMemberDao = iMemberDao;
    }
}

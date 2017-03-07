package com.suny.association.dao.impl;

import com.suny.association.dao.AbstractBaseDaoImpl;
import com.suny.association.dao.interfaces.IMemberDao;
import com.suny.association.mapper.MemberMapper;
import com.suny.association.mapper.interfaces.IMapper;
import com.suny.association.pojo.po.Member;

/**
 * Comments:
 * Author:   孙建荣
 * Create Date: 2017/03/07 21:26
 */
public class MemberDaoImpl extends AbstractBaseDaoImpl<Member> implements IMemberDao {
    private MemberMapper memberMapper;

    public MemberMapper getMemberMapper() {
        return memberMapper;
    }

    public void setMemberMapper(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

    public MemberDaoImpl(IMapper<Member> mapper, MemberMapper memberMapper) {
        super(mapper);
        this.memberMapper = memberMapper;
    }
}

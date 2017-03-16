package com.suny.association.service.impl;

import com.suny.association.dao.IBaseDao;
import com.suny.association.dao.interfaces.IMemberDao;
import com.suny.association.pojo.po.Member;
import com.suny.association.service.AbstractBaseServiceImpl;
import com.suny.association.service.interfaces.IMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Comments:
 * Author:   孙建荣
 * Create Date: 2017/03/07 22:35
 */
@Service
public class MemberServiceImpl extends AbstractBaseServiceImpl<Member> implements IMemberService {
    @Autowired
    private IMemberDao memberDao;
    
    @Override
    public List<Member> queryForAll() {
        return memberDao.selectAll();
    }
    
    public MemberServiceImpl() {
    }
    
    public MemberServiceImpl(IBaseDao<Member> iBaseDao) {
        super(iBaseDao);
    }
    
    public IMemberDao getMemberDao() {
        return memberDao;
    }
    
    public void setMemberDao(IMemberDao memberDao) {
        this.memberDao = memberDao;
    }
}

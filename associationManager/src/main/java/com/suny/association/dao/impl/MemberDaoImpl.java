package com.suny.association.dao.impl;

import com.suny.association.dao.AbstractBaseDaoImpl;
import com.suny.association.dao.interfaces.IMemberDao;
import com.suny.association.mapper.MemberMapper;
import com.suny.association.mapper.interfaces.IMapper;
import com.suny.association.pojo.po.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Comments:
 * Author:   孙建荣
 * Create Date: 2017/03/07 21:26
 */
@Repository
public  class MemberDaoImpl extends AbstractBaseDaoImpl<Member> implements IMemberDao {
    
    @Autowired
    private MemberMapper memberMapper;
    
    public MemberDaoImpl(){
        
    }
    
    public MemberDaoImpl(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }
    
    public MemberDaoImpl(IMapper<Member> mapper, MemberMapper memberMapper) {
        super(mapper);
        this.memberMapper = memberMapper;
    }
    
    public MemberMapper getMemberMapper() {
        return memberMapper;
    }
    
    public void setMemberMapper(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }
    
    @Override
    public void create(Member member) {
        if(member != null){
            memberMapper.create(member);
        }
    }
    
    @Override
    public Member select(int id) {
        return memberMapper.select(id);
    }
    
    @Override
    public void update(Member member) {
        if(member != null){
            memberMapper.update(member);
        }
    }
    
    @Override
    public void delete(int id) {
        memberMapper.delete(id);
    }
    
    @Override
    public List<Member> selectAll() {
        return memberMapper.selectAll();
    }
}

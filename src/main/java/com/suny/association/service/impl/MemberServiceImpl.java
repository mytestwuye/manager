package com.suny.association.service.impl;

import com.suny.association.enums.MemberEnum;
import com.suny.association.exception.BusinessException;
import com.suny.association.mapper.MemberMapper;
import com.suny.association.pojo.po.Member;
import com.suny.association.service.AbstractBaseServiceImpl;
import com.suny.association.service.interfaces.IMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Comments:  成员逻辑层类
 * Author:   孙建荣
 * Create Date: 2017/03/07 22:35
 */
@Service
public class MemberServiceImpl extends AbstractBaseServiceImpl<Member> implements IMemberService {
    
    private MemberMapper memberMapper;
    
    @Autowired
    public MemberServiceImpl(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }
    
    public MemberServiceImpl() {
    }
    
    @Override
    public void insert(Member member) {
        memberMapper.insert(member);
    }
    
    
    public int insertReturnCount(Member member) {
        return memberMapper.insertReturnCount(member);
    }
    
    @Override
    public void deleteById(int id) {
        if (queryById(id) == null) {
            throw new BusinessException(MemberEnum.NOT_HAVE_THIS_MEMBER_INFO);
        }
        memberMapper.deleteById(id);
    }
    
    @Override
    public void update(Member member) {
        if (member.getMemberId() == null) {
            throw new BusinessException(MemberEnum.FAIL_UPDATE_MEMBER_INFO);
        } else if (memberMapper.queryById(member.getMemberId()) == null) {
            throw new BusinessException(MemberEnum.NOT_HAVE_THIS_MEMBER_INFO);
        }
        memberMapper.update(member);
    }
    
    
    @Override
    public List<Member> queryFreezeManager() {
        return memberMapper.queryFreezeManager();
    }
    
    
    @Override
    public List<Member> queryNormalManager() {
        return memberMapper.queryNormalManager();
    }
    
    
    @Override
    public List<Member> queryFreezeMember() {
        return memberMapper.queryFreezeMember();
    }
    
    
    @Override
    public List<Member> queryNormalMember() {
        return memberMapper.queryNormalMember();
    }
    
    @Override
    public Member queryById(int id) {
        return memberMapper.queryById(id);
    }
    
  
    
    @Override
    public List<Member> queryAll() {
        return memberMapper.queryAll();
    }
    
    @Override
    public List<Member> queryAll(int limit, int offset, String departmentname, int status) {
        return memberMapper.queryAllByConditions(limit, offset, departmentname, status);
    }
    
    
}

package com.suny.association.dao.impl;

import com.suny.association.dao.AbstractBaseDaoImpl;
import com.suny.association.dao.interfaces.IMemberRolesDao;
import com.suny.association.mapper.MemberRolesMapper;
import com.suny.association.pojo.po.MemberRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Comments:
 * Author:   孙建荣
 * Create Date: 2017/03/07 21:29
 */
@Repository
public  class MemberRolesDaoImpl extends AbstractBaseDaoImpl<MemberRoles> implements IMemberRolesDao {
    
    @Autowired
    private MemberRolesMapper memberRolesMapper;
    
    @Override
    public MemberRoles select(int id) {
        return memberRolesMapper.select(id);
    }
    
    @Override
    public void update(MemberRoles memberRoles) {
        if(memberRoles != null){
            memberRolesMapper.update(memberRoles);
        }
    }
    
    @Override
    public void delete(int id) {
        memberRolesMapper.delete(id);
    }
    
    /**
     * 查询全部的成员角色
     * @return   所有成员角色
     */
    @Override
    public List<MemberRoles> selectAll() {
        return memberRolesMapper.selectAll();
    }
    
    
    public MemberRolesDaoImpl() {
    }
    
    public MemberRolesDaoImpl(MemberRolesMapper memberRolesMapper) {
    
        this.memberRolesMapper = memberRolesMapper;
    }
    
    @Override
    public void create(MemberRoles memberRoles) {
        if(memberRoles != null){
            memberRolesMapper.create(memberRoles);
        }
    }
    
    public MemberRolesMapper getMemberRolesMapper() {
        
        return memberRolesMapper;
    }
    
    public void setMemberRolesMapper(MemberRolesMapper memberRolesMapper) {
        this.memberRolesMapper = memberRolesMapper;
    }
    
   
}

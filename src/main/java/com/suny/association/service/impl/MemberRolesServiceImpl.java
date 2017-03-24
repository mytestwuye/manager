package com.suny.association.service.impl;

import com.suny.association.mapper.MemberRolesMapper;
import com.suny.association.pojo.po.MemberRoles;
import com.suny.association.service.AbstractBaseServiceImpl;
import com.suny.association.service.interfaces.IMemberRolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Comments:
 * Author:   孙建荣
 * Create Date: 2017/03/07 22:36
 */
@Service
public class MemberRolesServiceImpl extends AbstractBaseServiceImpl<MemberRoles> implements IMemberRolesService {
    
    private  MemberRolesMapper memberRolesMapper;
    
    @Autowired
    public MemberRolesServiceImpl(MemberRolesMapper memberRolesMapper) {
        this.memberRolesMapper = memberRolesMapper;
    }
    
    public MemberRolesServiceImpl() {
    }
    
    
    
    /**
     * 查询所有的成员角色列表
     * @return
     */
    @Override
    public List<MemberRoles> queryAll() {
        return memberRolesMapper.queryAll();
    }
    
   
    
   
}

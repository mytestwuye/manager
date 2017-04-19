package com.suny.association.service.impl;

import com.suny.association.mapper.MemberRolesMapper;
import com.suny.association.pojo.po.MemberRoles;
import com.suny.association.service.AbstractBaseServiceImpl;
import com.suny.association.service.interfaces.IMemberRolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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


    @Override
    public MemberRoles queryByName(String name) {
        return memberRolesMapper.queryByName(name);
    }

    @Override
    public int queryCount() {
        return memberRolesMapper.queryCount();
    }

    /**
     * 查询所有的成员角色列表
     * @return 所有的成员角色数据
     */
    @Override
    public List<MemberRoles> queryAll() {
        return memberRolesMapper.queryAll();
    }

    /**
     * 根据查询条件查询成员角色
     *
     * @param criteriaMap 封装的查询条件
     * @return 成员角色
     */
    @Override
    public List<MemberRoles> list(Map criteriaMap) {
        return memberRolesMapper.list(criteriaMap);
    }


}

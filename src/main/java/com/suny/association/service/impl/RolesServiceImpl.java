package com.suny.association.service.impl;

import com.suny.association.annotation.SystemServiceLog;
import com.suny.association.mapper.RolesMapper;
import com.suny.association.pojo.po.Account;
import com.suny.association.pojo.po.Roles;
import com.suny.association.service.AbstractBaseServiceImpl;
import com.suny.association.service.interfaces.IRolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Comments:   账号角色业务逻辑
 * Author:   孙建荣
 * Create Date: 2017/03/07 22:41
 */
@Service
public class RolesServiceImpl extends AbstractBaseServiceImpl<Roles> implements IRolesService {

    private final RolesMapper rolesMapper;

    @Autowired
    public RolesServiceImpl(RolesMapper rolesMapper) {
        this.rolesMapper = rolesMapper;
    }

    /* 通过账号角色id删除一条账号角色id  */
    @SystemServiceLog(description = "删除账号角色信息失败")
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deleteById(int id) {
        rolesMapper.deleteById(id);
    }

    /*  更新一条账号角色信息 */
    @SystemServiceLog(description = " 更新账号角色失败")
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void update(Roles roles) {
        if (roles.getRoleId() == null) {
            throw new RuntimeException();
        }
        rolesMapper.update(roles);
    }

    /*  插入一条账号角色 */
    @SystemServiceLog(description = "插入账号角色失败")
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void insert(Roles roles) {
        rolesMapper.insert(roles);
    }

    /* 查询所有的账号角色     */
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    @Override
    public List<Roles> queryAll() {
        return rolesMapper.queryAll();
    }

    /* 通过查询条件查询账号角色     */
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    @Override
    public List<Roles> list(Map criteriaMap) {
        return rolesMapper.list(criteriaMap);
    }

    /* 通过账号角色id查询账号角色     */
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    @Override
    public Roles queryById(int id) {
        return rolesMapper.queryById(id);
    }

    /* 通过账号角色表中的记录数     */
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    @Override
    public int queryCount() {
        return rolesMapper.queryCount();
    }

    /* 查询触引用该角色的所有账号信息     */
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    @Override
    public List<Account> queryQuote(Integer roleId) {
        return rolesMapper.queryQuote(roleId);
    }

    /* 通过角色名字查询账号角色     */
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    @Override
    public Roles queryByName(String name) {
        return rolesMapper.queryByName(name);
    }
}

package com.suny.association.service.impl;

import com.suny.association.annotation.SystemServiceLog;
import com.suny.association.mapper.MemberRolesMapper;
import com.suny.association.pojo.po.MemberRoles;
import com.suny.association.service.AbstractBaseServiceImpl;
import com.suny.association.service.interfaces.IMemberRolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Comments:
 * Author:   孙建荣
 * Create Date: 2017/03/07 22:36
 */
@Service
public class MemberRolesServiceImpl extends AbstractBaseServiceImpl<MemberRoles> implements IMemberRolesService {

    private MemberRolesMapper memberRolesMapper;

    @Autowired
    public MemberRolesServiceImpl(MemberRolesMapper memberRolesMapper) {
        this.memberRolesMapper = memberRolesMapper;
    }

    public MemberRolesServiceImpl() {
    }

    /*    通过成员角色的id删除一条成员角色记录  */
    @SystemServiceLog(description = "删除一条成员角色记录失败")
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deleteById(int memberRoleId) {
        memberRolesMapper.deleteById(memberRoleId);
    }

    /*  通过成员的名字查询成员角色    */
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    @Override
    public MemberRoles queryByName(String name) {
        return memberRolesMapper.queryByName(name);
    }

    /*  查询数据库中成员角色表的总记录数    */
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    @Override
    public int queryCount() {
        return memberRolesMapper.queryCount();
    }

    /*  通过成员角色id查询一个成员角色    */
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    @Override
    public MemberRoles queryById(int id) {
        return memberRolesMapper.queryById(id);
    }

    /**
     * 查询所有的成员角色列表
     *
     * @return 所有的成员角色数据
     */
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
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
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    @Override
    public List<MemberRoles> list(Map criteriaMap) {
        return memberRolesMapper.list(criteriaMap);
    }

    /**
     * 插入一条成员角色记录
     *
     * @param memberRoles 成员角色信息
     */
    @SystemServiceLog(description = "插入一条成员角色记录失败")
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void insert(MemberRoles memberRoles) {
        memberRolesMapper.insert(memberRoles);
    }

    /**
     * 通过成员角色id查询引用该角色的成员
     *
     * @param memberRoleId 成员角色id
     * @return 引用该角色的成员
     */
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    @Override
    public List<MemberRoles> queryQuote(Integer memberRoleId) {
        return memberRolesMapper.queryQuote(memberRoleId);
    }


    /**
     * 更新成员角色信息
     *
     * @param memberRoles 成员角色信息
     */
    @SystemServiceLog(description = "更新一条成员角色记录失败")
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void update(MemberRoles memberRoles) {
        memberRolesMapper.update(memberRoles);
    }
}

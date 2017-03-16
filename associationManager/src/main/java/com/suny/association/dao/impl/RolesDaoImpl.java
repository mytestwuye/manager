package com.suny.association.dao.impl;

import com.suny.association.dao.AbstractBaseDaoImpl;
import com.suny.association.dao.interfaces.IRolesDao;
import com.suny.association.mapper.RolesMapper;
import com.suny.association.mapper.interfaces.IMapper;
import com.suny.association.pojo.po.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Comments:
 * Author:   孙建荣
 * Create Date: 2017/03/07 21:33
 */
@Repository
public  class RolesDaoImpl extends AbstractBaseDaoImpl<Roles> implements IRolesDao {
    
    @Autowired
    private RolesMapper rolesMapper;
    
    public RolesDaoImpl() {
    }
    
    public RolesDaoImpl(IMapper<Roles> mapper, RolesMapper rolesMapper) {

        super(mapper);
        this.rolesMapper = rolesMapper;
    }
    
    public RolesMapper getRolesMapper() {
        return rolesMapper;
    }
    
    public void setRolesMapper(RolesMapper rolesMapper) {
        this.rolesMapper = rolesMapper;
    }
    
    @Override
    public void create(Roles roles) {
        if(roles != null){
            rolesMapper.create(roles);
        }
    }
    
    @Override
    public Roles select(int id) {
        return rolesMapper.select(id);
    }
    
    @Override
    public void update(Roles roles) {
        if(roles != null){
            rolesMapper.update(roles);
        }
    }
    
    @Override
    public void delete(int id) {
        rolesMapper.delete(id);
    }
    
    @Override
    public List<Roles> selectAll() {
        return rolesMapper.selectAll();
    }
}

package com.suny.association.dao.impl;

import com.suny.association.dao.AbstractBaseDaoImpl;
import com.suny.association.dao.interfaces.IDepartmentDao;
import com.suny.association.mapper.DepartmentMapper;
import com.suny.association.mapper.interfaces.IMapper;
import com.suny.association.pojo.po.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Comments:
 * Author:   孙建荣
 * Create Date: 2017/03/17 22:37
 */
@Repository
public class DepartmentDaoImpl extends AbstractBaseDaoImpl<Department> implements IDepartmentDao {
    
    @Autowired
    private DepartmentMapper departmentMapper;
    
    
    @Override
    public void create(Department department) {
        
    }
    
    @Override
    public Department select(int id) {
        return null;
    }
    
    @Override
    public void update(Department department) {
        
    }
    
    @Override
    public void delete(int id) {
        
    }
    
    /**
     * 查询所有的部门列表
     * @return
     */
    @Override
    public List<Department> selectAll() {
        return departmentMapper.selectAll();
    }
    
    
    public DepartmentDaoImpl() {
    }
    
    public DepartmentDaoImpl(IMapper<Department> mapper) {
        super(mapper);
    }
    
    public DepartmentMapper getDepartmentMapper() {
        return departmentMapper;
    }
    
    public void setDepartmentMapper(DepartmentMapper departmentMapper) {
        this.departmentMapper = departmentMapper;
    }
    
   
}

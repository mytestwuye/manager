package com.suny.association.service.impl;

import com.suny.association.mapper.DepartmentMapper;
import com.suny.association.pojo.po.Department;
import com.suny.association.service.AbstractBaseServiceImpl;
import com.suny.association.service.interfaces.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Comments:
 * Author:   孙建荣
 * Create Date: 2017/03/17 22:34
 */
@Service
public class DepartmentServiceImpl extends AbstractBaseServiceImpl<Department> implements IDepartmentService {
    private  DepartmentMapper departmentMapper;
    
    @Autowired
    public DepartmentServiceImpl(DepartmentMapper departmentMapper) {
        this.departmentMapper = departmentMapper;
    }
    
    public DepartmentServiceImpl() {
    }
    
    @Override
    public int insertAndGetId(Department department) {
        return departmentMapper.insertAndGetId(department);
    }
    
    @Override
    public List<Department> selectForAll() {
        return departmentMapper.selectAll();
    }
    
    
    
}

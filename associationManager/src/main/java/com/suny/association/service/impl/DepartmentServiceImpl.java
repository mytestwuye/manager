package com.suny.association.service.impl;

import com.suny.association.dao.interfaces.IDepartmentDao;
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
    @Autowired
    private IDepartmentDao departmentDao;
    
    
    @Override
    public List<Department> queryForAll() {
        return departmentDao.selectAll();
    }
    
    
}

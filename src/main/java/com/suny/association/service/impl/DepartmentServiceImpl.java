package com.suny.association.service.impl;

import com.suny.association.mapper.DepartmentMapper;
import com.suny.association.pojo.po.Department;
import com.suny.association.service.AbstractBaseServiceImpl;
import com.suny.association.service.interfaces.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Comments:   部门表业务逻辑
 * Author:   孙建荣
 * Create Date: 2017/03/17 22:34
 */
@Service
public class DepartmentServiceImpl extends AbstractBaseServiceImpl<Department> implements IDepartmentService {
    private DepartmentMapper departmentMapper;

    @Autowired
    public DepartmentServiceImpl(DepartmentMapper departmentMapper) {
        this.departmentMapper = departmentMapper;
    }

    public DepartmentServiceImpl() {
    }

    /* 通过部门名字查询部门记录  */
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    @Override
    public Department queryByName(String name) {
        return departmentMapper.queryByName(name);
    }

    /* 查询部门表总记录数  */
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    @Override
    public int queryCount() {
        return departmentMapper.queryCount();
    }

    /* 查询部门表所有的记录  */
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    @Override
    public List<Department> queryAll() {
        return departmentMapper.queryAll();
    }

    /**
     * 通过查询条件查询部门表记录
     *
     * @param criteriaMap 自己封装的查询条件
     * @return 带查询条件的部门表记录
     */
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    @Override
    public List<Department> list(Map<Object, Object> criteriaMap) {
        return departmentMapper.list(criteriaMap);
    }


}

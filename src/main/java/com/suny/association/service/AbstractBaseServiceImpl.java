package com.suny.association.service;

import com.suny.association.mapper.interfaces.IMapper;

import java.util.List;

/**
 * Comments:   通用方法实现类
 * Author:   孙建荣
 * Create Date: 2017/03/07 21:59
 */
public abstract class AbstractBaseServiceImpl<T> implements IBaseService<T> {

    private IMapper<T> mapper;

    public AbstractBaseServiceImpl() {
    }

   

    @Override
    public void insert(T t) {
        if (t != null) {
            mapper.insert(t);
        }

    }

    @Override
    public void deleteById(int id) {
        mapper.deleteById(id);

    }

    @Override
    public void update(T t) {
        if (t != null) {
            mapper.update(t);
        }
    }

    @Override
    public T queryById(int id) {
        return mapper.queryById(id);
    }

    @Override
    public List<T> queryAll() {
        return mapper.queryAll();
    }
}

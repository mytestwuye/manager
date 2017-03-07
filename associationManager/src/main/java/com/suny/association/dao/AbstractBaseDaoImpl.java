package com.suny.association.dao;

import com.suny.association.mapper.interfaces.IMapper;

import java.util.List;

/**
 * Comments:  通用dao操作接口抽象实现类
 * Author:   孙建荣
 * Create Date: 2017/03/07 14:56
 */
public  abstract class AbstractBaseDaoImpl<T> implements IBaseDao<T> {

    private IMapper<T> mapper;

    public AbstractBaseDaoImpl(IMapper<T> mapper) {
        this.mapper = mapper;
    }

    public IMapper<T> getMapper() {
        return mapper;
    }

    public void setMapper(IMapper<T> mapper) {
        this.mapper = mapper;
    }

    @Override
    public void create(T t) {
        if( t != null) {
            mapper.create(t);
        }
    }

    @Override
    public T select(int id) {
        return mapper.select(id);
    }

    @Override
    public void update(T t) {

        if( t != null){
            mapper.update(t);
        }
    }

    @Override
    public void delete(int id) {

        mapper.delete(id);
    }

    @Override
    public List<T> selectAll() {
        return mapper.selectAll();
    }
}

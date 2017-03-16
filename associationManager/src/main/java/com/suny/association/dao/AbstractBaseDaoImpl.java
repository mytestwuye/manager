package com.suny.association.dao;

import com.suny.association.mapper.interfaces.IMapper;
import org.springframework.stereotype.Repository;

/**
 * Comments:  通用dao操作接口抽象实现类
 * Author:   孙建荣
 * Create Date: 2017/03/07 14:56
 */
@Repository
public  abstract class AbstractBaseDaoImpl<T> implements IBaseDao<T> {

    private IMapper<T> mapper;

    public AbstractBaseDaoImpl() {
    }

    public AbstractBaseDaoImpl(IMapper<T> mapper) {
        this.mapper = mapper;
    }

    public IMapper<T> getMapper() {
        return mapper;
    }

    public void setMapper(IMapper<T> mapper) {
        this.mapper = mapper;
    }
    
}

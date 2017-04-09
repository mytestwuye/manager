package com.suny.association.mapper.interfaces;

import java.util.List;

/**
 * Comments:  通用的mapper接口
 * Author:   孙建荣
 * Create Date: 2017/03/07 14:26
 */
public interface IMapper<T> {
    
    void insert(T t);
    
    int insertAndGetId(T t);
    
    void deleteById(int id);
    
    void update(T t);
    
    T queryById(int id);
    
    T queryByName(String name);
    
    List<T> queryAll();
    
    
}










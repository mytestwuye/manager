package com.suny.association.mapper.interfaces;

import java.util.List;
import java.util.Map;

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

    int queryCount();
    List<T> queryAll();

    List<T> list(Map<Object, Object> criteriaMap);

}










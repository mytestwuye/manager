package com.suny.association.service;

import java.util.List;
import java.util.Map;

/**
 * Comments:   通用的逻辑层方法
 * Author:   孙建荣
 * Create Date: 2017/03/07 21:53
 */
public interface IBaseService<T> {
    void insert(T t);
    void deleteById(int id);
    void update(T t);
    T queryById(int id);

    T queryByName(String name);

    int queryCount();
    List<T> queryAll();

    List<T> list(Map<Object, Object> criteriaMap);
}

package com.suny.association.service;

import java.util.List;

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


    List<T> queryAll();
}

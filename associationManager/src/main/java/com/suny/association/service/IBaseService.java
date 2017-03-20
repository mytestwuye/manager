package com.suny.association.service;

import java.util.List;

/**
 * Comments:   通用的逻辑层方法
 * Author:   孙建荣
 * Create Date: 2017/03/07 21:53
 */
public interface IBaseService<T> {

    /**
     * 通用的插入方法
     * @param t  要插入的对象
     */
     void insert(T t);
    
    /**
     * 插入一条数据并返回主键id
     * @param t   插入的实体
     * @return   插入数据的主键id
     */
    int insertAndGetId(T t);

    /**
     * 通用的删除方法
     * @param id  要删除的对象的主键
     */
     void deleteById(int id);

    /**
     * 通用的更新方法
     * @param t  要更新的对象
     */
     void update(T t);

    /**
     *  通用的通过主键id查询数据
     * @param id  主键id
     * @return  该主键id对应的数据
     */
     T selectById(int id);

    /**
     * 通用的查询所有记录方法
     * @return  查询出来的所有对象
     */
     List<T> selectForAll();
}

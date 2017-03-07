package com.suny.association.dao.interfaces;

import java.util.List;

/**
 * Comments:  通用dao操作接口
 * Author:   孙建荣
 * Create Date: 2017/03/07 14:53
 */
public interface IBaseDao<T> {

    /**
     * 通用的插入方法
     * @param t  要插入的对象
     */
    public void create(T t);

    /**
     * 通用的查询方法
     * @param id  要查询的主键id
     * @return   查询出来的对象
     */
    public T select(int id);


    /**
     * 通用的更新方法
     * @param t  要更新的对象
     */
    public void update(T t);

    /**
     * 通用的删除方法
     * @param id  要删除的对象的主键
     */
    public void delete(int id);

    /**
     * 通用的查询所有记录方法
     * @return  查询出来的所有对象
     */
    public List<T> selectAll();

}

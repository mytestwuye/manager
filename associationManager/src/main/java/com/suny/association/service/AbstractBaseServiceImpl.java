package com.suny.association.service;

import com.suny.association.dao.IBaseDao;

import java.util.List;

/**
 * Comments:   通用方法实现类
 * Author:   孙建荣
 * Create Date: 2017/03/07 21:59
 */
public abstract class AbstractBaseServiceImpl<T> implements IBaseService<T> {

    private IBaseDao<T> iBaseDao;

    public AbstractBaseServiceImpl() {
    }

    public AbstractBaseServiceImpl(IBaseDao<T> iBaseDao) {
        if (iBaseDao != null){

            this.iBaseDao = iBaseDao;
        }
    }

    public IBaseDao<T> getiBaseDao() {
        return iBaseDao;
    }

    public void setiBaseDao(IBaseDao<T> iBaseDao) {
        this.iBaseDao = iBaseDao;

    }

    @Override
    public void add(T t) {
        if (t != null) {
            iBaseDao.create(t);
        }

    }

    @Override
    public void deleteById(int id) {
        iBaseDao.delete(id);

    }

    @Override
    public void update(T t) {
        if (t != null) {
            iBaseDao.update(t);
        }
    }

    @Override
    public T queryById(int id) {
        return iBaseDao.select(id);
    }

    @Override
    public List<T> queryForAll() {
        return iBaseDao.selectAll();
    }
}

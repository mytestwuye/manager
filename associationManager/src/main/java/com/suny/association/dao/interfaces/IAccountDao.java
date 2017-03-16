package com.suny.association.dao.interfaces;

import com.suny.association.dao.IBaseDao;
import com.suny.association.pojo.po.Account;


public interface IAccountDao extends IBaseDao<Account> {
    
    
    
    
    /**
     * 通过用户名查询出对应的账号
     * @param username
     * @return
     */
    public Account selectByUserName(String username);
}
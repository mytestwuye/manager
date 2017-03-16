package com.suny.association.service.interfaces;

import com.suny.association.pojo.po.Account;
import com.suny.association.service.IBaseService;

/**
 * Comments:
 * Author:   孙建荣
 * Create Date: 2017/03/07 22:09
 */

public interface IAccountService extends IBaseService<Account> {

    /**
     * 通过用户名查询账号信息
     * @param username  用户名
     * @return 账号的信息
     */
    public Account selectByUserName(String username);
}

package com.suny.association.service.interfaces;

import com.suny.association.pojo.po.Account;
import com.suny.association.pojo.po.Roles;
import com.suny.association.service.IBaseService;

import java.util.List;

/**
 * Comments:
 * Author:   孙建荣
 * Create Date: 2017/03/07 22:17
 */
public interface IRolesService extends IBaseService<Roles> {
    List<Account> queryQuote(Integer roleId);

    Roles queryByName(String name);

    List<Roles> list(int offset, int limit);

    int queryCount();
}

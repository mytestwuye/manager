package com.suny.association.service.interfaces;

import com.suny.association.pojo.po.Account;
import com.suny.association.service.IBaseService;

/**
 * Comments:
 * Author:   孙建荣
 * Create Date: 2017/03/07 22:09
 */

public interface IAccountService extends IBaseService<Account> {
    
    
    Account queryByName(String name);
    
    
}

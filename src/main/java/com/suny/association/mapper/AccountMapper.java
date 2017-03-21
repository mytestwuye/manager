package com.suny.association.mapper;

import com.suny.association.mapper.interfaces.IMapper;
import com.suny.association.pojo.po.Account;

/**
 * Comments:  账号表mapper接口映射
 * Author:   孙建荣
 * Create Date: 2017/03/05 23:05
 */
public interface AccountMapper  extends IMapper<Account>{
    
    
    /**
     * 通过账号绑定的id查询账号信息
     *
     * @param memberId 成员id
     * @return 账号的信息
     */
     Account selectByMemberId(int memberId);
    
    
    /**
     * 通过用户名查找用户的账号的信息
     * @param username
     * @return
     */
     Account selectByUserName(String username);
    
}
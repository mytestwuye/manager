package com.suny.association.mapper;

import com.suny.association.mapper.interfaces.IMapper;
import com.suny.association.pojo.po.Account;

import java.util.List;
import java.util.Map;

/**
 * Comments:  账号表mapper接口映射
 * Author:   孙建荣
 * Create Date: 2017/03/05 23:05
 */
public interface AccountMapper  extends IMapper<Account>{
    Account queryByPhone(Long phoneNumber);
    Account queryByMail(String email);
    Account queryQuote(Long accountId);
    Account queryByLongId(Long id);
    void deleteByLongId(Long id);
    List<Account> queryAllByCriteria(Map<Object,Object> criteriaMap);
}
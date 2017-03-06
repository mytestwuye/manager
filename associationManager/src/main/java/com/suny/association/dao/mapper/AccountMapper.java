package com.suny.association.dao.mapper;

import com.suny.association.pojo.po.Account;
import com.suny.association.pojo.po.AccountExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AccountMapper {
    int countByExample(AccountExample example);

    int deleteByExample(AccountExample example);

    int deleteByPrimaryKey(Long accountId);

    int insert(Account record);

    int insertSelective(Account record);

    List<Account> selectByExample(AccountExample example);

    Account selectByPrimaryKey(Long accountId);

    int updateByExampleSelective(@Param("record") Account record, @Param("example") AccountExample example);

    int updateByExample(@Param("record") Account record, @Param("example") AccountExample example);

    int updateByPrimaryKeySelective(Account record);

    int updateByPrimaryKey(Account record);
}
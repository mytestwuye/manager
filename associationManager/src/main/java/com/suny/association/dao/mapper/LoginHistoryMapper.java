package com.suny.association.dao.mapper;

import com.suny.association.pojo.po.LoginHistory;
import com.suny.association.pojo.po.LoginHistoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LoginHistoryMapper {
    int countByExample(LoginHistoryExample example);

    int deleteByExample(LoginHistoryExample example);

    int deleteByPrimaryKey(Long loginHistoryId);

    int insert(LoginHistory record);

    int insertSelective(LoginHistory record);

    List<LoginHistory> selectByExample(LoginHistoryExample example);

    LoginHistory selectByPrimaryKey(Long loginHistoryId);

    int updateByExampleSelective(@Param("record") LoginHistory record, @Param("example") LoginHistoryExample example);

    int updateByExample(@Param("record") LoginHistory record, @Param("example") LoginHistoryExample example);

    int updateByPrimaryKeySelective(LoginHistory record);

    int updateByPrimaryKey(LoginHistory record);
}
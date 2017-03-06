package com.suny.association.dao.mapper;

import com.suny.association.pojo.po.ApplicationMessage;
import com.suny.association.pojo.po.ApplicationMessageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ApplicationMessageMapper {
    int countByExample(ApplicationMessageExample example);

    int deleteByExample(ApplicationMessageExample example);

    int deleteByPrimaryKey(Integer applicationId);

    int insert(ApplicationMessage record);

    int insertSelective(ApplicationMessage record);

    List<ApplicationMessage> selectByExample(ApplicationMessageExample example);

    ApplicationMessage selectByPrimaryKey(Integer applicationId);

    int updateByExampleSelective(@Param("record") ApplicationMessage record, @Param("example") ApplicationMessageExample example);

    int updateByExample(@Param("record") ApplicationMessage record, @Param("example") ApplicationMessageExample example);

    int updateByPrimaryKeySelective(ApplicationMessage record);

    int updateByPrimaryKey(ApplicationMessage record);
}
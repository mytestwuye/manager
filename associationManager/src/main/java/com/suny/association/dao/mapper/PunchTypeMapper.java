package com.suny.association.dao.mapper;

import com.suny.association.pojo.po.PunchType;
import com.suny.association.pojo.po.PunchTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PunchTypeMapper {
    int countByExample(PunchTypeExample example);

    int deleteByExample(PunchTypeExample example);

    int deleteByPrimaryKey(Integer punchTypeId);

    int insert(PunchType record);

    int insertSelective(PunchType record);

    List<PunchType> selectByExample(PunchTypeExample example);

    PunchType selectByPrimaryKey(Integer punchTypeId);

    int updateByExampleSelective(@Param("record") PunchType record, @Param("example") PunchTypeExample example);

    int updateByExample(@Param("record") PunchType record, @Param("example") PunchTypeExample example);

    int updateByPrimaryKeySelective(PunchType record);

    int updateByPrimaryKey(PunchType record);
}
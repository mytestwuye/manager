package com.suny.association.dao.mapper;

import com.suny.association.pojo.po.CheckbackResult;
import com.suny.association.pojo.po.CheckbackResultExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CheckbackResultMapper {
    int countByExample(CheckbackResultExample example);

    int deleteByExample(CheckbackResultExample example);

    int deleteByPrimaryKey(Integer checkbackId);

    int insert(CheckbackResult record);

    int insertSelective(CheckbackResult record);

    List<CheckbackResult> selectByExample(CheckbackResultExample example);

    CheckbackResult selectByPrimaryKey(Integer checkbackId);

    int updateByExampleSelective(@Param("record") CheckbackResult record, @Param("example") CheckbackResultExample example);

    int updateByExample(@Param("record") CheckbackResult record, @Param("example") CheckbackResultExample example);

    int updateByPrimaryKeySelective(CheckbackResult record);

    int updateByPrimaryKey(CheckbackResult record);
}
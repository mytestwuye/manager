package com.suny.association.dao.mapper;

import com.suny.association.pojo.po.PunchRecord;
import com.suny.association.pojo.po.PunchRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PunchRecordMapper {
    int countByExample(PunchRecordExample example);

    int deleteByExample(PunchRecordExample example);

    int deleteByPrimaryKey(Long punchRecordId);

    int insert(PunchRecord record);

    int insertSelective(PunchRecord record);

    List<PunchRecord> selectByExample(PunchRecordExample example);

    PunchRecord selectByPrimaryKey(Long punchRecordId);

    int updateByExampleSelective(@Param("record") PunchRecord record, @Param("example") PunchRecordExample example);

    int updateByExample(@Param("record") PunchRecord record, @Param("example") PunchRecordExample example);

    int updateByPrimaryKeySelective(PunchRecord record);

    int updateByPrimaryKey(PunchRecord record);
}
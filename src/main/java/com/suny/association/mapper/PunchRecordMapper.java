package com.suny.association.mapper;

import com.suny.association.mapper.interfaces.IMapper;
import com.suny.association.pojo.po.PunchRecord;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;
import java.util.List;

/**
 * Comments:  打卡记录表mapper映射
 * Author:   孙建荣
 * Create Date: 2017/03/05 23:05
 */

public interface PunchRecordMapper extends IMapper<PunchRecord> {
    PunchRecord queryByMemberIdAndDate(@Param("memberId") Integer memberId, @Param("date") LocalDate date);

    int updatePunch(PunchRecord punchRecord);

    int batchInsertsPunchRecord(List<PunchRecord> punchRecordList);

    List<PunchRecord> queryByPunchDate(LocalDate localDate);
}
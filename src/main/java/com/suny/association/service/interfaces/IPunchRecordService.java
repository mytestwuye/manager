package com.suny.association.service.interfaces;

import com.suny.association.pojo.po.PunchRecord;
import com.suny.association.pojo.po.PunchType;
import com.suny.association.service.IBaseService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Comments:
 * Author:   孙建荣
 * Create Date: 2017/03/07 22:15
 */
public interface IPunchRecordService extends IBaseService<PunchRecord> {
    void updatePunchType(PunchRecord punchRecord, PunchType punchType);

    int updatePunch(@Param("memberId") Integer memberId, @Param("punchRecordId") Long punchRecordId);

    PunchRecord queryByMemberIdAndDate(Integer memberId);

    int batchInsertsPunchRecord();

    List<PunchRecord> queryByPunchDate();
}

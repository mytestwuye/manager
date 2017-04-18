package com.suny.association.service.interfaces;

import com.suny.association.pojo.po.PunchRecord;
import com.suny.association.pojo.po.PunchType;
import com.suny.association.service.IBaseService;

import java.util.List;

/**
 * Comments:
 * Author:   孙建荣
 * Create Date: 2017/03/07 22:15
 */
public interface IPunchRecordService  extends IBaseService<PunchRecord> {

    void updatePunchType(PunchRecord punchRecord, PunchType punchType);

    List<PunchRecord> list(int offset, int limit);

    int queryCount();
}

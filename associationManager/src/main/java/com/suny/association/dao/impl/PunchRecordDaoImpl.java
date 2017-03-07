package com.suny.association.dao.impl;

import com.suny.association.dao.AbstractBaseDaoImpl;
import com.suny.association.dao.interfaces.IPunchRecordDao;
import com.suny.association.mapper.PunchRecordMapper;
import com.suny.association.mapper.interfaces.IMapper;
import com.suny.association.pojo.po.PunchRecord;

/**
 * Comments:
 * Author:   孙建荣
 * Create Date: 2017/03/07 21:31
 */
public class PunchRecordDaoImpl extends AbstractBaseDaoImpl<PunchRecord> implements IPunchRecordDao {
    private PunchRecordMapper punchRecordMapper;

    public PunchRecordMapper getPunchRecordMapper() {
        return punchRecordMapper;
    }

    public void setPunchRecordMapper(PunchRecordMapper punchRecordMapper) {
        this.punchRecordMapper = punchRecordMapper;
    }

    public PunchRecordDaoImpl(IMapper<PunchRecord> mapper, PunchRecordMapper punchRecordMapper) {

        super(mapper);
        this.punchRecordMapper = punchRecordMapper;
    }
}

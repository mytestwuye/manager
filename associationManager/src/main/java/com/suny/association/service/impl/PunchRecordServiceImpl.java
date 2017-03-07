package com.suny.association.service.impl;

import com.suny.association.dao.IBaseDao;
import com.suny.association.dao.interfaces.IPunchRecordDao;
import com.suny.association.pojo.po.PunchRecord;
import com.suny.association.service.AbstractBaseServiceImpl;
import com.suny.association.service.interfaces.IPunchRecordService;

/**
 * Comments:
 * Author:   孙建荣
 * Create Date: 2017/03/07 22:39
 */
public class PunchRecordServiceImpl extends AbstractBaseServiceImpl<PunchRecord> implements IPunchRecordService {
    private IPunchRecordDao iPunchRecordDao;

    public IPunchRecordDao getiPunchRecordDao() {
        return iPunchRecordDao;
    }

    public void setiPunchRecordDao(IPunchRecordDao iPunchRecordDao) {
        this.iPunchRecordDao = iPunchRecordDao;
    }

    public PunchRecordServiceImpl(IBaseDao<PunchRecord> iBaseDao, IPunchRecordDao iPunchRecordDao) {

        super(iBaseDao);
        this.iPunchRecordDao = iPunchRecordDao;
    }
}

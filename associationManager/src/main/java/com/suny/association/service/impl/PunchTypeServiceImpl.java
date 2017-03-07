package com.suny.association.service.impl;

import com.suny.association.dao.IBaseDao;
import com.suny.association.dao.interfaces.IPunchTypeDao;
import com.suny.association.pojo.po.PunchType;
import com.suny.association.service.AbstractBaseServiceImpl;
import com.suny.association.service.interfaces.IPunchTypeService;

/**
 * Comments:
 * Author:   孙建荣
 * Create Date: 2017/03/07 22:40
 */
public class PunchTypeServiceImpl extends AbstractBaseServiceImpl<PunchType>  implements IPunchTypeService{
    private IPunchTypeDao iPunchTypeDao;

    public IPunchTypeDao getiPunchTypeDao() {
        return iPunchTypeDao;
    }

    public void setiPunchTypeDao(IPunchTypeDao iPunchTypeDao) {
        this.iPunchTypeDao = iPunchTypeDao;
    }

    public PunchTypeServiceImpl(IBaseDao<PunchType> iBaseDao, IPunchTypeDao iPunchTypeDao) {

        super(iBaseDao);
        this.iPunchTypeDao = iPunchTypeDao;
    }
}

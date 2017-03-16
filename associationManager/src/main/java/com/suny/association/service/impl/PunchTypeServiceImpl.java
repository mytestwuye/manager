package com.suny.association.service.impl;

import com.suny.association.dao.IBaseDao;
import com.suny.association.dao.interfaces.IPunchTypeDao;
import com.suny.association.pojo.po.PunchType;
import com.suny.association.service.AbstractBaseServiceImpl;
import com.suny.association.service.interfaces.IPunchTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Comments:
 * Author:   孙建荣
 * Create Date: 2017/03/07 22:40
 */
@Service
public class PunchTypeServiceImpl extends AbstractBaseServiceImpl<PunchType>  implements IPunchTypeService{
    
    @Autowired
    private IPunchTypeDao punchTypeDao;
    
    public PunchTypeServiceImpl() {
    }
    
    public PunchTypeServiceImpl(IBaseDao<PunchType> iBaseDao) {
        super(iBaseDao);
    }
    
    public IPunchTypeDao getPunchTypeDao() {
        return punchTypeDao;
    }
    
    public void setPunchTypeDao(IPunchTypeDao punchTypeDao) {
        this.punchTypeDao = punchTypeDao;
    }
}

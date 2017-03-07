package com.suny.association.dao.impl;

import com.suny.association.dao.AbstractBaseDaoImpl;
import com.suny.association.dao.interfaces.IApplicationMessageDao;
import com.suny.association.mapper.ApplicationMessageMapper;
import com.suny.association.mapper.interfaces.IMapper;
import com.suny.association.pojo.po.ApplicationMessage;

/**
 * Comments:
 * Author:   孙建荣
 * Create Date: 2017/03/07 21:19
 */
public class ApplicationMessageDaoImpl extends AbstractBaseDaoImpl<ApplicationMessage> implements IApplicationMessageDao {

    private ApplicationMessageMapper applicationMessageMapper;

    public ApplicationMessageDaoImpl(IMapper mapper, ApplicationMessageMapper applicationMessageMapper) {
        super(mapper);
        this.applicationMessageMapper = applicationMessageMapper;
    }

    public ApplicationMessageMapper getApplicationMessageMapper() {
        return applicationMessageMapper;
    }

    public void setApplicationMessageMapper(ApplicationMessageMapper applicationMessageMapper) {
        this.applicationMessageMapper = applicationMessageMapper;
    }
}

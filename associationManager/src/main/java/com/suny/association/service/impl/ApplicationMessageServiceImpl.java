package com.suny.association.service.impl;

import com.suny.association.dao.IBaseDao;
import com.suny.association.pojo.po.ApplicationMessage;
import com.suny.association.service.AbstractBaseServiceImpl;
import com.suny.association.service.interfaces.IApplicationMessageService;

/**
 * Comments:
 * Author:   孙建荣
 * Create Date: 2017/03/07 22:30
 */
public class ApplicationMessageServiceImpl extends AbstractBaseServiceImpl<ApplicationMessage> implements IApplicationMessageService {
    private IApplicationMessageService iApplicationMessageService;

    public IApplicationMessageService getiApplicationMessageService() {
        return iApplicationMessageService;
    }

    public void setiApplicationMessageService(IApplicationMessageService iApplicationMessageService) {
        this.iApplicationMessageService = iApplicationMessageService;
    }

    public ApplicationMessageServiceImpl(IBaseDao<ApplicationMessage> iBaseDao, IApplicationMessageService iApplicationMessageService) {
        super(iBaseDao);
        this.iApplicationMessageService = iApplicationMessageService;
    }
}

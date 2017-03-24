package com.suny.association.service.impl;

import com.suny.association.mapper.ApplicationMessageMapper;
import com.suny.association.pojo.po.ApplicationMessage;
import com.suny.association.service.AbstractBaseServiceImpl;
import com.suny.association.service.interfaces.IApplicationMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Comments:
 * Author:   孙建荣
 * Create Date: 2017/03/07 22:30
 */
@Service
public class ApplicationMessageServiceImpl extends AbstractBaseServiceImpl<ApplicationMessage> implements IApplicationMessageService {
    
    private  ApplicationMessageMapper applicationMessageMapper;
    
    @Autowired
    public ApplicationMessageServiceImpl(ApplicationMessageMapper applicationMessageMapper) {
        this.applicationMessageMapper = applicationMessageMapper;
    }
    
    public ApplicationMessageServiceImpl() {
    }
    
    
  
}

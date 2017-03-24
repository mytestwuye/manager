package com.suny.association.service.impl;

import com.suny.association.mapper.CheckbackResultMapper;
import com.suny.association.pojo.po.CheckbackResult;
import com.suny.association.service.AbstractBaseServiceImpl;
import com.suny.association.service.interfaces.ICheckbackResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Comments:
 * Author:   孙建荣
 * Create Date: 2017/03/07 22:33
 */
@Service
public class CheckbackResultServiceImpl extends AbstractBaseServiceImpl<CheckbackResult> implements ICheckbackResultService {
    
    private  CheckbackResultMapper checkbackResultMapper;
    
    @Autowired
    public CheckbackResultServiceImpl(CheckbackResultMapper checkbackResultMapper) {
        this.checkbackResultMapper = checkbackResultMapper;
    }
    
    public CheckbackResultServiceImpl() {
    }
    
    
  
}

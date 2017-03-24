package com.suny.association.service.impl;

import com.suny.association.mapper.PunchTypeMapper;
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
    
    private  PunchTypeMapper punchTypeMapper;
    
    @Autowired
    public PunchTypeServiceImpl(PunchTypeMapper punchTypeMapper) {
        this.punchTypeMapper = punchTypeMapper;
    }
    
    public PunchTypeServiceImpl() {
    }
    
    
}

package com.suny.association.service.impl;

import com.suny.association.mapper.PunchTypeMapper;
import com.suny.association.pojo.po.PunchType;
import com.suny.association.service.AbstractBaseServiceImpl;
import com.suny.association.service.interfaces.IPunchTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Comments:  考勤类型业务逻辑
 * Author:   孙建荣
 * Create Date: 2017/03/07 22:40
 */
@Service
public class PunchTypeServiceImpl extends AbstractBaseServiceImpl<PunchType> implements IPunchTypeService {

    private PunchTypeMapper punchTypeMapper;

    @Autowired
    public PunchTypeServiceImpl(PunchTypeMapper punchTypeMapper) {
        this.punchTypeMapper = punchTypeMapper;
    }

    public PunchTypeServiceImpl() {
    }

    @Override
    public void update(PunchType punchType) {
        punchTypeMapper.update(punchType);
    }

    @Override
    public PunchType queryByName(String name) {
        return punchTypeMapper.queryByName(name);
    }

    @Override
    public int queryCount() {
        return punchTypeMapper.queryCount();
    }

    @Override
    public List<PunchType> list(Map<Object, Object> criteriaMap) {
        return punchTypeMapper.list(criteriaMap);
    }
}

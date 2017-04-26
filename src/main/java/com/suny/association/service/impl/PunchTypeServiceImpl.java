package com.suny.association.service.impl;

import com.suny.association.annotation.SystemServiceLog;
import com.suny.association.mapper.PunchTypeMapper;
import com.suny.association.pojo.po.PunchType;
import com.suny.association.service.AbstractBaseServiceImpl;
import com.suny.association.service.interfaces.IPunchTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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

    /*   更细一条考勤类型信息失败   */
    @SystemServiceLog(description = "更新一条考勤类型信息失败")
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void update(PunchType punchType) {
        punchTypeMapper.update(punchType);
    }

    /*  通过考勤类型名字查询一条记录   */
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    @Override
    public PunchType queryByName(String name) {
        return punchTypeMapper.queryByName(name);
    }

    /*  查询考勤类型表的总记录数    */
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    @Override
    public int queryCount() {
        return punchTypeMapper.queryCount();
    }

    /*  通过查询条件查询考勤类型记录    */
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    @Override
    public List<PunchType> list(Map<Object, Object> criteriaMap) {
        return punchTypeMapper.list(criteriaMap);
    }
}

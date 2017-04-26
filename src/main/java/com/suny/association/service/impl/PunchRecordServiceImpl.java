package com.suny.association.service.impl;

import com.suny.association.annotation.SystemControllerLog;
import com.suny.association.mapper.PunchRecordMapper;
import com.suny.association.pojo.po.PunchRecord;
import com.suny.association.pojo.po.PunchType;
import com.suny.association.service.AbstractBaseServiceImpl;
import com.suny.association.service.interfaces.IPunchRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Comments:   考勤记录逻辑
 * Author:   孙建荣
 * Create Date: 2017/03/07 22:39
 */
@Service
public class PunchRecordServiceImpl extends AbstractBaseServiceImpl<PunchRecord> implements IPunchRecordService {

    private PunchRecordMapper punchRecordMapper;

    @Autowired
    public PunchRecordServiceImpl(PunchRecordMapper punchRecordMapper) {
        this.punchRecordMapper = punchRecordMapper;
    }

    public PunchRecordServiceImpl() {
    }

    /**
     * 更新考勤记录类型
     *
     * @param punchRecord     对应的考勤记录
     * @param changePunchType 想改为什么类型
     */
    @SystemControllerLog(description = "更新一条考勤记录中的考勤类型失败")
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void updatePunchType(PunchRecord punchRecord, PunchType changePunchType) {
        punchRecord.setPunchTypeId(changePunchType);
        this.update(punchRecord);
    }

    /*   查询考勤记录表中的总记录数   */
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    @Override
    public int queryCount() {
        return punchRecordMapper.queryCount();
    }

    /*   通过查询条件查询考勤记录   */
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    @Override
    public List<PunchRecord> list(Map<Object, Object> criteriaMap) {
        return punchRecordMapper.list(criteriaMap);
    }

    /*  更新一条考勤记录    */
    @SystemControllerLog(description = "更新考勤记录信息失败")
    @Transactional(rollbackFor = {Exception.class})
    @Override
    public void update(PunchRecord punchRecord) {
        punchRecordMapper.update(punchRecord);
    }

    /*  通过名字一条考勤记录    */
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    @Override
    public PunchRecord queryByName(String name) {
        return punchRecordMapper.queryByName(name);
    }
}

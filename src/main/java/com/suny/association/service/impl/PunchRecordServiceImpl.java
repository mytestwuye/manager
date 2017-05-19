package com.suny.association.service.impl;

import com.suny.association.annotation.SystemControllerLog;
import com.suny.association.annotation.SystemServiceLog;
import com.suny.association.mapper.PunchRecordMapper;
import com.suny.association.pojo.po.Member;
import com.suny.association.pojo.po.PunchRecord;
import com.suny.association.pojo.po.PunchType;
import com.suny.association.service.AbstractBaseServiceImpl;
import com.suny.association.service.interfaces.IPunchRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
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

    @SystemServiceLog(description = "成员考勤失败")
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updatePunch(Integer memberId, Long punchRecordId) {
        /* 组成一条考勤记录需要有考勤的Member信息，考勤类型PunchType， */
        //  使用Java8的LocalDateTime，抛弃以前难用的Date吧
        LocalDateTime dateTime = LocalDateTime.now();
        //   实例化一个考勤记录对象
        PunchRecord punchRecord = new PunchRecord();
        //  首先放入考勤记录的ID，可与考勤的状态必定数据库有一条缺勤的记录
        punchRecord.setPunchRecordId(punchRecordId);
        //   设置考勤时间
        punchRecord.setPunchDatetime(dateTime);
        //  设置考勤是否来了
        punchRecord.setPunchIsCome(true);
        //   实例化一个考勤类型对象
        PunchType punchType = new PunchType();
        //  设置考勤类型，这里应该按照时间来判断设置数值
        punchType.setPunchTypeId(1);
        // 把考勤类型设置到考勤记录里面去
        punchRecord.setPunchTypeId(punchType);
        //   实例化一个考勤的成员，用来判断哪个进行考勤
        Member member = new Member();
        member.setMemberId(memberId);
        punchRecord.setPunchMemberId(member);
        int successRow = punchRecordMapper.updatePunch(punchRecord);
        return successRow;
    }

    @Override
    public PunchRecord queryByMemberIdAndDate(Integer memberId) {
        LocalDate date = LocalDate.now();
        return punchRecordMapper.queryByMemberIdAndDate(memberId, date);
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

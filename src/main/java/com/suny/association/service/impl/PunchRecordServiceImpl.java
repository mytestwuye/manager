package com.suny.association.service.impl;

import com.suny.association.annotation.SystemControllerLog;
import com.suny.association.annotation.SystemServiceLog;
import com.suny.association.enums.BaseEnum;
import com.suny.association.exception.BusinessException;
import com.suny.association.mapper.MemberMapper;
import com.suny.association.mapper.PunchRecordMapper;
import com.suny.association.mapper.PunchTypeMapper;
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
import java.util.ArrayList;
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
    private MemberMapper memberMapper;
    private PunchTypeMapper punchTypeMapper;

    @Autowired
    public PunchRecordServiceImpl(PunchRecordMapper punchRecordMapper, MemberMapper memberMapper, PunchTypeMapper punchTypeMapper) {
        this.punchRecordMapper = punchRecordMapper;
        this.memberMapper = memberMapper;
        this.punchTypeMapper = punchTypeMapper;
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

    /**
     * 对今天的考勤记录进行修改，也就是所谓的考勤
     *
     * @param memberId      考勤的memberId
     * @param punchRecordId 对应的那条考勤状态为缺勤的考勤记录主键Id
     * @return 成功影响的行数
     */
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
        // 把考勤人设置进去
        punchRecord.setPunchMemberId(member);
        return punchRecordMapper.updatePunch(punchRecord);
    }

    /**
     * 通过一个成员的Id，然后根据今天的时间查看是不是能签到
     *
     * @param memberId 成员的主键标示Id
     * @return 如果今天有一条签到记录的话就返回一个签到记录实体信息，没有的话就肯定是一个NULL的签到实体记录信息了
     */
    @Override
    public PunchRecord queryByMemberIdAndDate(Integer memberId) {
        LocalDate date = LocalDate.now();
        return punchRecordMapper.queryByMemberIdAndDate(memberId, date);
    }

    /**
     * 管理员开启自动签到，然后循环找出符合规定的成员的账号信息来，循环插入一条缺勤记录，已达到开启考勤的目的
     * 首先去数据库查询这一届的成员角色低于部长的成员，这里设计一个固定的值去这里，必要时用数据库取值替换
     * 首先我们要确定需要进行考勤的届级跟考勤的角色，例如在一个协会可能待了一年以上的基本上都会是部长之类的，
     * 然后应该有一个规定就是一般来说新生才需要考勤，老生应该是更不需要的
     *
     * @return 返回插入的行数
     */
    @SystemServiceLog(description = "开启签到失败")
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int batchInsertsPunchRecord() {
        int successRow;
        List<PunchRecord> punchList = new ArrayList<>();
        // 首先查询缺勤对应的考勤类型，如果没有查询到则默认就是0
        PunchType punchType = new PunchType();
        //  定义一个需要签到的角色，假如是2的话，那么低于2的角色成员都需要被签到，包括角色为2的成员
        int roleId = 2;
        if (punchTypeMapper.queryByName("缺勤") == null) {
            punchType.setPunchTypeId(0);
        } else {
            punchType = punchTypeMapper.queryByName("缺勤");
        }
        // 查询需要签到的成员信息
        List<Member> memberList = memberMapper.queryLimitMemberRole(roleId, getPunchMemberGrade());
        for (Member member : memberList) {
            PunchRecord punchRecord = new PunchRecord();
            punchRecord.setPunchIsCome(false);
            punchRecord.setPunchMemberId(member);
            punchRecord.setPunchTypeId(punchType);
            punchRecord.setPunchTodayDate(LocalDate.now());
            punchList.add(punchRecord);
        }
        try {
            successRow = punchRecordMapper.batchInsertsPunchRecord(punchList);
        } catch (Exception e) {
            throw new BusinessException(BaseEnum.ADD_FAIL_ALL);
        }
        return successRow;
    }

    /**
     * 通过今天的日期去查询今天已经考勤的记录，用来判断是否已经开启过签到了
     *
     * @return 今天考勤的记录
     */
    @Override
    public List<PunchRecord> queryByPunchDate() {
        LocalDate localDate = LocalDate.now();
        return punchRecordMapper.queryByPunchDate(localDate);
    }

    /**
     * 获取考勤的成员的届级，只考勤新生.
     * 学校社团一般是九月招新，所以九月份以后的就可以是新生了，对其进行考勤
     * 例如社团是2017年9月25日招收了一批新成员，然后新成员的信息里面届级就是2017届
     * 然后判断开启签到的年月份，如果是9月份以后就说明是考勤今年的新生，就返回今年的年份
     * 如果开启签到的月份是小于9月份的话，那说明年份至少是2018年，就说明考勤的是2017年9月的新生
     *
     * @return 考勤的届级
     */
    private int getPunchMemberGrade() {
        // 获取今天的日期
        LocalDate localDate = LocalDate.now();
        // 获取现在是几月
        int month = localDate.getMonth().getValue();
        if (month < 9) {
            return localDate.getYear() - 1;
        }
        return localDate.getYear();
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

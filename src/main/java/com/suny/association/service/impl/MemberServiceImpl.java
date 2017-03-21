package com.suny.association.service.impl;

import com.suny.association.enums.BaseStatusCode;
import com.suny.association.exception.BusinessException;
import com.suny.association.mapper.MemberMapper;
import com.suny.association.pojo.po.Member;
import com.suny.association.service.AbstractBaseServiceImpl;
import com.suny.association.service.interfaces.IMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Comments:  成员逻辑层类
 * Author:   孙建荣
 * Create Date: 2017/03/07 22:35
 */
@Service
public class MemberServiceImpl extends AbstractBaseServiceImpl<Member> implements IMemberService {
    
    private MemberMapper memberMapper;
    
    @Autowired
    public MemberServiceImpl(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }
    
    public MemberServiceImpl() {
    }
    
    
    /**
     * 添加一条数据
     * @param member  数据实体类
     */
    @Override
    public void insert(Member member) {
        memberMapper.insert(member);
    }
    
    /**
     * 添加一条数据并且返回主键id
     * @param member  数据实体类
     * @return   插入数据的id
     */
    @Override
    public int insertAndGetId(Member member) {
        return memberMapper.insertAndGetId(member);
    }
    
    
    /**
     * 更新一条成员信息
     * @param member  要更新的成员信息
     */
    @Override
    public void update(Member member) {
        if(member.getMemberId() != null || memberMapper.select(member.getMemberId()) != null){
            memberMapper.update(member);
        }
        else{
            throw new BusinessException(BaseStatusCode.ERROR_ADD_USER);
        }
        
    }
    
    /**
     * 通过id删除一个对象
     * @param id  要删除的对象的主键
     */
    @Override
    public void deleteById(int id) {
        memberMapper.delete(id);
    }
    
    /**
     * 查找账号被冻结的管理人员账号
     * @return   冻结的管理员信息
     */
    @Override
    public List<Member> selectFreezeManager() {
        return memberMapper.selectFreezeManager();
    }
    
    /**
     * 查找账号正常的管理人员账号
     * @return  正常的管理员信息
     */
    @Override
    public List<Member> selectNormalManager() {
        return memberMapper.selectNormalManager();
    }
    
    
    
    /**
     * 查询被冻结的普通成员账号
     * @return   冻结的成员信息
     */
    @Override
    public List<Member> selectFreezeMember() {
        return memberMapper.selectFreezeMember();
    }
    
    @Override
    public List<Member> selectAllByConditions(int limit, int offset, String departmentname, int status) {
        return memberMapper.selectAllByConditions(limit,offset,departmentname,status);
    }
    
    
    /**
     * 查询成员状态正常的
     * @return  状态正常的普通成员
     */
    @Override
    public List<Member> selectNormalMember(){
        return memberMapper.selectNormalMember();
    }
    
    
    /**
     * 通过条件查询一条记录
     * @param id  主键id
     * @return  对应的信息
     */
    @Override
    public Member selectById(int id) {
        return memberMapper.select(id);
    }
    
    /**
     * 查询全部的成员信息
     * @return   member表里面所有的记录
     */
    @Override
    public List<Member> selectForAll() {
        return memberMapper.selectAll();
    }
    
    
    
    
    
}

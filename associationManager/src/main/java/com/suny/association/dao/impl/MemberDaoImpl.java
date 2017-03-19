package com.suny.association.dao.impl;

import com.suny.association.dao.AbstractBaseDaoImpl;
import com.suny.association.dao.interfaces.IMemberDao;
import com.suny.association.mapper.MemberMapper;
import com.suny.association.pojo.po.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Comments:
 * Author:   孙建荣
 * Create Date: 2017/03/07 21:26
 */
@Repository
public  class MemberDaoImpl extends AbstractBaseDaoImpl<Member> implements IMemberDao {
    
    private MemberMapper memberMapper;
    
    
    public MemberDaoImpl(){
    }
    
    @Autowired
    public MemberDaoImpl(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }
    
    
    /**
     * 查找已经被冻结的管理员账号
     * @return  被冻结的管理员
     */
    @Override
    public List<Member> selectFreezeManager() {
        return memberMapper.selectFreezeManager();
    }
    
    /**
     * 查找正常的管理员账号
     * @return  正常的管理员
     */
    @Override
    public List<Member> selectNormalManager() {
        return memberMapper.selectNormalManager();
    }
    
    
    /**
     * 查询被冻结的普通账号
     * @return  冻结的普通账号信息
     */
    @Override
    public List<Member> selectFreezeMember() {
        return memberMapper.selectFreezeMember();
    }
    
   
    
    /**
     * 查询所有正常的成员账号
     * @return     正常的成员账号
     */
    @Override
    public List<Member> selectNormalMember(){
        return memberMapper.selectNormalMember();
    }
    
    /**
     * 创建一个新的成员信息
     * @param member   要新增的成员实体类信息
     */
    @Override
    public void create(Member member) {
        if(member != null){
            memberMapper.create(member);
        }
    }
    
    /**
     *   默认的通过主键id查询记录
     * @param id  要查询的主键id
     * @return  对应id的记录
     */
    @Override
    public Member select(int id) {
        return memberMapper.select(id);
    }
    
    /**
     * 更新一个实体的信息
     * @param member   要新增的成员实体类信息
     */
    @Override
    public void update(Member member) {
        if(member != null){
            memberMapper.update(member);
        }
    }
    
    /**
     * 删除一个成员的信息
     * @param id  要删除的对象的主键
     */
    @Override
    public void delete(int id) {
        memberMapper.delete(id);
    }
    
    /**
     * 查询数据库里面所有的成员信息
     * @return   所有的成员信息
     */
    @Override
    public List<Member> selectAll() {
        return memberMapper.selectAll();
    }
    
    
  
    
   
    
}

package com.suny.association.service.impl;

import com.suny.association.dao.IBaseDao;
import com.suny.association.dao.interfaces.IMemberDao;
import com.suny.association.enums.ErrorCode;
import com.suny.association.exception.BusinessException;
import com.suny.association.pojo.po.Member;
import com.suny.association.service.AbstractBaseServiceImpl;
import com.suny.association.service.interfaces.IMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Comments:
 * Author:   孙建荣
 * Create Date: 2017/03/07 22:35
 */
@Service
public class MemberServiceImpl extends AbstractBaseServiceImpl<Member> implements IMemberService {
    @Autowired
    private IMemberDao memberDao;
    
    @Override
    public void update(Member member) {
        if(member.getMemberId() != null || memberDao.select(member.getMemberId()) != null){
            memberDao.update(member);
        }
        throw new BusinessException(ErrorCode.ERROR_ADD_USER);
    }
    
    /**
     * 通过id删除一个对象
     * @param id  要删除的对象的主键
     */
    @Override
    public void deleteById(int id) {
        memberDao.delete(id);
    }
    
    /**
     * 查找账号被冻结的管理人员账号
     * @return
     */
    @Override
    public List<Member> selectFreezeManager() {
        return memberDao.selectFreezeManager();
    }
    
    /**
     * 查找账号正常的管理人员账号
     * @return
     */
    @Override
    public List<Member> selectNormalManager() {
        return memberDao.selectNormalManager();
    }
    
    
    
    /**
     * 查询被冻结的普通成员账号
     * @return
     */
    @Override
    public List<Member> selectFreezeMember() {
        return memberDao.selectFreezeMember();
    }
    
   
    
    /**
     * 查询成员状态正常的
     * @return  状态正常的普通成员
     */
    @Override
    public List<Member> selectNormalMember(){
        return memberDao.selectNormalMember();
    }
    
    
    /**
     * 通过条件查询一条记录
     * @param id  主键id
     * @return  对应的信息
     */
    @Override
    public Member queryById(int id) {
        return memberDao.select(id);
    }
    
    /**
     * 查询全部的成员信息
     * @return   member表里面所有的记录
     */
    @Override
    public List<Member> queryForAll() {
        return memberDao.selectAll();
    }
    
    public MemberServiceImpl() {
    }
    
    public MemberServiceImpl(IBaseDao<Member> iBaseDao) {
        super(iBaseDao);
    }
    
    public IMemberDao getMemberDao() {
        return memberDao;
    }
    
    public void setMemberDao(IMemberDao memberDao) {
        this.memberDao = memberDao;
    }
}

package com.suny.association.service.impl;

import com.suny.association.annotation.SystemServiceLog;
import com.suny.association.mapper.AccountMapper;
import com.suny.association.mapper.MemberMapper;
import com.suny.association.pojo.po.Account;
import com.suny.association.pojo.po.Member;
import com.suny.association.service.AbstractBaseServiceImpl;
import com.suny.association.service.interfaces.IMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Comments:  成员逻辑层类
 * Author:   孙建荣
 * Create Date: 2017/03/07 22:35
 */
@Service
public class MemberServiceImpl extends AbstractBaseServiceImpl<Member> implements IMemberService {
    private final MemberMapper memberMapper;
    private final AccountMapper accountMapper;

    @Autowired
    public MemberServiceImpl(MemberMapper memberMapper, AccountMapper accountMapper) {
        this.memberMapper = memberMapper;
        this.accountMapper = accountMapper;
    }

    /**
     * 插入一条新的成员信息
     *
     * @param member 成员信息
     */
    @SystemServiceLog(description = "插入一条成员信息失败")
    @Transactional(rollbackFor = {Exception.class})
    @Override
    public void insert(Member member) {
        memberMapper.insertAndGetId(member);
        Integer memberId = member.getMemberId();
        if (memberId != null) {
            createAccount(memberId);
        }
    }

    /**
     * 在插入一条成员信息后自动创建一个简单的账号
     *
     * @param memberId 成员id
     */
    @SuppressWarnings("WeakerAccess")
    @SystemServiceLog(description = "自动创建一条账号信息失败")
    @Transactional(rollbackFor = {Exception.class})
    public void createAccount(Integer memberId) {
        Account autoAccount = new Account();
        Member member = new Member();
        member.setMemberId(memberId);
        String memberIdString = String.valueOf(memberId);
        autoAccount.setAccountName(memberIdString);      //设置账号名字
        autoAccount.setAccountMember(member);            //设置对应的管理员账号
        accountMapper.insert(autoAccount);
        System.out.println(autoAccount.getAccountMember().getMemberId());

    }

    /*  通过成员id查询是否存在引用    */
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    @Override
    public Member queryQuote(int memberId) {
        return memberMapper.queryQuote(memberId);
    }

    /*  查询成员表里面的总记录数    */
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    @Override
    public int queryCount() {
        return memberMapper.queryCount();
    }

    /*   插入一条成员信息并返回插入的行数   */
    @SystemServiceLog(description = "插入成员信息失败")
    @Transactional(rollbackFor = {Exception.class})
    public int insertReturnCount(Member member) {
        return memberMapper.insertAndGetId(member);
    }

    /*  通过int类型的id删除一条成员信息    */
    @SystemServiceLog(description = "删除成员信息记录失败")
    @Transactional(rollbackFor = {Exception.class})
    @Override
    public void deleteById(int id) {
        memberMapper.deleteById(id);
    }


    /*  通过Long类型的id删除一条成员信息    */
    @SystemServiceLog(description = "删除成员信息失败")
    @Transactional(rollbackFor = {Exception.class})
    @Override
    public void deleteByLongId(Long id) {
        memberMapper.deleteByLongId(id);
    }

    /*  更新一条成员信息    */
    @SystemServiceLog(description = "更新成员信息失败")
    @Transactional(rollbackFor = {Exception.class})
    @Override
    public void update(Member member) {
        memberMapper.update(member);
    }

    /*   查询冻结的管理员信息   */
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    @Override
    public List<Member> queryFreezeManager() {
        return memberMapper.queryFreezeManager();
    }

    /*   查询正常的管理员信息   */
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    @Override
    public List<Member> queryNormalManager() {
        return memberMapper.queryNormalManager();
    }

    /*  查询冻结的成员信息    */
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    @Override
    public List<Member> queryFreezeMember() {
        return memberMapper.queryFreezeMember();
    }

    /*   通过成员角色id查询有哪些成员引用着这个角色   */
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    @Override
    public List<Member> quoteByMemberRoleId(Integer memberRoleId) {
        return memberMapper.quoteByMemberRoleId(memberRoleId);
    }

    /*   查询正常的成员信息    */
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    @Override
    public List<Member> queryNormalMember() {
        return memberMapper.queryNormalMember();
    }

    /*  通过id查询一条成员信息    */
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    @Override
    public Member queryById(int id) {
        return memberMapper.queryById(id);
    }

    /*  通过成员名字查询一条成员信息    */
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    @Override
    public Member queryByName(String name) {
        return memberMapper.queryByName(name);
    }

    /*  通过Long型的id查询一条账号信息    */
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    @Override
    public Member queryByLongId(Long id) {
        return memberMapper.queryByLongId(id);
    }

    /*   查询所有的成员记录   */
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    @Override
    public List<Member> queryAll() {
        return memberMapper.queryAll();
    }

    /*   通过查询条件查询成员记录   */
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    @Override
    public List<Member> list(Map<Object, Object> criteriaMap) {
        return memberMapper.list(criteriaMap);
    }


}

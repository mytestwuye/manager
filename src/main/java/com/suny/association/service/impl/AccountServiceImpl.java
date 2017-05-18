package com.suny.association.service.impl;

import com.suny.association.annotation.SystemControllerLog;
import com.suny.association.annotation.SystemServiceLog;
import com.suny.association.enums.BaseEnum;
import com.suny.association.exception.BusinessException;
import com.suny.association.mapper.AccountMapper;
import com.suny.association.pojo.po.Account;
import com.suny.association.service.AbstractBaseServiceImpl;
import com.suny.association.service.interfaces.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Comments:  账号表业务逻辑控制
 * Author:   孙建荣
 * Create Date: 2017/03/07 22:18
 */
@Service
public class AccountServiceImpl extends AbstractBaseServiceImpl<Account> implements IAccountService {
    private final AccountMapper accountMapper;


    @Autowired
    public AccountServiceImpl(AccountMapper accountMapper) {
        this.accountMapper = accountMapper;
    }


    /**
     * 新增一条账号信息
     *
     * @param account 账号信息
     */
    @SystemServiceLog(description = "插入账号信息失败")
    @Transactional(rollbackFor = {Exception.class})
    @Override
    public void insert(Account account) {
        if (account == null) {
            throw new BusinessException(BaseEnum.ADD_FAILURE);
        }
        try {
            accountMapper.insert(account);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 通过账号删除一条记录
     *
     * @param id 账号id
     */
    @SystemServiceLog(description = "删除账号失败")
    @Transactional(rollbackFor = {Exception.class})
    @Override
    public void deleteById(int id) {
        accountMapper.deleteById(id);
    }

    /**
     * 更新一条账号记录
     *
     * @param account 要更新的账号信息
     */
    @SystemServiceLog(description = "更新账号信息失败")
    @Transactional(rollbackFor = {Exception.class})
    @Override
    public void update(Account account) {
        accountMapper.update(account);
    }

    /**
     * 查询一条账号记录
     *
     * @param id 查询记录使用的账号id、
     * @return 一条账号信息
     */
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    @Override
    public Account queryById(int id) {
        return accountMapper.queryById(id);
    }

    /**
     * 通过手机号码查询一条账号信息
     *
     * @param phoneNumber 电话号码
     * @return 一条账号信息
     */
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    @Override
    public Account queryByPhone(Long phoneNumber) {
        return accountMapper.queryByPhone(phoneNumber);
    }


    /**
     * 使用邮箱查询一条张阿红信息
     *
     * @param email 邮箱号码
     * @return 一条账号信息
     */
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    @Override
    public Account queryByMail(String email) {
        return accountMapper.queryByMail(email);
    }

    /**
     * 通过Long类型的id查询一条记录
     *
     * @param id 账号id
     * @return 一条账号信息
     */
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    @Override
    public Account queryByLongId(Long id) {
        return accountMapper.queryByLongId(id);
    }

    /**
     * 查询一条账号信息是否被引用
     *
     * @param accountId 账号id
     * @return 存在引用则有账号信息，不存在引用则没有账号信息
     */
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    @Override
    public Account queryQuoteByAccountId(Long accountId) {
        return accountMapper.queryQuoteByAccountId(accountId);
    }

    /**
     * 通过成员id查询成员是否引用着一条账号
     *
     * @param memberId 成员的id
     * @return 存在引用则返回非空的一条账号信息
     */
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    @Override
    public Account queryQuoteByMemberId(Long memberId) {
        return accountMapper.queryQuoteByMemberId(memberId);
    }

    /**
     * 通过账号名查询一条账号信息
     */
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    @Override
    public Account queryByName(String name) {
        return accountMapper.queryByName(name);
    }

    /**
     * 通过成员id查询一条账号信息
     */
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    @Override
    public Account queryByMemberId(int memberId) {
        return accountMapper.queryByMemberId(memberId);
    }

    /**
     * 通过Long类型的账号id删除一条账号信息
     */
    @SystemServiceLog(description = "删除账号失败")
    @Transactional(rollbackFor = {Exception.class})
    @Override
    public void deleteByLongId(Long id) {
        accountMapper.deleteByLongId(id);
    }

    @SystemControllerLog(description = "修改用户密码失败")
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int changePassword(Long accountId, String newPassword) {
        return accountMapper.changePassword(accountId, newPassword);
    }


    /**
     * 查询数据库账号表的总记录数
     */
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    @Override
    public int queryCount() {
        return accountMapper.queryCount();
    }

    /**
     * 带查询条件查询查询账号信息
     *
     * @param criteriaMap 自己封装的查询条件
     */
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    @Override
    public List<Account> list(Map<Object, Object> criteriaMap) {
        return accountMapper.list(criteriaMap);
    }

    /**
     * 查询所有的账号信息
     */
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    @Override
    public List<Account> queryAll() {
        return accountMapper.queryAll();
    }
}

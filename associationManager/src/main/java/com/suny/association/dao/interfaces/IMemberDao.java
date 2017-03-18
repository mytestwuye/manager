package com.suny.association.dao.interfaces;

import com.suny.association.dao.IBaseDao;
import com.suny.association.pojo.po.Member;

import java.util.List;

public interface IMemberDao extends IBaseDao<Member> {
    
    /**
     * 查找账号被冻结的管理人员账号
     * @return
     */
    List<Member> selectFreezeManager();
    
    /**
     * 查找账号正常的管理人员账号
     * @return
     */
    List<Member> selectNormalManager();
    
    
    /**
     * 查询账号正常的成员
     * @return  正常账号的信息
     */
     List<Member> selectNormalMember();
    
    /**
     * 查询被冻结的账号
     * @return
     */
     List<Member> selectFreezeMember();

}
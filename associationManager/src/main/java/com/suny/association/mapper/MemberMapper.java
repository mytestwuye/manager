package com.suny.association.mapper;

import com.suny.association.mapper.interfaces.IMapper;
import com.suny.association.pojo.po.Member;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * Comments:   成员表mapper映射
 * Author:   孙建荣
 * Create Date: 2017/03/05 23:05
 */
@Component
public interface MemberMapper extends IMapper<Member> {
    
    
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
     * 查询被冻结的账号
     * @return
     */
    List<Member> selectFreezeMember();
    
    /**
     * 查询正常的账号
     * @return
     */
    List<Member> selectNormalMember();
    

}
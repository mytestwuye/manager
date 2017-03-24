package com.suny.association.service.interfaces;

import com.suny.association.pojo.po.Member;
import com.suny.association.service.IBaseService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Comments:
 * Author:   孙建荣
 * Create Date: 2017/03/07 22:12
 */
public interface IMemberService extends IBaseService<Member> {
    
    
    int insertReturnCount(Member member);
    
    
    List<Member> queryFreezeManager();
    
    
    List<Member> queryNormalManager();
    
    
    List<Member> queryNormalMember();
    
    
    List<Member> queryFreezeMember();
    
    
    List<Member> queryAll(@Param("limit") int limit,
                          @Param("offset") int offset,
                          @Param("departmentname") String departmentname,
                          @Param("status") int status);
}

package com.suny.association.mapper;

import com.suny.association.mapper.interfaces.IMapper;
import com.suny.association.pojo.po.Member;

import java.util.List;
import java.util.Map;


/**
 * Comments:   成员表mapper映射
 * Author:   孙建荣
 * Create Date: 2017/03/05 23:05
 */

public interface MemberMapper extends IMapper<Member> {
    int queryCount();
    List<Member> queryFreezeManager();
   
    List<Member> queryNormalManager();
    
    List<Member> queryFreezeMember();
    
    List<Member> queryNormalMember();
    
    List<Member> queryAllByCriteria(Map<Object,Object> criteriaMap);
    

}
package com.suny.association.service.interfaces;

import com.suny.association.pojo.po.Member;
import com.suny.association.service.IBaseService;

import java.util.List;
import java.util.Map;

/**
 * Comments:
 * Author:   孙建荣
 * Create Date: 2017/03/07 22:12
 */
public interface IMemberService extends IBaseService<Member> {

    int queryCount();
    int insertReturnCount(Member member);
    List<Member> queryFreezeManager();
    List<Member> queryNormalManager();
    List<Member> queryNormalMember();
    List<Member> queryFreezeMember();
    List<Member> queryAllByCriteria(Map<Object,Object> criteriaMap);

}

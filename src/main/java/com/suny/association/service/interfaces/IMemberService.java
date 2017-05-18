package com.suny.association.service.interfaces;

import com.suny.association.pojo.po.Member;
import com.suny.association.service.IBaseService;

import java.io.File;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Comments:   成员表业务逻辑接口
 * Author:   孙建荣
 * Create Date: 2017/03/07 22:12
 */
public interface IMemberService extends IBaseService<Member> {
    void deleteByLongId(Long id);

    Member queryByLongId(Long id);

    Member queryQuote(int memberId);

    int insertReturnCount(Member member);

    List<Member> queryFreezeManager();

    List<Member> queryNormalManager();

    List<Member> queryNormalMember();

    List<Member> queryFreezeMember();

    List<Member> quoteByMemberRoleId(Integer memberRoleId);

    AtomicReference<List<Member>> batchInsertFromExcel(File file, String fileExtension);


}

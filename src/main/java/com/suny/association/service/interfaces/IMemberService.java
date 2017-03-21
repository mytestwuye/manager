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
public interface IMemberService extends IBaseService<Member>{
    
  
    
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
     * 查询被冻结的成员账号
     * @return
     */
     List<Member> selectFreezeMember();
    
    /**
     * 通过参数进行查询
     * @param limit    限制返回的数据列
     * @param offset    从第几个开始
     * @param departmentname   部门名字
     * @param status   成员状态
     * @return    参数后的数据
     */
    List<Member> selectAllByConditions(@Param("limit") int limit,
                                       @Param("offset") int offset,
                                       @Param("departmentname") String departmentname,
                                       @Param("status") int status);
}

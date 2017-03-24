package com.suny.association.mapper;

import com.suny.association.mapper.interfaces.IMapper;
import com.suny.association.pojo.po.Member;

import java.util.List;


/**
 * Comments:   成员表mapper映射
 * Author:   孙建荣
 * Create Date: 2017/03/05 23:05
 */

public interface MemberMapper extends IMapper<Member> {
    
    
    
    /**
     * 查找账号被冻结的管理人员账号
     * @return  冻结的管理人员信息
     */
    List<Member> queryFreezeManager();
    
    /**
     * 查找账号正常的管理人员账号
     * @return 正常的管理人员账号
     */
    List<Member> queryNormalManager();
    
    
    /**
     * 查询被冻结的普通成员账号
     * @return   冻结的普通成员账号
     */
    List<Member> queryFreezeMember();
    
    /**
     * 查询正常的普通成员账号
     * @return  正常的普通成员账号
     */
    List<Member> queryNormalMember();
    
    /**
     * 通过参数进行查询
     * @param limit    限制返回的数据列
     * @param offset    从第几个开始
     * @param departmentname   部门名字
     * @param status   成员状态
     * @return    参数后的数据
     */
    List<Member> queryAllByConditions(int limit, int offset, String departmentname, int status);
    

}
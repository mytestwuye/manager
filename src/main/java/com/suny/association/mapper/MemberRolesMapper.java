package com.suny.association.mapper;

import com.suny.association.mapper.interfaces.IMapper;
import com.suny.association.pojo.po.MemberRoles;

import java.util.List;

/**
 * Comments:  成员角色mapper映射
 * Author:   孙建荣
 * Create Date: 2017/03/05 23:05
 */

public interface MemberRolesMapper extends IMapper<MemberRoles>{

    List<MemberRoles> queryQuote(Integer memberRoleId);
}
package com.suny.association.dao.mapper;

import com.suny.association.pojo.po.MemberRoles;
import com.suny.association.pojo.po.MemberRolesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MemberRolesMapper {
    int countByExample(MemberRolesExample example);

    int deleteByExample(MemberRolesExample example);

    int deleteByPrimaryKey(Integer memberRoleId);

    int insert(MemberRoles record);

    int insertSelective(MemberRoles record);

    List<MemberRoles> selectByExample(MemberRolesExample example);

    MemberRoles selectByPrimaryKey(Integer memberRoleId);

    int updateByExampleSelective(@Param("record") MemberRoles record, @Param("example") MemberRolesExample example);

    int updateByExample(@Param("record") MemberRoles record, @Param("example") MemberRolesExample example);

    int updateByPrimaryKeySelective(MemberRoles record);

    int updateByPrimaryKey(MemberRoles record);
}
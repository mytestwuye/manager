package com.suny.association.pojo.vo;

import com.suny.association.pojo.po.Department;
import com.suny.association.pojo.po.Member;
import com.suny.association.pojo.po.MemberRoles;

/**
 * Comments:
 * Author:   孙建荣
 * Create Date: 2017/03/26 10:52
 */
public class MemberVo extends Member {
    
    private Integer memberManagerId;
    
    private String memberManagerName;
    
    public MemberVo(Integer memberManagerId, String memberManagerName) {
        this.memberManagerId = memberManagerId;
        this.memberManagerName = memberManagerName;
    }
    
    public MemberVo(Integer memberId, String memberName, String memberClassName, Boolean memberSex, Integer memberGradeNumber, Member memberManager, Department memberDepartment, Boolean memberStatus, MemberRoles memberRoles, Integer memberManagerId, String memberManagerName) {
        super(memberId, memberName, memberClassName, memberSex, memberGradeNumber, memberManager, memberDepartment, memberStatus, memberRoles);
        this.memberManagerId = memberManagerId;
        this.memberManagerName = memberManagerName;
    }
    
    
    public Integer getMemberManagerId() {
        return memberManagerId;
    }
    
    public void setMemberManagerId(Integer memberManagerId) {
        this.memberManagerId = memberManagerId;
    }
    
    public String getMemberManagerName() {
        return memberManagerName;
    }
    
    public void setMemberManagerName(String memberManagerName) {
        this.memberManagerName = memberManagerName;
    }
}

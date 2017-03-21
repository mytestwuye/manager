package com.suny.association.pojo.po;

public class MemberRoles {
    private Integer memberRoleId;

    private String memberRoleName;

    public MemberRoles(Integer memberRoleId, String memberRoleName) {
        this.memberRoleId = memberRoleId;
        this.memberRoleName = memberRoleName;
    }

    public MemberRoles() {
        super();
    }

    public Integer getMemberRoleId() {
        return memberRoleId;
    }

    public void setMemberRoleId(Integer memberRoleId) {
        this.memberRoleId = memberRoleId;
    }

    public String getMemberRoleName() {
        return memberRoleName;
    }

    public void setMemberRoleName(String memberRoleName) {
        this.memberRoleName = memberRoleName == null ? null : memberRoleName.trim();
    }
}
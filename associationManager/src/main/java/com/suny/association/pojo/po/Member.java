package com.suny.association.pojo.po;

public class Member {
    private Integer memberId;

    private String memberName;

    private String memberClassName;

    private Boolean memberSex;

    private Integer memverGradeNumber;

    private Integer memberManagerId;

    private Integer memberDepartmentId;

    private Boolean memberStatus;

    private Integer memberRoleId;

    public Member(Integer memberId, String memberName, String memberClassName, Boolean memberSex, Integer memverGradeNumber, Integer memberManagerId, Integer memberDepartmentId, Boolean memberStatus, Integer memberRoleId) {
        this.memberId = memberId;
        this.memberName = memberName;
        this.memberClassName = memberClassName;
        this.memberSex = memberSex;
        this.memverGradeNumber = memverGradeNumber;
        this.memberManagerId = memberManagerId;
        this.memberDepartmentId = memberDepartmentId;
        this.memberStatus = memberStatus;
        this.memberRoleId = memberRoleId;
    }

    public Member() {
        super();
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName == null ? null : memberName.trim();
    }

    public String getMemberClassName() {
        return memberClassName;
    }

    public void setMemberClassName(String memberClassName) {
        this.memberClassName = memberClassName == null ? null : memberClassName.trim();
    }

    public Boolean getMemberSex() {
        return memberSex;
    }

    public void setMemberSex(Boolean memberSex) {
        this.memberSex = memberSex;
    }

    public Integer getMemverGradeNumber() {
        return memverGradeNumber;
    }

    public void setMemverGradeNumber(Integer memverGradeNumber) {
        this.memverGradeNumber = memverGradeNumber;
    }

    public Integer getMemberManagerId() {
        return memberManagerId;
    }

    public void setMemberManagerId(Integer memberManagerId) {
        this.memberManagerId = memberManagerId;
    }

    public Integer getMemberDepartmentId() {
        return memberDepartmentId;
    }

    public void setMemberDepartmentId(Integer memberDepartmentId) {
        this.memberDepartmentId = memberDepartmentId;
    }

    public Boolean getMemberStatus() {
        return memberStatus;
    }

    public void setMemberStatus(Boolean memberStatus) {
        this.memberStatus = memberStatus;
    }

    public Integer getMemberRoleId() {
        return memberRoleId;
    }

    public void setMemberRoleId(Integer memberRoleId) {
        this.memberRoleId = memberRoleId;
    }
}
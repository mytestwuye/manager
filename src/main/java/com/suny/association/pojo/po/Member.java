package com.suny.association.pojo.po;

public class Member {
    private Integer memberId;

    private String memberName;

    private String memberClassName;

    private Boolean memberSex;

    private Integer memberGradeNumber;

    private Member memberManager;

    private Department memberDepartment;

    private Boolean memberStatus;

    private MemberRoles memberRoles;
    
    public Member() {
    }
    
    public Member(Integer memberId, String memberName, String memberClassName, Boolean memberSex, Integer memberGradeNumber, Member memberManager, Department memberDepartment, Boolean memberStatus, MemberRoles memberRoles) {
        this.memberId = memberId;
        this.memberName = memberName;
        this.memberClassName = memberClassName;
        this.memberSex = memberSex;
        this.memberGradeNumber = memberGradeNumber;
        this.memberManager = memberManager;
        this.memberDepartment = memberDepartment;
        this.memberStatus = memberStatus;
        this.memberRoles = memberRoles;
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
        this.memberName = memberName;
    }
    
    public String getMemberClassName() {
        return memberClassName;
    }
    
    public void setMemberClassName(String memberClassName) {
        this.memberClassName = memberClassName;
    }
    
    public Boolean getMemberSex() {
        return memberSex;
    }
    
    public void setMemberSex(Boolean memberSex) {
        this.memberSex = memberSex;
    }
    
    public Integer getMemberGradeNumber() {
        return memberGradeNumber;
    }
    
    public void setMemberGradeNumber(Integer memberGradeNumber) {
        this.memberGradeNumber = memberGradeNumber;
    }
    
    public Member getMemberManager() {
        return memberManager;
    }
    
    public void setMemberManager(Member memberManager) {
        this.memberManager = memberManager;
    }
    
    public Department getMemberDepartment() {
        return memberDepartment;
    }
    
    public void setMemberDepartment(Department memberDepartment) {
        this.memberDepartment = memberDepartment;
    }
    
    public Boolean getMemberStatus() {
        return memberStatus;
    }
    
    public void setMemberStatus(Boolean memberStatus) {
        this.memberStatus = memberStatus;
    }
    
    public MemberRoles getMemberRoles() {
        return memberRoles;
    }
    
    public void setMemberRoles(MemberRoles memberRoles) {
        this.memberRoles = memberRoles;
    }
}
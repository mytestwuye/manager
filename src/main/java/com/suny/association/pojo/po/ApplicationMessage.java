package com.suny.association.pojo.po;

public class ApplicationMessage {
    private Integer applicationId;

    private Long punchRecordId;

    private Integer punchTypeId;

    private String applicationReson;

    private Boolean applicationResult;

    private Integer changePunchType;

    public ApplicationMessage(Integer applicationId, Long punchRecordId, Integer punchTypeId, String applicationReson, Boolean applicationResult, Integer changePunchType) {
        this.applicationId = applicationId;
        this.punchRecordId = punchRecordId;
        this.punchTypeId = punchTypeId;
        this.applicationReson = applicationReson;
        this.applicationResult = applicationResult;
        this.changePunchType = changePunchType;
    }

    public ApplicationMessage() {
        super();
    }

    public Integer getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Integer applicationId) {
        this.applicationId = applicationId;
    }

    public Long getPunchRecordId() {
        return punchRecordId;
    }

    public void setPunchRecordId(Long punchRecordId) {
        this.punchRecordId = punchRecordId;
    }

    public Integer getPunchTypeId() {
        return punchTypeId;
    }

    public void setPunchTypeId(Integer punchTypeId) {
        this.punchTypeId = punchTypeId;
    }

    public String getApplicationReson() {
        return applicationReson;
    }

    public void setApplicationReson(String applicationReson) {
        this.applicationReson = applicationReson == null ? null : applicationReson.trim();
    }

    public Boolean getApplicationResult() {
        return applicationResult;
    }

    public void setApplicationResult(Boolean applicationResult) {
        this.applicationResult = applicationResult;
    }

    public Integer getChangePunchType() {
        return changePunchType;
    }

    public void setChangePunchType(Integer changePunchType) {
        this.changePunchType = changePunchType;
    }
}
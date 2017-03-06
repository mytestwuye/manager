package com.suny.association.pojo.po;

public class CheckbackResult {
    private Integer checkbackId;

    private Integer applicationMessageId;

    private Boolean checkbackResult;

    private Integer checkbackManagerId;

    private String checkbackReson;

    public CheckbackResult(Integer checkbackId, Integer applicationMessageId, Boolean checkbackResult, Integer checkbackManagerId, String checkbackReson) {
        this.checkbackId = checkbackId;
        this.applicationMessageId = applicationMessageId;
        this.checkbackResult = checkbackResult;
        this.checkbackManagerId = checkbackManagerId;
        this.checkbackReson = checkbackReson;
    }

    public CheckbackResult() {
        super();
    }

    public Integer getCheckbackId() {
        return checkbackId;
    }

    public void setCheckbackId(Integer checkbackId) {
        this.checkbackId = checkbackId;
    }

    public Integer getApplicationMessageId() {
        return applicationMessageId;
    }

    public void setApplicationMessageId(Integer applicationMessageId) {
        this.applicationMessageId = applicationMessageId;
    }

    public Boolean getCheckbackResult() {
        return checkbackResult;
    }

    public void setCheckbackResult(Boolean checkbackResult) {
        this.checkbackResult = checkbackResult;
    }

    public Integer getCheckbackManagerId() {
        return checkbackManagerId;
    }

    public void setCheckbackManagerId(Integer checkbackManagerId) {
        this.checkbackManagerId = checkbackManagerId;
    }

    public String getCheckbackReson() {
        return checkbackReson;
    }

    public void setCheckbackReson(String checkbackReson) {
        this.checkbackReson = checkbackReson == null ? null : checkbackReson.trim();
    }
}
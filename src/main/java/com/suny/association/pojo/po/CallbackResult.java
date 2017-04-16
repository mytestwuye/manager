package com.suny.association.pojo.po;

import java.util.Date;

public class CallbackResult {
    private Integer callbackId;

    private ApplicationMessage applicationMessageId;

    private Boolean callbackResult;

    private Member callbackManagerId;

    private String callbackReason;

    private Date callbackTime;

    public CallbackResult() {
    }

    public CallbackResult(Integer callbackId, ApplicationMessage applicationMessageId, Boolean callbackResult, Member callbackManagerId, String callbackReason, Date callbackTime) {
        this.callbackId = callbackId;
        this.applicationMessageId = applicationMessageId;
        this.callbackResult = callbackResult;
        this.callbackManagerId = callbackManagerId;
        this.callbackReason = callbackReason;
        this.callbackTime = callbackTime;
    }

    public Integer getCallbackId() {
        return callbackId;
    }

    public void setCallbackId(Integer callbackId) {
        this.callbackId = callbackId;
    }

    public ApplicationMessage getApplicationMessageId() {
        return applicationMessageId;
    }

    public void setApplicationMessageId(ApplicationMessage applicationMessageId) {
        this.applicationMessageId = applicationMessageId;
    }

    public Boolean getCallbackResult() {
        return callbackResult;
    }

    public void setCallbackResult(Boolean callbackResult) {
        this.callbackResult = callbackResult;
    }

    public Member getCallbackManagerId() {
        return callbackManagerId;
    }

    public void setCallbackManagerId(Member callbackManagerId) {
        this.callbackManagerId = callbackManagerId;
    }

    public String getCallbackReason() {
        return callbackReason;
    }

    public void setCallbackReason(String callbackReason) {
        this.callbackReason = callbackReason;
    }

    public Date getCallbackTime() {
        return callbackTime;
    }

    public void setCallbackTime(Date callbackTime) {
        this.callbackTime = callbackTime;
    }
}
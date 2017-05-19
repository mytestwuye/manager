package com.suny.association.pojo.po;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 *   申请结果实体类
 */
public class CallbackResult implements Serializable {

    private static final long serialVersionUID = -8623018593261289378L;
    private Integer callbackId;

    private ApplicationMessage applicationMessageId;

    private Boolean callbackResult;

    private Member callbackManagerId;

    private String callbackReason;

    private LocalDateTime callbackTime;

    public CallbackResult() {
    }

    public CallbackResult(Integer callbackId, ApplicationMessage applicationMessageId, Boolean callbackResult, Member callbackManagerId, String callbackReason, LocalDateTime callbackTime) {
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

    public LocalDateTime getCallbackTime() {
        return callbackTime;
    }

    public void setCallbackTime(LocalDateTime callbackTime) {
        this.callbackTime = callbackTime;
    }

    @Override
    public String toString() {
        return "CallbackResult{" +
                "callbackId=" + callbackId +
                ", applicationMessageId=" + applicationMessageId +
                ", callbackResult=" + callbackResult +
                ", callbackManagerId=" + callbackManagerId +
                ", callbackReason='" + callbackReason + '\'' +
                ", callbackTime=" + callbackTime +
                '}';
    }
}
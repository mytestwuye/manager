package com.suny.association.pojo.po;

import java.util.Date;

public class Operation {
    private Long operationId;

    private String operationMessage;

    private String operationBrower;

    private String operationOsVersion;

    private String operationUserAgent;

    private String operationRequestUrl;

    private Date operationTime;

    private String operationIp;

    private String operationAddress;

    private Boolean operationStatus;

    private Account operationAccountId;

    public Operation() {
    }

    public Operation(Long operationId, String operationMessage, String operationBrower, String operationOsVersion, String operationUserAgent, String operationRequestUrl, Date operationTime, String operationIp, String operationAddress, Boolean operationStatus, Account operationAccountId) {
        this.operationId = operationId;
        this.operationMessage = operationMessage;
        this.operationBrower = operationBrower;
        this.operationOsVersion = operationOsVersion;
        this.operationUserAgent = operationUserAgent;
        this.operationRequestUrl = operationRequestUrl;
        this.operationTime = operationTime;
        this.operationIp = operationIp;
        this.operationAddress = operationAddress;
        this.operationStatus = operationStatus;
        this.operationAccountId = operationAccountId;
    }

    public Long getOperationId() {
        return operationId;
    }

    public void setOperationId(Long operationId) {
        this.operationId = operationId;
    }

    public String getOperationMessage() {
        return operationMessage;
    }

    public void setOperationMessage(String operationMessage) {
        this.operationMessage = operationMessage;
    }

    public String getOperationBrower() {
        return operationBrower;
    }

    public void setOperationBrower(String operationBrower) {
        this.operationBrower = operationBrower;
    }

    public String getOperationOsVersion() {
        return operationOsVersion;
    }

    public void setOperationOsVersion(String operationOsVersion) {
        this.operationOsVersion = operationOsVersion;
    }

    public String getOperationUserAgent() {
        return operationUserAgent;
    }

    public void setOperationUserAgent(String operationUserAgent) {
        this.operationUserAgent = operationUserAgent;
    }

    public String getOperationRequestUrl() {
        return operationRequestUrl;
    }

    public void setOperationRequestUrl(String operationRequestUrl) {
        this.operationRequestUrl = operationRequestUrl;
    }

    public Date getOperationTime() {
        return operationTime;
    }

    public void setOperationTime(Date operationTime) {
        this.operationTime = operationTime;
    }

    public String getOperationIp() {
        return operationIp;
    }

    public void setOperationIp(String operationIp) {
        this.operationIp = operationIp;
    }

    public String getOperationAddress() {
        return operationAddress;
    }

    public void setOperationAddress(String operationAddress) {
        this.operationAddress = operationAddress;
    }

    public Boolean getOperationStatus() {
        return operationStatus;
    }

    public void setOperationStatus(Boolean operationStatus) {
        this.operationStatus = operationStatus;
    }

    public Account getOperationAccountId() {
        return operationAccountId;
    }

    public void setOperationAccountId(Account operationAccountId) {
        this.operationAccountId = operationAccountId;
    }
}
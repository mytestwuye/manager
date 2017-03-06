package com.suny.association.pojo.po;

public class Operation {
    private Long operationId;

    private String operationMessage;

    private String operationBrower;

    private String operationOsVersion;

    private String operationUserAgent;

    private String operationRequestUrl;

    private Long operationAccountId;

    public Operation(Long operationId, String operationMessage, String operationBrower, String operationOsVersion, String operationUserAgent, String operationRequestUrl, Long operationAccountId) {
        this.operationId = operationId;
        this.operationMessage = operationMessage;
        this.operationBrower = operationBrower;
        this.operationOsVersion = operationOsVersion;
        this.operationUserAgent = operationUserAgent;
        this.operationRequestUrl = operationRequestUrl;
        this.operationAccountId = operationAccountId;
    }

    public Operation() {
        super();
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
        this.operationMessage = operationMessage == null ? null : operationMessage.trim();
    }

    public String getOperationBrower() {
        return operationBrower;
    }

    public void setOperationBrower(String operationBrower) {
        this.operationBrower = operationBrower == null ? null : operationBrower.trim();
    }

    public String getOperationOsVersion() {
        return operationOsVersion;
    }

    public void setOperationOsVersion(String operationOsVersion) {
        this.operationOsVersion = operationOsVersion == null ? null : operationOsVersion.trim();
    }

    public String getOperationUserAgent() {
        return operationUserAgent;
    }

    public void setOperationUserAgent(String operationUserAgent) {
        this.operationUserAgent = operationUserAgent == null ? null : operationUserAgent.trim();
    }

    public String getOperationRequestUrl() {
        return operationRequestUrl;
    }

    public void setOperationRequestUrl(String operationRequestUrl) {
        this.operationRequestUrl = operationRequestUrl == null ? null : operationRequestUrl.trim();
    }

    public Long getOperationAccountId() {
        return operationAccountId;
    }

    public void setOperationAccountId(Long operationAccountId) {
        this.operationAccountId = operationAccountId;
    }
}
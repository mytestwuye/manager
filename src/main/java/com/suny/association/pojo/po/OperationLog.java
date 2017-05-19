package com.suny.association.pojo.po;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 操作日志实体类
 *
 * @author 孙建荣
 */
public class OperationLog implements Serializable {

    private static final long serialVersionUID = -8993955818563136615L;

    private Long operationId;

    private String operationMessage;

    private String operationMemberName;

    private String operationBrower;

    private String operationOsVersion;

    private String operationUserAgent;

    private String operationRequestUrl;

    private LocalDateTime operationTime;

    private String operationIp;

    private String operationAddress;

    private Boolean operationStatus;

    private Account operationAccountId;

    public OperationLog() {
    }

    public OperationLog(Long operationId, String operationMessage, String operationMemberName, String operationBrower, String operationOsVersion, String operationUserAgent, String operationRequestUrl, LocalDateTime operationTime, String operationIp, String operationAddress, Boolean operationStatus, Account operationAccountId) {
        this.operationId = operationId;
        this.operationMessage = operationMessage;
        this.operationMemberName = operationMemberName;
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

    public String getOperationMemberName() {
        return operationMemberName;
    }

    public void setOperationMemberName(String operationMemberName) {
        this.operationMemberName = operationMemberName;
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

    public LocalDateTime getOperationTime() {
        return operationTime;
    }

    public void setOperationTime(LocalDateTime operationTime) {
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

    @Override
    public String toString() {
        return "OperationLog{" +
                "operationId=" + operationId +
                ", operationMessage='" + operationMessage + '\'' +
                ", operationMemberName='" + operationMemberName + '\'' +
                ", operationBrower='" + operationBrower + '\'' +
                ", operationOsVersion='" + operationOsVersion + '\'' +
                ", operationUserAgent='" + operationUserAgent + '\'' +
                ", operationRequestUrl='" + operationRequestUrl + '\'' +
                ", operationTime=" + operationTime +
                ", operationIp='" + operationIp + '\'' +
                ", operationAddress='" + operationAddress + '\'' +
                ", operationStatus=" + operationStatus +
                ", operationAccountId=" + operationAccountId +
                '}';
    }
}
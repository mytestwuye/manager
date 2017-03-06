package com.suny.association.pojo.po;

import java.util.Date;

public class PunchRecord {
    private Long punchRecordId;

    private Date punchDatetime;

    private Date punchTodayDate;

    private Boolean punchIsCome;

    private Integer punchTypeId;

    private Integer punchMemberId;

    public PunchRecord(Long punchRecordId, Date punchDatetime, Date punchTodayDate, Boolean punchIsCome, Integer punchTypeId, Integer punchMemberId) {
        this.punchRecordId = punchRecordId;
        this.punchDatetime = punchDatetime;
        this.punchTodayDate = punchTodayDate;
        this.punchIsCome = punchIsCome;
        this.punchTypeId = punchTypeId;
        this.punchMemberId = punchMemberId;
    }

    public PunchRecord() {
        super();
    }

    public Long getPunchRecordId() {
        return punchRecordId;
    }

    public void setPunchRecordId(Long punchRecordId) {
        this.punchRecordId = punchRecordId;
    }

    public Date getPunchDatetime() {
        return punchDatetime;
    }

    public void setPunchDatetime(Date punchDatetime) {
        this.punchDatetime = punchDatetime;
    }

    public Date getPunchTodayDate() {
        return punchTodayDate;
    }

    public void setPunchTodayDate(Date punchTodayDate) {
        this.punchTodayDate = punchTodayDate;
    }

    public Boolean getPunchIsCome() {
        return punchIsCome;
    }

    public void setPunchIsCome(Boolean punchIsCome) {
        this.punchIsCome = punchIsCome;
    }

    public Integer getPunchTypeId() {
        return punchTypeId;
    }

    public void setPunchTypeId(Integer punchTypeId) {
        this.punchTypeId = punchTypeId;
    }

    public Integer getPunchMemberId() {
        return punchMemberId;
    }

    public void setPunchMemberId(Integer punchMemberId) {
        this.punchMemberId = punchMemberId;
    }
}
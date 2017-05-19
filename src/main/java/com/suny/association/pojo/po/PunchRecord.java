package com.suny.association.pojo.po;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class PunchRecord implements Serializable {

    private static final long serialVersionUID = 4274980896614790015L;
    private Long punchRecordId;
    private LocalDateTime punchDatetime;
    private LocalDate punchTodayDate;
    private Boolean punchIsCome;
    private PunchType punchTypeId;
    private Member punchMemberId;

    public PunchRecord() {
    }

    public PunchRecord(Long punchRecordId, LocalDateTime punchDatetime, LocalDate punchTodayDate, Boolean punchIsCome, PunchType punchTypeId, Member punchMemberId) {
        this.punchRecordId = punchRecordId;
        this.punchDatetime = punchDatetime;
        this.punchTodayDate = punchTodayDate;
        this.punchIsCome = punchIsCome;
        this.punchTypeId = punchTypeId;
        this.punchMemberId = punchMemberId;
    }

    public Long getPunchRecordId() {
        return punchRecordId;
    }

    public void setPunchRecordId(Long punchRecordId) {
        this.punchRecordId = punchRecordId;
    }

    public LocalDateTime getPunchDatetime() {
        return punchDatetime;
    }

    public void setPunchDatetime(LocalDateTime punchDatetime) {
        this.punchDatetime = punchDatetime;
    }

    public LocalDate getPunchTodayDate() {
        return punchTodayDate;
    }

    public void setPunchTodayDate(LocalDate punchTodayDate) {
        this.punchTodayDate = punchTodayDate;
    }

    public Boolean getPunchIsCome() {
        return punchIsCome;
    }

    public void setPunchIsCome(Boolean punchIsCome) {
        this.punchIsCome = punchIsCome;
    }

    public PunchType getPunchTypeId() {
        return punchTypeId;
    }

    public void setPunchTypeId(PunchType punchTypeId) {
        this.punchTypeId = punchTypeId;
    }

    public Member getPunchMemberId() {
        return punchMemberId;
    }

    public void setPunchMemberId(Member punchMemberId) {
        this.punchMemberId = punchMemberId;
    }
}
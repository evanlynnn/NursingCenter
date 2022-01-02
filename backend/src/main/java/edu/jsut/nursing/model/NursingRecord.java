package edu.jsut.nursing.model;

import java.util.Date;

public class NursingRecord {
    private Integer recordId;

    private Integer userId;

    private Integer nursingId;

    private Date nursingTime;

    private String nursingContent;

    public Integer getRecordId() {
        return recordId;
    }

    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getNursingId() {
        return nursingId;
    }

    public void setNursingId(Integer nursingId) {
        this.nursingId = nursingId;
    }

    public Date getNursingTime() {
        return nursingTime;
    }

    public void setNursingTime(Date nursingTime) {
        this.nursingTime = nursingTime;
    }

    public String getNursingContent() {
        return nursingContent;
    }

    public void setNursingContent(String nursingContent) {
        this.nursingContent = nursingContent == null ? null : nursingContent.trim();
    }
}
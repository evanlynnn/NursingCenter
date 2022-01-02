package edu.jsut.nursing.model;

public class Nursing {
    private Integer nursingId;

    private String nursingName;

    private Integer servicePrice;

    private String description;

    public Integer getNursingId() {
        return nursingId;
    }

    public void setNursingId(Integer nursingId) {
        this.nursingId = nursingId;
    }

    public String getNursingName() {
        return nursingName;
    }

    public void setNursingName(String nursingName) {
        this.nursingName = nursingName == null ? null : nursingName.trim();
    }

    public Integer getServicePrice() {
        return servicePrice;
    }

    public void setServicePrice(Integer servicePrice) {
        this.servicePrice = servicePrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
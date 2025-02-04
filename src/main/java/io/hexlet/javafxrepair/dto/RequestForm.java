package io.hexlet.javafxrepair.dto;

import java.sql.Date;

public class RequestForm {
    private Integer requestNumber;
    private Date startDate;
    private String type;
    private String model;
    private String problemDescription;
    private String fullName;
    private String phone;
    private String status;

    public RequestForm(Integer requestNumber, Date startDate, String type, String model, String problemDescription, String fullName, String phone, String status) {
        this.requestNumber = requestNumber;
        this.startDate = startDate;
        this.type = type;
        this.model = model;
        this.problemDescription = problemDescription;
        this.fullName = fullName;
        this.phone = phone;
        this.status = status;
    }

    public Integer getRequestNumber() {
        return requestNumber;
    }

    public Date getStartDate() {
        return startDate;
    }

    public String getType() {
        return type;
    }

    public String getModel() {
        return model;
    }

    public String getProblemDescription() {
        return problemDescription;
    }

    public String getFullName() {
        return fullName;
    }

    public String getPhone() {
        return phone;
    }

    public String getStatus() {
        return status;
    }
}

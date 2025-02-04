package io.hexlet.javafxrepair.model;

import java.sql.Date;

public class Request {
    private Integer id;
    private Date startDate;
    private String type;
    private String model;
    private String problemDescription;
    private String status;
    private Date finishDate;
    private String repairParts;
    private Integer masterId;
    private Integer clientId;

    public Integer getId() {
        return id;
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

    public String getStatus() {
        return status;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public String getRepairParts() {
        return repairParts;
    }

    public Integer getMasterId() {
        return masterId;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public void setMasterId(Integer masterId) {
        this.masterId = masterId;
    }

    public void setRepairParts(String repairParts) {
        this.repairParts = repairParts;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setProblemDescription(String problemDescription) {
        this.problemDescription = problemDescription;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Request(Integer id, Date startDate, String type, String model, String problemDescription, String status, Date finishDate, String repairParts, Integer masterId, Integer clientId) {
        this.clientId = clientId;
        this.masterId = masterId;
        this.repairParts = repairParts;
        this.finishDate = finishDate;
        this.status = status;
        this.problemDescription = problemDescription;
        this.model = model;
        this.type = type;
        this.startDate = startDate;
        this.id = id;
    }
}

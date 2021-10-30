package com.system.survey.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.Gson;
import com.system.survey.enums.ActiveStatus;

import java.sql.Timestamp;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class IntTypeDto {

    private Long intTypeId;
    private String intTypeUuid;
    private String intTypeName;
    private String intTypeShortDescription;
    private String intTypeDescription;
    private Timestamp updatedDts;
    private String updatedBy;
    private Timestamp createdDts;
    private String createdBy;
    private ActiveStatus activeStatus;

    public IntTypeDto() {
    }

    public Long getIntTypeId() {
        return intTypeId;
    }

    public void setIntTypeId(Long intTypeId) {
        this.intTypeId = intTypeId;
    }

    public String getIntTypeUuid() {
        return intTypeUuid;
    }

    public void setIntTypeUuid(String intTypeUuid) {
        this.intTypeUuid = intTypeUuid;
    }

    public String getIntTypeName() {
        return intTypeName;
    }

    public void setIntTypeName(String intTypeName) {
        this.intTypeName = intTypeName;
    }

    public String getIntTypeShortDescription() {
        return intTypeShortDescription;
    }

    public void setIntTypeShortDescription(String intTypeShortDescription) {
        this.intTypeShortDescription = intTypeShortDescription;
    }

    public String getIntTypeDescription() {
        return intTypeDescription;
    }

    public void setIntTypeDescription(String intTypeDescription) {
        this.intTypeDescription = intTypeDescription;
    }

    public Timestamp getUpdatedDts() {
        return updatedDts;
    }

    public void setUpdatedDts(Timestamp updatedDts) {
        this.updatedDts = updatedDts;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Timestamp getCreatedDts() {
        return createdDts;
    }

    public void setCreatedDts(Timestamp createdDts) {
        this.createdDts = createdDts;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public ActiveStatus getActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(ActiveStatus activeStatus) {
        this.activeStatus = activeStatus;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}

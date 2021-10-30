package com.system.survey.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.Gson;
import com.system.survey.enums.ActiveStatus;

import java.sql.Timestamp;


@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class IntCmdParamDto {

    private Long intCmdParamId;
    private String intCmdParamUuid;
    private String intCmdParamIntCmdUuid;
    private String intCmdParamIntCmdId;
    private String intCmdParamName;
    private String intCmdParamDefaultvalue;
    private String intCmdParamDescription;
    private String intCmdParamShortdescription;
    private String intCmdParamPosition;
    private Timestamp updatedDts;
    private String updatedBy;
    private Timestamp createdDts;
    private String createdBy;
    private ActiveStatus activeStatus;

    public IntCmdParamDto() {
    }

    public Long getIntCmdParamId() {
        return intCmdParamId;
    }

    public void setIntCmdParamId(Long intCmdParamId) {
        this.intCmdParamId = intCmdParamId;
    }

    public String getIntCmdParamUuid() {
        return intCmdParamUuid;
    }

    public void setIntCmdParamUuid(String intCmdParamUuid) {
        this.intCmdParamUuid = intCmdParamUuid;
    }

    public String getIntCmdParamIntCmdUuid() {
        return intCmdParamIntCmdUuid;
    }

    public void setIntCmdParamIntCmdUuid(String intCmdParamIntCmdUuid) {
        this.intCmdParamIntCmdUuid = intCmdParamIntCmdUuid;
    }

    public String getIntCmdParamIntCmdId() {
        return intCmdParamIntCmdId;
    }

    public void setIntCmdParamIntCmdId(String intCmdParamIntCmdId) {
        this.intCmdParamIntCmdId = intCmdParamIntCmdId;
    }

    public String getIntCmdParamName() {
        return intCmdParamName;
    }

    public void setIntCmdParamName(String intCmdParamName) {
        this.intCmdParamName = intCmdParamName;
    }

    public String getIntCmdParamDefaultvalue() {
        return intCmdParamDefaultvalue;
    }

    public void setIntCmdParamDefaultvalue(String intCmdParamDefaultvalue) {
        this.intCmdParamDefaultvalue = intCmdParamDefaultvalue;
    }

    public String getIntCmdParamDescription() {
        return intCmdParamDescription;
    }

    public void setIntCmdParamDescription(String intCmdParamDescription) {
        this.intCmdParamDescription = intCmdParamDescription;
    }

    public String getIntCmdParamShortdescription() {
        return intCmdParamShortdescription;
    }

    public void setIntCmdParamShortdescription(String intCmdParamShortdescription) {
        this.intCmdParamShortdescription = intCmdParamShortdescription;
    }

    public String getIntCmdParamPosition() {
        return intCmdParamPosition;
    }

    public void setIntCmdParamPosition(String intCmdParamPosition) {
        this.intCmdParamPosition = intCmdParamPosition;
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

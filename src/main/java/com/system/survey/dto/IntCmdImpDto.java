package com.system.survey.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.Gson;
import com.system.survey.enums.ActiveStatus;

import java.sql.Timestamp;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class IntCmdImpDto {

    private Long intCmdImpId;
    private String intCmdImpUuid;
    private String intCmdImpIntCmdId;
    private String intCmdImpIntCmdUuid;
    private String intCmdImpIntCmdParamId;
    private String intCmdImpIntCmdParamUuid;
    private String intCmdImpIntCmdParamValue;
    private String intCmdImpUserUuid;
    private Timestamp updatedDts;
    private String updatedBy;
    private Timestamp createdDts;
    private String createdBy;
    private ActiveStatus activeStatus;

    public IntCmdImpDto() {
    }

    public Long getIntCmdImpId() {
        return intCmdImpId;
    }

    public void setIntCmdImpId(Long intCmdImpId) {
        this.intCmdImpId = intCmdImpId;
    }

    public String getIntCmdImpUuid() {
        return intCmdImpUuid;
    }

    public void setIntCmdImpUuid(String intCmdImpUuid) {
        this.intCmdImpUuid = intCmdImpUuid;
    }

    public String getIntCmdImpIntCmdId() {
        return intCmdImpIntCmdId;
    }

    public void setIntCmdImpIntCmdId(String intCmdImpIntCmdId) {
        this.intCmdImpIntCmdId = intCmdImpIntCmdId;
    }

    public String getIntCmdImpIntCmdUuid() {
        return intCmdImpIntCmdUuid;
    }

    public void setIntCmdImpIntCmdUuid(String intCmdImpIntCmdUuid) {
        this.intCmdImpIntCmdUuid = intCmdImpIntCmdUuid;
    }

    public String getIntCmdImpIntCmdParamId() {
        return intCmdImpIntCmdParamId;
    }

    public void setIntCmdImpIntCmdParamId(String intCmdImpIntCmdParamId) {
        this.intCmdImpIntCmdParamId = intCmdImpIntCmdParamId;
    }

    public String getIntCmdImpIntCmdParamUuid() {
        return intCmdImpIntCmdParamUuid;
    }

    public void setIntCmdImpIntCmdParamUuid(String intCmdImpIntCmdParamUuid) {
        this.intCmdImpIntCmdParamUuid = intCmdImpIntCmdParamUuid;
    }

    public String getIntCmdImpIntCmdParamValue() {
        return intCmdImpIntCmdParamValue;
    }

    public void setIntCmdImpIntCmdParamValue(String intCmdImpIntCmdParamValue) {
        this.intCmdImpIntCmdParamValue = intCmdImpIntCmdParamValue;
    }

    public String getIntCmdImpUserUuid() {
        return intCmdImpUserUuid;
    }

    public void setIntCmdImpUserUuid(String intCmdImpUserUuid) {
        this.intCmdImpUserUuid = intCmdImpUserUuid;
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

package com.system.survey.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.Gson;
import com.system.survey.enums.ActiveStatus;

import java.sql.Timestamp;


@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class IntParamsDto {

    private Long intParamsId;
    private String intParamsUuid;
    private String intParamsName;
    private String intParamsValue;
    private String intParamsTypeId;
    private String intParamsTypeuuId;
    private String intParamsLabel;
    private String intParamsParamTypeId;
    private String intParamsParamTypeuuid;
    private Timestamp updatedDts;
    private String updatedBy;
    private Timestamp createdDts;
    private String createdBy;
    private ActiveStatus activeStatus;

    public IntParamsDto() {
    }

    public Long getIntParamsId() {
        return intParamsId;
    }

    public void setIntParamsId(Long intParamsId) {
        this.intParamsId = intParamsId;
    }

    public String getIntParamsUuid() {
        return intParamsUuid;
    }

    public void setIntParamsUuid(String intParamsUuid) {
        this.intParamsUuid = intParamsUuid;
    }

    public String getIntParamsName() {
        return intParamsName;
    }

    public void setIntParamsName(String intParamsName) {
        this.intParamsName = intParamsName;
    }

    public String getIntParamsValue() {
        return intParamsValue;
    }

    public void setIntParamsValue(String intParamsValue) {
        this.intParamsValue = intParamsValue;
    }

    public String getIntParamsTypeId() {
        return intParamsTypeId;
    }

    public void setIntParamsTypeId(String intParamsTypeId) {
        this.intParamsTypeId = intParamsTypeId;
    }

    public String getIntParamsTypeuuId() {
        return intParamsTypeuuId;
    }

    public void setIntParamsTypeuuId(String intParamsTypeuuId) {
        this.intParamsTypeuuId = intParamsTypeuuId;
    }

    public String getIntParamsLabel() {
        return intParamsLabel;
    }

    public void setIntParamsLabel(String intParamsLabel) {
        this.intParamsLabel = intParamsLabel;
    }

    public String getIntParamsParamTypeId() {
        return intParamsParamTypeId;
    }

    public void setIntParamsParamTypeId(String intParamsParamTypeId) {
        this.intParamsParamTypeId = intParamsParamTypeId;
    }

    public String getIntParamsParamTypeuuid() {
        return intParamsParamTypeuuid;
    }

    public void setIntParamsParamTypeuuid(String intParamsParamTypeuuid) {
        this.intParamsParamTypeuuid = intParamsParamTypeuuid;
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

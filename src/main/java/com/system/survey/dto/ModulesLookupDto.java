package com.system.survey.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.Gson;
import com.system.survey.enums.ActiveStatus;

import java.sql.Timestamp;


@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ModulesLookupDto {

    private Long modulesLookupId;
    private String modulesLookupUuid;
    private String modulesLookupNumber;
    private String modulesLookupShortDescription;
    private String modulesLookupName;
    private String modulesLookupDescription;
    private Timestamp createdDts;
    private String createdBy;
    private ActiveStatus activeStatus;
    private Timestamp updatedDts;
    private String updatedBy;

    public ModulesLookupDto() {
    }

    public Long getModulesLookupId() {
        return modulesLookupId;
    }

    public void setModulesLookupId(Long modulesLookupId) {
        this.modulesLookupId = modulesLookupId;
    }

    public String getModulesLookupUuid() {
        return modulesLookupUuid;
    }

    public void setModulesLookupUuid(String modulesLookupUuid) {
        this.modulesLookupUuid = modulesLookupUuid;
    }

    public String getModulesLookupNumber() {
        return modulesLookupNumber;
    }

    public void setModulesLookupNumber(String modulesLookupNumber) {
        this.modulesLookupNumber = modulesLookupNumber;
    }

    public String getModulesLookupShortDescription() {
        return modulesLookupShortDescription;
    }

    public void setModulesLookupShortDescription(String modulesLookupShortDescription) {
        this.modulesLookupShortDescription = modulesLookupShortDescription;
    }

    public String getModulesLookupName() {
        return modulesLookupName;
    }

    public void setModulesLookupName(String modulesLookupName) {
        this.modulesLookupName = modulesLookupName;
    }

    public String getModulesLookupDescription() {
        return modulesLookupDescription;
    }

    public void setModulesLookupDescription(String modulesLookupDescription) {
        this.modulesLookupDescription = modulesLookupDescription;
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

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }

}

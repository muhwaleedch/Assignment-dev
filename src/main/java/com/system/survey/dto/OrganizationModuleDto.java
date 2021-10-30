package com.system.survey.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.Gson;
import com.system.survey.enums.ActiveStatus;

import java.sql.Timestamp;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrganizationModuleDto {

    private Long organizationModuleId;
    private String organizationModuleUuid;
    private String organizationUuid;
    private String moduleLookupUuid;
    private Timestamp createdDts;
    private String createdBy;
    private ActiveStatus activeStatus;
    private Timestamp updatedDts;
    private String updatedBy;

    public OrganizationModuleDto() {
    }

    public Long getOrganizationModuleId() {
        return organizationModuleId;
    }

    public void setOrganizationModuleId(Long organizationModuleId) {
        this.organizationModuleId = organizationModuleId;
    }

    public String getOrganizationModuleUuid() {
        return organizationModuleUuid;
    }

    public void setOrganizationModuleUuid(String organizationModuleUuid) {
        this.organizationModuleUuid = organizationModuleUuid;
    }

    public String getOrganizationUuid() {
        return organizationUuid;
    }

    public void setOrganizationUuid(String organizationUuid) {
        this.organizationUuid = organizationUuid;
    }

    public String getModuleLookupUuid() {
        return moduleLookupUuid;
    }

    public void setModuleLookupUuid(String moduleLookupUuid) {
        this.moduleLookupUuid = moduleLookupUuid;
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

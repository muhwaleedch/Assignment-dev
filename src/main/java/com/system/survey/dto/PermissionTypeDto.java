package com.system.survey.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.Gson;
import com.system.survey.enums.ActiveStatus;

import java.sql.Timestamp;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PermissionTypeDto {

    private Long permissionTypeId;
    private String permissionTypeUuid;
    private String permissionTypeName;
    private String permissionTypeShortDescription;
    private String permissionTypeDescription;
    private Timestamp createdDts;
    private String createdBy;
    private ActiveStatus activeStatus;
    private Timestamp updatedDts;
    private String updatedBy;

    public PermissionTypeDto() {
    }

    public Long getPermissionTypeId() {
        return permissionTypeId;
    }

    public void setPermissionTypeId(Long permissionTypeId) {
        this.permissionTypeId = permissionTypeId;
    }

    public String getPermissionTypeUuid() {
        return permissionTypeUuid;
    }

    public void setPermissionTypeUuid(String permissionTypeUuid) {
        this.permissionTypeUuid = permissionTypeUuid;
    }

    public String getPermissionTypeName() {
        return permissionTypeName;
    }

    public void setPermissionTypeName(String permissionTypeName) {
        this.permissionTypeName = permissionTypeName;
    }

    public String getPermissionTypeShortDescription() {
        return permissionTypeShortDescription;
    }

    public void setPermissionTypeShortDescription(String permissionTypeShortDescription) {
        this.permissionTypeShortDescription = permissionTypeShortDescription;
    }

    public String getPermissionTypeDescription() {
        return permissionTypeDescription;
    }

    public void setPermissionTypeDescription(String permissionTypeDescription) {
        this.permissionTypeDescription = permissionTypeDescription;
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

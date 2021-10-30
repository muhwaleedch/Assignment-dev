package com.system.survey.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.Gson;
import com.system.survey.enums.ActiveStatus;

import java.sql.Timestamp;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PermissionDto {

    private Long permissionId;
    private String permissionUuid;
    private String permissionName;
    private String permissionDesc;
    private String permissionResourceId;
    private String permissionResourceUuid;
    private String permissionAvailableIndicator;
    private String permissionCreate;
    private String permissionCreatePermissionTypeId;
    private String permissionDelete;
    private String permissionDeletePermissionTypeId;
    private String permissionUpdate;
    private String permissionUpdatePermissionTypeId;
    private String permissionRead;
    private String permissionReadPermissionTypeId;
    private String permissionSoftDelete;
    private String permissionSoftDeletePermissionTypeId;
    private String permissionOperaterId;
    private String permissionAuthorizeUserId;
    private Timestamp createdDts;
    private String cratedBy;
    private ActiveStatus activeStatus;
    private Timestamp updatedDts;
    private String updatedBy;
    private String createdBy;

    public PermissionDto() {
    }

    public Long getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }

    public String getPermissionUuid() {
        return permissionUuid;
    }

    public void setPermissionUuid(String permissionUuid) {
        this.permissionUuid = permissionUuid;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public String getPermissionDesc() {
        return permissionDesc;
    }

    public void setPermissionDesc(String permissionDesc) {
        this.permissionDesc = permissionDesc;
    }

    public String getPermissionResourceId() {
        return permissionResourceId;
    }

    public void setPermissionResourceId(String permissionResourceId) {
        this.permissionResourceId = permissionResourceId;
    }

    public String getPermissionResourceUuid() {
        return permissionResourceUuid;
    }

    public void setPermissionResourceUuid(String permissionResourceUuid) {
        this.permissionResourceUuid = permissionResourceUuid;
    }

    public String getPermissionAvailableIndicator() {
        return permissionAvailableIndicator;
    }

    public void setPermissionAvailableIndicator(String permissionAvailableIndicator) {
        this.permissionAvailableIndicator = permissionAvailableIndicator;
    }

    public String getPermissionCreate() {
        return permissionCreate;
    }

    public void setPermissionCreate(String permissionCreate) {
        this.permissionCreate = permissionCreate;
    }

    public String getPermissionCreatePermissionTypeId() {
        return permissionCreatePermissionTypeId;
    }

    public void setPermissionCreatePermissionTypeId(String permissionCreatePermissionTypeId) {
        this.permissionCreatePermissionTypeId = permissionCreatePermissionTypeId;
    }

    public String getPermissionDelete() {
        return permissionDelete;
    }

    public void setPermissionDelete(String permissionDelete) {
        this.permissionDelete = permissionDelete;
    }

    public String getPermissionDeletePermissionTypeId() {
        return permissionDeletePermissionTypeId;
    }

    public void setPermissionDeletePermissionTypeId(String permissionDeletePermissionTypeId) {
        this.permissionDeletePermissionTypeId = permissionDeletePermissionTypeId;
    }

    public String getPermissionUpdate() {
        return permissionUpdate;
    }

    public void setPermissionUpdate(String permissionUpdate) {
        this.permissionUpdate = permissionUpdate;
    }

    public String getPermissionUpdatePermissionTypeId() {
        return permissionUpdatePermissionTypeId;
    }

    public void setPermissionUpdatePermissionTypeId(String permissionUpdatePermissionTypeId) {
        this.permissionUpdatePermissionTypeId = permissionUpdatePermissionTypeId;
    }

    public String getPermissionRead() {
        return permissionRead;
    }

    public void setPermissionRead(String permissionRead) {
        this.permissionRead = permissionRead;
    }

    public String getPermissionReadPermissionTypeId() {
        return permissionReadPermissionTypeId;
    }

    public void setPermissionReadPermissionTypeId(String permissionReadPermissionTypeId) {
        this.permissionReadPermissionTypeId = permissionReadPermissionTypeId;
    }

    public String getPermissionSoftDelete() {
        return permissionSoftDelete;
    }

    public void setPermissionSoftDelete(String permissionSoftDelete) {
        this.permissionSoftDelete = permissionSoftDelete;
    }

    public String getPermissionSoftDeletePermissionTypeId() {
        return permissionSoftDeletePermissionTypeId;
    }

    public void setPermissionSoftDeletePermissionTypeId(String permissionSoftDeletePermissionTypeId) {
        this.permissionSoftDeletePermissionTypeId = permissionSoftDeletePermissionTypeId;
    }

    public String getPermissionOperaterId() {
        return permissionOperaterId;
    }

    public void setPermissionOperaterId(String permissionOperaterId) {
        this.permissionOperaterId = permissionOperaterId;
    }

    public String getPermissionAuthorizeUserId() {
        return permissionAuthorizeUserId;
    }

    public void setPermissionAuthorizeUserId(String permissionAuthorizeUserId) {
        this.permissionAuthorizeUserId = permissionAuthorizeUserId;
    }

    public Timestamp getCreatedDts() {
        return createdDts;
    }

    public void setCreatedDts(Timestamp createdDts) {
        this.createdDts = createdDts;
    }

    public String getCratedBy() {
        return cratedBy;
    }

    public void setCratedBy(String cratedBy) {
        this.cratedBy = cratedBy;
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

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}

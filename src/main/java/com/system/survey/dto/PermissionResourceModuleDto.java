package com.system.survey.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.Gson;
import com.system.survey.enums.ActiveStatus;

import java.sql.Timestamp;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PermissionResourceModuleDto {

    private Long permissionResourceModuleId;
    private String permissionResourceModuleUuid;
    private String permissionResourceModuleName;
    private String permissionResourceModuleDesc;
    private String permissionResourceModuleResourceId;
    private String permissionResourceModuleResourceUuid;
    private String permissionResourceModuleAvailableIndicator;
    private String permissionResourceModuleCreate;
    private String permissionResourceModuleCreatePermissionTypeId;
    private String permissionResourceModuleDelete;
    private String permissionResourceModuleDeletePermissionTypeId;
    private String permissionResourceModuleUpdate;
    private String permissionResourceModuleUpdatePermissionTypeId;
    private String permissionResourceModuleRead;
    private String permissionResourceModuleReadPermissionTypeId;
    private String permissionResourceModuleSoftDelete;
    private String permissionResourceModuleSoftDeletePermissionTypeId;
    private String permissionResourceModuleOperaterId;
    private String permissionResourceModuleAuthorizeUserId;
    private Timestamp createdDts;
    private String createdBy;
    private ActiveStatus activeStatus;
    private Timestamp updatedDts;
    private String updatedBy;
    private String cratedBy;

    public PermissionResourceModuleDto() {
    }

    public Long getPermissionResourceModuleId() {
        return permissionResourceModuleId;
    }

    public void setPermissionResourceModuleId(Long permissionResourceModuleId) {
        this.permissionResourceModuleId = permissionResourceModuleId;
    }

    public String getPermissionResourceModuleUuid() {
        return permissionResourceModuleUuid;
    }

    public void setPermissionResourceModuleUuid(String permissionResourceModuleUuid) {
        this.permissionResourceModuleUuid = permissionResourceModuleUuid;
    }

    public String getPermissionResourceModuleName() {
        return permissionResourceModuleName;
    }

    public void setPermissionResourceModuleName(String permissionResourceModuleName) {
        this.permissionResourceModuleName = permissionResourceModuleName;
    }

    public String getPermissionResourceModuleDesc() {
        return permissionResourceModuleDesc;
    }

    public void setPermissionResourceModuleDesc(String permissionResourceModuleDesc) {
        this.permissionResourceModuleDesc = permissionResourceModuleDesc;
    }

    public String getPermissionResourceModuleResourceId() {
        return permissionResourceModuleResourceId;
    }

    public void setPermissionResourceModuleResourceId(String permissionResourceModuleResourceId) {
        this.permissionResourceModuleResourceId = permissionResourceModuleResourceId;
    }

    public String getPermissionResourceModuleResourceUuid() {
        return permissionResourceModuleResourceUuid;
    }

    public void setPermissionResourceModuleResourceUuid(String permissionResourceModuleResourceUuid) {
        this.permissionResourceModuleResourceUuid = permissionResourceModuleResourceUuid;
    }

    public String getPermissionResourceModuleAvailableIndicator() {
        return permissionResourceModuleAvailableIndicator;
    }

    public void setPermissionResourceModuleAvailableIndicator(String permissionResourceModuleAvailableIndicator) {
        this.permissionResourceModuleAvailableIndicator = permissionResourceModuleAvailableIndicator;
    }

    public String getPermissionResourceModuleCreate() {
        return permissionResourceModuleCreate;
    }

    public void setPermissionResourceModuleCreate(String permissionResourceModuleCreate) {
        this.permissionResourceModuleCreate = permissionResourceModuleCreate;
    }

    public String getPermissionResourceModuleCreatePermissionTypeId() {
        return permissionResourceModuleCreatePermissionTypeId;
    }

    public void setPermissionResourceModuleCreatePermissionTypeId(String permissionResourceModuleCreatePermissionTypeId) {
        this.permissionResourceModuleCreatePermissionTypeId = permissionResourceModuleCreatePermissionTypeId;
    }

    public String getPermissionResourceModuleDelete() {
        return permissionResourceModuleDelete;
    }

    public void setPermissionResourceModuleDelete(String permissionResourceModuleDelete) {
        this.permissionResourceModuleDelete = permissionResourceModuleDelete;
    }

    public String getPermissionResourceModuleDeletePermissionTypeId() {
        return permissionResourceModuleDeletePermissionTypeId;
    }

    public void setPermissionResourceModuleDeletePermissionTypeId(String permissionResourceModuleDeletePermissionTypeId) {
        this.permissionResourceModuleDeletePermissionTypeId = permissionResourceModuleDeletePermissionTypeId;
    }

    public String getPermissionResourceModuleUpdate() {
        return permissionResourceModuleUpdate;
    }

    public void setPermissionResourceModuleUpdate(String permissionResourceModuleUpdate) {
        this.permissionResourceModuleUpdate = permissionResourceModuleUpdate;
    }

    public String getPermissionResourceModuleUpdatePermissionTypeId() {
        return permissionResourceModuleUpdatePermissionTypeId;
    }

    public void setPermissionResourceModuleUpdatePermissionTypeId(String permissionResourceModuleUpdatePermissionTypeId) {
        this.permissionResourceModuleUpdatePermissionTypeId = permissionResourceModuleUpdatePermissionTypeId;
    }

    public String getPermissionResourceModuleRead() {
        return permissionResourceModuleRead;
    }

    public void setPermissionResourceModuleRead(String permissionResourceModuleRead) {
        this.permissionResourceModuleRead = permissionResourceModuleRead;
    }

    public String getPermissionResourceModuleReadPermissionTypeId() {
        return permissionResourceModuleReadPermissionTypeId;
    }

    public void setPermissionResourceModuleReadPermissionTypeId(String permissionResourceModuleReadPermissionTypeId) {
        this.permissionResourceModuleReadPermissionTypeId = permissionResourceModuleReadPermissionTypeId;
    }

    public String getPermissionResourceModuleSoftDelete() {
        return permissionResourceModuleSoftDelete;
    }

    public void setPermissionResourceModuleSoftDelete(String permissionResourceModuleSoftDelete) {
        this.permissionResourceModuleSoftDelete = permissionResourceModuleSoftDelete;
    }

    public String getPermissionResourceModuleSoftDeletePermissionTypeId() {
        return permissionResourceModuleSoftDeletePermissionTypeId;
    }

    public void setPermissionResourceModuleSoftDeletePermissionTypeId(String permissionResourceModuleSoftDeletePermissionTypeId) {
        this.permissionResourceModuleSoftDeletePermissionTypeId = permissionResourceModuleSoftDeletePermissionTypeId;
    }

    public String getPermissionResourceModuleOperaterId() {
        return permissionResourceModuleOperaterId;
    }

    public void setPermissionResourceModuleOperaterId(String permissionResourceModuleOperaterId) {
        this.permissionResourceModuleOperaterId = permissionResourceModuleOperaterId;
    }

    public String getPermissionResourceModuleAuthorizeUserId() {
        return permissionResourceModuleAuthorizeUserId;
    }

    public void setPermissionResourceModuleAuthorizeUserId(String permissionResourceModuleAuthorizeUserId) {
        this.permissionResourceModuleAuthorizeUserId = permissionResourceModuleAuthorizeUserId;
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

    public String getCratedBy() {
        return cratedBy;
    }

    public void setCratedBy(String cratedBy) {
        this.cratedBy = cratedBy;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}

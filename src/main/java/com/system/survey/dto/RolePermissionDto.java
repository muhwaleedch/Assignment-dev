package com.system.survey.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.Gson;
import com.system.survey.enums.ActiveStatus;

import java.sql.Timestamp;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RolePermissionDto {

    private Long rolePermissionId;
    private String rolePermissionUuid;
    private String roleId;
    private String permissionId;
    private String rolePermissionAuthorizationUserId;
    private String rolePermissionAvailableIndicator;
    private Timestamp rolePermissionExpirationDate;
    private Timestamp updatedDts;
    private String updatedBy;
    private Timestamp createdDts;
    private String createdBy;
    private ActiveStatus activeStatus;

    public RolePermissionDto() {
    }

    public Long getRolePermissionId() {
        return rolePermissionId;
    }

    public void setRolePermissionId(Long rolePermissionId) {
        this.rolePermissionId = rolePermissionId;
    }

    public String getRolePermissionUuid() {
        return rolePermissionUuid;
    }

    public void setRolePermissionUuid(String rolePermissionUuid) {
        this.rolePermissionUuid = rolePermissionUuid;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId;
    }

    public String getRolePermissionAuthorizationUserId() {
        return rolePermissionAuthorizationUserId;
    }

    public void setRolePermissionAuthorizationUserId(String rolePermissionAuthorizationUserId) {
        this.rolePermissionAuthorizationUserId = rolePermissionAuthorizationUserId;
    }

    public String getRolePermissionAvailableIndicator() {
        return rolePermissionAvailableIndicator;
    }

    public void setRolePermissionAvailableIndicator(String rolePermissionAvailableIndicator) {
        this.rolePermissionAvailableIndicator = rolePermissionAvailableIndicator;
    }

    public Timestamp getRolePermissionExpirationDate() {
        return rolePermissionExpirationDate;
    }

    public void setRolePermissionExpirationDate(Timestamp rolePermissionExpirationDate) {
        this.rolePermissionExpirationDate = rolePermissionExpirationDate;
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

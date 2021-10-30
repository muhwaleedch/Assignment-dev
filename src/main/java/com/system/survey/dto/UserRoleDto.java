package com.system.survey.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.Gson;
import com.system.survey.enums.ActiveStatus;

import java.sql.Timestamp;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserRoleDto {

    private Long userRoleId;
    private String userRoleUuid;
    private String permissionId;
    private String userId;
    private String userRoleAuthorizationUserId;
    private String userRoleAvailableIndicator;
    private Timestamp userRoleExpirationDate;
    private Timestamp updatedDts;
    private String updatedBy;
    private Timestamp createdDts;
    private String createdBy;
    private ActiveStatus activeStatus;

    public UserRoleDto() {
    }

    public Long getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(Long userRoleId) {
        this.userRoleId = userRoleId;
    }

    public String getUserRoleUuid() {
        return userRoleUuid;
    }

    public void setUserRoleUuid(String userRoleUuid) {
        this.userRoleUuid = userRoleUuid;
    }

    public String getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserRoleAuthorizationUserId() {
        return userRoleAuthorizationUserId;
    }

    public void setUserRoleAuthorizationUserId(String userRoleAuthorizationUserId) {
        this.userRoleAuthorizationUserId = userRoleAuthorizationUserId;
    }

    public String getUserRoleAvailableIndicator() {
        return userRoleAvailableIndicator;
    }

    public void setUserRoleAvailableIndicator(String userRoleAvailableIndicator) {
        this.userRoleAvailableIndicator = userRoleAvailableIndicator;
    }

    public Timestamp getUserRoleExpirationDate() {
        return userRoleExpirationDate;
    }

    public void setUserRoleExpirationDate(Timestamp userRoleExpirationDate) {
        this.userRoleExpirationDate = userRoleExpirationDate;
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

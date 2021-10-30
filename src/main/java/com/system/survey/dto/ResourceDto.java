package com.system.survey.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.Gson;
import com.system.survey.enums.ActiveStatus;

import java.sql.Timestamp;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResourceDto {

    private Long resourceId;
    private String resourceUuid;
    private String resourceName;
    private String resourceType;
    private String resourceDesc;
    private String resourceTypeDesc;
    private String resourceVersionNumber;
    private String resourceAvailableIndicator;
    private String resourceParentId;
    private String resourceAuthUserId;
    private Timestamp createdDts;
    private String createdBy;
    private ActiveStatus activeStatus;
    private Timestamp updatedDts;
    private String updatedBy;
    private String resourceResourceTypeUuid;

    public ResourceDto() {
    }

    public Long getResourceId() {
        return resourceId;
    }

    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }

    public String getResourceUuid() {
        return resourceUuid;
    }

    public void setResourceUuid(String resourceUuid) {
        this.resourceUuid = resourceUuid;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public String getResourceDesc() {
        return resourceDesc;
    }

    public void setResourceDesc(String resourceDesc) {
        this.resourceDesc = resourceDesc;
    }

    public String getResourceTypeDesc() {
        return resourceTypeDesc;
    }

    public void setResourceTypeDesc(String resourceTypeDesc) {
        this.resourceTypeDesc = resourceTypeDesc;
    }

    public String getResourceVersionNumber() {
        return resourceVersionNumber;
    }

    public void setResourceVersionNumber(String resourceVersionNumber) {
        this.resourceVersionNumber = resourceVersionNumber;
    }

    public String getResourceAvailableIndicator() {
        return resourceAvailableIndicator;
    }

    public void setResourceAvailableIndicator(String resourceAvailableIndicator) {
        this.resourceAvailableIndicator = resourceAvailableIndicator;
    }

    public String getResourceParentId() {
        return resourceParentId;
    }

    public void setResourceParentId(String resourceParentId) {
        this.resourceParentId = resourceParentId;
    }

    public String getResourceAuthUserId() {
        return resourceAuthUserId;
    }

    public void setResourceAuthUserId(String resourceAuthUserId) {
        this.resourceAuthUserId = resourceAuthUserId;
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

    public String getResourceResourceTypeUuid() {
        return resourceResourceTypeUuid;
    }

    public void setResourceResourceTypeUuid(String resourceResourceTypeUuid) {
        this.resourceResourceTypeUuid = resourceResourceTypeUuid;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}

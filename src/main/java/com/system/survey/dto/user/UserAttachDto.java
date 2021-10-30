package com.system.survey.dto.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.system.survey.enums.ActiveStatus;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserAttachDto {

    private Long userAttachId;

    private String userAttachUuid;

    private String userUserId;

    private String userUserUuid;

    private String userAttachPath;

    private byte[] userAttachBlob;

    private ActiveStatus activeStatus;

    private String userAttachTypeUuid;

    private String userAttachOrgFilenamePath;

    private String contentType;

    public Long getUserAttachId() {
        return userAttachId;
    }

    public void setUserAttachId(Long userAttachId) {
        this.userAttachId = userAttachId;
    }

    public String getUserAttachUuid() {
        return userAttachUuid;
    }

    public void setUserAttachUuid(String userAttachUuid) {
        this.userAttachUuid = userAttachUuid;
    }

    public String getUserUserId() {
        return userUserId;
    }

    public void setUserUserId(String userUserId) {
        this.userUserId = userUserId;
    }

    public String getUserUserUuid() {
        return userUserUuid;
    }

    public void setUserUserUuid(String userUserUuid) {
        this.userUserUuid = userUserUuid;
    }

    public String getUserAttachPath() {
        return userAttachPath;
    }

    public void setUserAttachPath(String userAttachPath) {
        this.userAttachPath = userAttachPath;
    }

    public byte[] getUserAttachBlob() {
        return userAttachBlob;
    }

    public void setUserAttachBlob(byte[] userAttachBlob) {
        this.userAttachBlob = userAttachBlob;
    }

    public ActiveStatus getActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(ActiveStatus activeStatus) {
        this.activeStatus = activeStatus;
    }

    public String getUserAttachTypeUuid() {
        return userAttachTypeUuid;
    }

    public void setUserAttachTypeUuid(String userAttachTypeUuid) {
        this.userAttachTypeUuid = userAttachTypeUuid;
    }

    public String getUserAttachOrgFilenamePath() {
        return userAttachOrgFilenamePath;
    }

    public void setUserAttachOrgFilenamePath(String userAttachOrgFilenamePath) {
        this.userAttachOrgFilenamePath = userAttachOrgFilenamePath;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

}

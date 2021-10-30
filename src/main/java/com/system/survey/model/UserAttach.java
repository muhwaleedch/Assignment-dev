package com.system.survey.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;

@Entity
@Table(name = "user_attach")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserAttach extends BaseEntity {

    @Id
    @Column(name = "user_attach_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userAttachId;

    @Column(name = "user_attach_uuid")
    private String userAttachUuid;

    @Column(name = "user_userid")
    private String userUserId;

    @Column(name = "user_useruuid")
    private String userUserUuid;

    @Column(name = "user_attach_serverpath")
    private String userAttachPath;

    @Lob
    @Column(name = "user_attach_blob")
    private byte[] userAttachBlob;

    @Column(name = "user_attach_type_uuid")
    private String userAttachTypeUuid;

    @Column(name = "user_attach_orgfilenamepath")
    private String userAttachOrgFilenamePath;

    @Column(name = "user_attach_updateStatus")
    private String userAttachUpdateStatus;

    @Column(name = "user_attach_adminverifyStatus")
    private String userAttachAdminVerifyStatus;

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

    public String getUserAttachUpdateStatus() {
        return userAttachUpdateStatus;
    }

    public void setUserAttachUpdateStatus(String userAttachUpdateStatus) {
        this.userAttachUpdateStatus = userAttachUpdateStatus;
    }

    public String getUserAttachAdminVerifyStatus() {
        return userAttachAdminVerifyStatus;
    }

    public void setUserAttachAdminVerifyStatus(String userAttachAdminVerifyStatus) {
        this.userAttachAdminVerifyStatus = userAttachAdminVerifyStatus;
    }

}

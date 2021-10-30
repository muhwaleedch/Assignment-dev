package com.system.survey.dto.survey;

import java.io.Serializable;


/**
 * The persistent class for the int_question_attach database table.
 */
public class IntQuestionAttachDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private int intQuestionAttachId;

    private String intQuestionAttachAdminverifyStatus;

    private byte[] intQuestionAttachBlob;

    private String intQuestionAttachOrgfilenamepath;

    private String intQuestionAttachQuestionid;

    private String intQuestionAttachQuestionuuid;

    private String intQuestionAttachServerpath;

    private String intQuestionAttachTypeId;

    private String intQuestionAttachTypeUuid;

    private String intQuestionAttachUpdateStatus;

    private String intQuestionAttachUuid;

    private String intQuestionUserid;

    private String intQuestionUseruuid;

    private String intQuestionAttachBase64String;

    private String intQuestionAttachContentType;

    public IntQuestionAttachDto() {
    }

    public int getIntQuestionAttachId() {
        return this.intQuestionAttachId;
    }

    public void setIntQuestionAttachId(int intQuestionAttachId) {
        this.intQuestionAttachId = intQuestionAttachId;
    }

    public String getIntQuestionAttachAdminverifyStatus() {
        return intQuestionAttachAdminverifyStatus;
    }

    public void setIntQuestionAttachAdminverifyStatus(String intQuestionAttachAdminverifyStatus) {
        this.intQuestionAttachAdminverifyStatus = intQuestionAttachAdminverifyStatus;
    }

    public byte[] getIntQuestionAttachBlob() {
        return this.intQuestionAttachBlob;
    }

    public void setIntQuestionAttachBlob(byte[] intQuestionAttachBlob) {
        this.intQuestionAttachBlob = intQuestionAttachBlob;
    }

    public String getIntQuestionAttachOrgfilenamepath() {
        return this.intQuestionAttachOrgfilenamepath;
    }

    public void setIntQuestionAttachOrgfilenamepath(String intQuestionAttachOrgfilenamepath) {
        this.intQuestionAttachOrgfilenamepath = intQuestionAttachOrgfilenamepath;
    }

    public String getIntQuestionAttachQuestionid() {
        return this.intQuestionAttachQuestionid;
    }

    public void setIntQuestionAttachQuestionid(String intQuestionAttachQuestionid) {
        this.intQuestionAttachQuestionid = intQuestionAttachQuestionid;
    }

    public String getIntQuestionAttachQuestionuuid() {
        return this.intQuestionAttachQuestionuuid;
    }

    public void setIntQuestionAttachQuestionuuid(String intQuestionAttachQuestionuuid) {
        this.intQuestionAttachQuestionuuid = intQuestionAttachQuestionuuid;
    }

    public String getIntQuestionAttachServerpath() {
        return this.intQuestionAttachServerpath;
    }

    public void setIntQuestionAttachServerpath(String intQuestionAttachServerpath) {
        this.intQuestionAttachServerpath = intQuestionAttachServerpath;
    }

    public String getIntQuestionAttachTypeId() {
        return this.intQuestionAttachTypeId;
    }

    public void setIntQuestionAttachTypeId(String intQuestionAttachTypeId) {
        this.intQuestionAttachTypeId = intQuestionAttachTypeId;
    }

    public String getIntQuestionAttachTypeUuid() {
        return this.intQuestionAttachTypeUuid;
    }

    public void setIntQuestionAttachTypeUuid(String intQuestionAttachTypeUuid) {
        this.intQuestionAttachTypeUuid = intQuestionAttachTypeUuid;
    }

    public String getIntQuestionAttachUpdateStatus() {
        return intQuestionAttachUpdateStatus;
    }

    public void setIntQuestionAttachUpdateStatus(String intQuestionAttachUpdateStatus) {
        this.intQuestionAttachUpdateStatus = intQuestionAttachUpdateStatus;
    }

    public String getIntQuestionAttachUuid() {
        return this.intQuestionAttachUuid;
    }

    public void setIntQuestionAttachUuid(String intQuestionAttachUuid) {
        this.intQuestionAttachUuid = intQuestionAttachUuid;
    }

    public String getIntQuestionUserid() {
        return intQuestionUserid;
    }

    public void setIntQuestionUserid(String intQuestionUserid) {
        this.intQuestionUserid = intQuestionUserid;
    }

    public String getIntQuestionUseruuid() {
        return intQuestionUseruuid;
    }

    public void setIntQuestionUseruuid(String intQuestionUseruuid) {
        this.intQuestionUseruuid = intQuestionUseruuid;
    }

    public String getIntQuestionAttachBase64String() {
        return intQuestionAttachBase64String;
    }

    public void setIntQuestionAttachBase64String(String intQuestionAttachBase64String) {
        this.intQuestionAttachBase64String = intQuestionAttachBase64String;
    }

    public String getIntQuestionAttachContentType() {
        return intQuestionAttachContentType;
    }

    public void setIntQuestionAttachContentType(String intQuestionAttachContentType) {
        this.intQuestionAttachContentType = intQuestionAttachContentType;
    }

}
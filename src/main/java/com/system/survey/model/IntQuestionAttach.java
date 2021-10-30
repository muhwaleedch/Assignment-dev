package com.system.survey.model;

import javax.persistence.*;
import java.io.Serializable;


/**
 * The persistent class for the int_question_attach database table.
 */
@Entity
@Table(name = "int_question_attach")
@NamedQuery(name = "IntQuestionAttach.findAll", query = "SELECT i FROM IntQuestionAttach i")
public class IntQuestionAttach extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "int_question_attach_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int intQuestionAttachId;

    @Column(name = "int_question_attach_adminverifyStatus")
    private String intQuestionAttachAdminverifyStatus;

    @Lob
    @Column(name = "int_question_attach_blob")
    private byte[] intQuestionAttachBlob;

    @Column(name = "int_question_attach_orgfilenamepath")
    private String intQuestionAttachOrgfilenamepath;

    @Column(name = "int_question_attach_questionid")
    private String intQuestionAttachQuestionid;

    @Column(name = "int_question_attach_questionuuid")
    private String intQuestionAttachQuestionuuid;

    @Column(name = "int_question_attach_serverpath")
    private String intQuestionAttachServerpath;

    @Column(name = "int_question_attach_type_id")
    private String intQuestionAttachTypeId;

    @Column(name = "int_question_attach_type_uuid")
    private String intQuestionAttachTypeUuid;

    @Column(name = "int_question_attach_updateStatus")
    private String intQuestionAttachUpdateStatus;

    @Column(name = "int_question_attach_uuid")
    private String intQuestionAttachUuid;

    @Column(name = "int_question_userid")
    private String intQuestionUserid;

    @Column(name = "int_question_useruuid")
    private String intQuestionUseruuid;


    public IntQuestionAttach() {
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

}
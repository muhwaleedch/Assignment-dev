package com.system.survey.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.io.Serializable;


/**
 * The persistent class for the int_question database table.
 */
@Entity
@Table(name = "int_question")
@NamedQuery(name = "IntQuestion.findAll", query = "SELECT i FROM IntQuestion i")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class IntQuestion extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "int_question_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int intQuestionId;

    @Lob
    @Column(name = "int_question_blob")
    private byte[] intQuestionBlob;

    @Column(name = "int_question_completequestion")
    private String intQuestionCompletequestion;

    @Column(name = "int_question_int_question_typeid")
    private String intQuestionIntQuestionTypeid;

    @Column(name = "int_question_int_question_typeuuid")
    private String intQuestionIntQuestionTypeuuid;

    @Column(name = "int_question_name")
    private String intQuestionName;

    @Column(name = "int_question_uuid")
    private String intQuestionUuid;

    @Column(name = "int_question_parentuuid")
    private String intQuestionParentUuid;

    @Column(name = "int_question_usagestatus")
    private String intQuestionUsagestatus;

    public IntQuestion() {
    }

    public int getIntQuestionId() {
        return intQuestionId;
    }

    public void setIntQuestionId(int intQuestionId) {
        this.intQuestionId = intQuestionId;
    }

    public byte[] getIntQuestionBlob() {
        return intQuestionBlob;
    }

    public void setIntQuestionBlob(byte[] intQuestionBlob) {
        this.intQuestionBlob = intQuestionBlob;
    }

    public String getIntQuestionCompletequestion() {
        return intQuestionCompletequestion;
    }

    public void setIntQuestionCompletequestion(String intQuestionCompletequestion) {
        this.intQuestionCompletequestion = intQuestionCompletequestion;
    }

    public String getIntQuestionIntQuestionTypeid() {
        return intQuestionIntQuestionTypeid;
    }

    public void setIntQuestionIntQuestionTypeid(String intQuestionIntQuestionTypeid) {
        this.intQuestionIntQuestionTypeid = intQuestionIntQuestionTypeid;
    }

    public String getIntQuestionIntQuestionTypeuuid() {
        return intQuestionIntQuestionTypeuuid;
    }

    public void setIntQuestionIntQuestionTypeuuid(String intQuestionIntQuestionTypeuuid) {
        this.intQuestionIntQuestionTypeuuid = intQuestionIntQuestionTypeuuid;
    }

    public String getIntQuestionName() {
        return intQuestionName;
    }

    public void setIntQuestionName(String intQuestionName) {
        this.intQuestionName = intQuestionName;
    }

    public String getIntQuestionUuid() {
        return intQuestionUuid;
    }

    public void setIntQuestionUuid(String intQuestionUuid) {
        this.intQuestionUuid = intQuestionUuid;
    }

    public String getIntQuestionParentUuid() {
        return intQuestionParentUuid;
    }

    public void setIntQuestionParentUuid(String intQuestionParentUuid) {
        this.intQuestionParentUuid = intQuestionParentUuid;
    }

    public String getIntQuestionUsagestatus() {
        return intQuestionUsagestatus;
    }

    public void setIntQuestionUsagestatus(String intQuestionUsagestatus) {
        this.intQuestionUsagestatus = intQuestionUsagestatus;
    }

}
package com.system.survey.model;

import javax.persistence.*;
import java.io.Serializable;


/**
 * The persistent class for the int_question_form_question database table.
 */
@Entity
@Table(name = "int_question_form_question")
@NamedQuery(name = "IntQuestionFormQuestion.findAll", query = "SELECT i FROM IntQuestionFormQuestion i")
public class IntQuestionFormQuestion extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "int_question_form_question_id")
    private int intQuestionFormQuestionId;

    @Column(name = "int_question_form_question_formid")
    private String intQuestionFormQuestionFormid;

    @Column(name = "int_question_form_question_formuuid")
    private String intQuestionFormQuestionFormuuid;

    @Column(name = "int_question_form_question_question_ordenance")
    private Integer intQuestionFormQuestionQuestionOrdenance;

    @Column(name = "int_question_form_question_questionid")
    private String intQuestionFormQuestionQuestionid;

    @Column(name = "int_question_form_question_questionuuid")
    private String intQuestionFormQuestionQuestionuuid;

    @Column(name = "int_question_form_question_uuid")
    private String intQuestionFormQuestionUuid;

    public IntQuestionFormQuestion() {
    }

    public int getIntQuestionFormQuestionId() {
        return this.intQuestionFormQuestionId;
    }

    public void setIntQuestionFormQuestionId(int intQuestionFormQuestionId) {
        this.intQuestionFormQuestionId = intQuestionFormQuestionId;
    }

    public String getIntQuestionFormQuestionFormid() {
        return this.intQuestionFormQuestionFormid;
    }

    public void setIntQuestionFormQuestionFormid(String intQuestionFormQuestionFormid) {
        this.intQuestionFormQuestionFormid = intQuestionFormQuestionFormid;
    }

    public String getIntQuestionFormQuestionFormuuid() {
        return this.intQuestionFormQuestionFormuuid;
    }

    public void setIntQuestionFormQuestionFormuuid(String intQuestionFormQuestionFormuuid) {
        this.intQuestionFormQuestionFormuuid = intQuestionFormQuestionFormuuid;
    }

    public Integer getIntQuestionFormQuestionQuestionOrdenance() {
        return this.intQuestionFormQuestionQuestionOrdenance;
    }

    public void setIntQuestionFormQuestionQuestionOrdenance(Integer intQuestionFormQuestionQuestionOrdenance) {
        this.intQuestionFormQuestionQuestionOrdenance = intQuestionFormQuestionQuestionOrdenance;
    }

    public String getIntQuestionFormQuestionQuestionid() {
        return this.intQuestionFormQuestionQuestionid;
    }

    public void setIntQuestionFormQuestionQuestionid(String intQuestionFormQuestionQuestionid) {
        this.intQuestionFormQuestionQuestionid = intQuestionFormQuestionQuestionid;
    }

    public String getIntQuestionFormQuestionQuestionuuid() {
        return this.intQuestionFormQuestionQuestionuuid;
    }

    public void setIntQuestionFormQuestionQuestionuuid(String intQuestionFormQuestionQuestionuuid) {
        this.intQuestionFormQuestionQuestionuuid = intQuestionFormQuestionQuestionuuid;
    }

    public String getIntQuestionFormQuestionUuid() {
        return this.intQuestionFormQuestionUuid;
    }

    public void setIntQuestionFormQuestionUuid(String intQuestionFormQuestionUuid) {
        this.intQuestionFormQuestionUuid = intQuestionFormQuestionUuid;
    }
}
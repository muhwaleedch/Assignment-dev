package com.system.survey.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.io.Serializable;


/**
 * The persistent class for the int_question_survey_form database table.
 */
@Entity
@Table(name = "int_question_survey_form")
@NamedQuery(name = "IntQuestionSurveyForm.findAll", query = "SELECT i FROM IntQuestionSurveyForm i")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class IntQuestionSurveyForm extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "int_question_survey_form_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int intQuestionSurveyFormId;

    @Column(name = "int_question_survey_form_formid")
    private String intQuestionSurveyFormFormid;

    @Column(name = "int_question_survey_form_formuuid")
    private String intQuestionSurveyFormFormuuid;

    @Column(name = "int_question_survey_form_ordenance")
    private Integer intQuestionSurveyFormOrdenance;

    @Column(name = "int_question_survey_form_questionid")
    private String intQuestionSurveyFormQuestionid;

    @Column(name = "int_question_survey_form_questionuuid")
    private String intQuestionSurveyFormQuestionuuid;

    @Column(name = "int_question_survey_form_surveyid")
    private String intQuestionSurveyFormSurveyid;

    @Column(name = "int_question_survey_form_surveyuuid")
    private String intQuestionSurveyFormSurveyuuid;

    @Column(name = "int_question_survey_form_uuid")
    private String intQuestionSurveyFormUuid;

    public IntQuestionSurveyForm() {
    }

    public int getIntQuestionSurveyFormId() {
        return intQuestionSurveyFormId;
    }

    public void setIntQuestionSurveyFormId(int intQuestionSurveyFormId) {
        this.intQuestionSurveyFormId = intQuestionSurveyFormId;
    }

    public String getIntQuestionSurveyFormFormid() {
        return intQuestionSurveyFormFormid;
    }

    public void setIntQuestionSurveyFormFormid(String intQuestionSurveyFormFormid) {
        this.intQuestionSurveyFormFormid = intQuestionSurveyFormFormid;
    }

    public String getIntQuestionSurveyFormFormuuid() {
        return intQuestionSurveyFormFormuuid;
    }

    public void setIntQuestionSurveyFormFormuuid(String intQuestionSurveyFormFormuuid) {
        this.intQuestionSurveyFormFormuuid = intQuestionSurveyFormFormuuid;
    }

    public Integer getIntQuestionSurveyFormOrdenance() {
        return intQuestionSurveyFormOrdenance;
    }

    public void setIntQuestionSurveyFormOrdenance(Integer intQuestionSurveyFormOrdenance) {
        this.intQuestionSurveyFormOrdenance = intQuestionSurveyFormOrdenance;
    }

    public String getIntQuestionSurveyFormQuestionid() {
        return intQuestionSurveyFormQuestionid;
    }

    public void setIntQuestionSurveyFormQuestionid(String intQuestionSurveyFormQuestionid) {
        this.intQuestionSurveyFormQuestionid = intQuestionSurveyFormQuestionid;
    }

    public String getIntQuestionSurveyFormQuestionuuid() {
        return intQuestionSurveyFormQuestionuuid;
    }

    public void setIntQuestionSurveyFormQuestionuuid(String intQuestionSurveyFormQuestionuuid) {
        this.intQuestionSurveyFormQuestionuuid = intQuestionSurveyFormQuestionuuid;
    }

    public String getIntQuestionSurveyFormSurveyid() {
        return intQuestionSurveyFormSurveyid;
    }

    public void setIntQuestionSurveyFormSurveyid(String intQuestionSurveyFormSurveyid) {
        this.intQuestionSurveyFormSurveyid = intQuestionSurveyFormSurveyid;
    }

    public String getIntQuestionSurveyFormSurveyuuid() {
        return intQuestionSurveyFormSurveyuuid;
    }

    public void setIntQuestionSurveyFormSurveyuuid(String intQuestionSurveyFormSurveyuuid) {
        this.intQuestionSurveyFormSurveyuuid = intQuestionSurveyFormSurveyuuid;
    }

    public String getIntQuestionSurveyFormUuid() {
        return intQuestionSurveyFormUuid;
    }

    public void setIntQuestionSurveyFormUuid(String intQuestionSurveyFormUuid) {
        this.intQuestionSurveyFormUuid = intQuestionSurveyFormUuid;
    }

}
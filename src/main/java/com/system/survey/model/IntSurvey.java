package com.system.survey.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.io.Serializable;


/**
 * The persistent class for the int_survey database table.
 */
@Entity
@Table(name = "int_survey")
@NamedQuery(name = "IntSurvey.findAll", query = "SELECT i FROM IntSurvey i")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class IntSurvey extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "int_survey_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int intSurveyId;

    @Column(name = "int_survey_desc")
    private String intSurveyDesc;

    @Column(name = "int_survey_name")
    private String intSurveyName;

    @Column(name = "int_survey_shortdesc")
    private String intSurveyShortdesc;

    @Column(name = "int_survey_uuid")
    private String intSurveyUuid;


    public IntSurvey() {
    }


    public int getIntSurveyId() {
        return intSurveyId;
    }


    public void setIntSurveyId(int intSurveyId) {
        this.intSurveyId = intSurveyId;
    }


    public String getIntSurveyDesc() {
        return intSurveyDesc;
    }


    public void setIntSurveyDesc(String intSurveyDesc) {
        this.intSurveyDesc = intSurveyDesc;
    }


    public String getIntSurveyName() {
        return intSurveyName;
    }


    public void setIntSurveyName(String intSurveyName) {
        this.intSurveyName = intSurveyName;
    }


    public String getIntSurveyShortdesc() {
        return intSurveyShortdesc;
    }


    public void setIntSurveyShortdesc(String intSurveyShortdesc) {
        this.intSurveyShortdesc = intSurveyShortdesc;
    }


    public String getIntSurveyUuid() {
        return intSurveyUuid;
    }


    public void setIntSurveyUuid(String intSurveyUuid) {
        this.intSurveyUuid = intSurveyUuid;
    }

}
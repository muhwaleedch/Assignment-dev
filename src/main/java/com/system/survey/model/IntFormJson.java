package com.system.survey.model;

import javax.persistence.*;
import java.io.Serializable;


/**
 * The persistent class for the int_form_Json database table.
 */
@Entity
@Table(name = "int_form_Json")
public class IntFormJson extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "int_form_Json_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int intFormJsonId;

    @Column(name = "int_form_Json_formid")
    private String intFormJsonFormid;

    @Column(name = "int_form_Json_formuuid")
    private String intFormJsonFormuuid;

    @Lob
    @Column(name = "int_form_Json_string")
    private byte[] intFormJsonString;

    @Column(name = "int_form_Json_submittimes")
    private String intFormJsonSubmittimes;

    @Column(name = "int_form_Json_surveyid")
    private String intFormJsonSurveyid;

    @Column(name = "int_form_Json_surveyuuid")
    private String intFormJsonSurveyuuid;

    @Column(name = "int_form_Json_useruuid")
    private String intFormJsonUseruuid;

    @Column(name = "int_form_Json_uuid")
    private String intFormJsonUuid;

    @Column(name = "int_form_Json_formDefaultname")
    private String intFormJsonFormDefaultName;

    public IntFormJson() {
    }

    public int getIntFormJsonId() {
        return intFormJsonId;
    }

    public void setIntFormJsonId(int intFormJsonId) {
        this.intFormJsonId = intFormJsonId;
    }

    public String getIntFormJsonFormid() {
        return intFormJsonFormid;
    }

    public void setIntFormJsonFormid(String intFormJsonFormid) {
        this.intFormJsonFormid = intFormJsonFormid;
    }

    public String getIntFormJsonFormuuid() {
        return intFormJsonFormuuid;
    }

    public void setIntFormJsonFormuuid(String intFormJsonFormuuid) {
        this.intFormJsonFormuuid = intFormJsonFormuuid;
    }

    public byte[] getIntFormJsonString() {
        return intFormJsonString;
    }

    public void setIntFormJsonString(byte[] intFormJsonString) {
        this.intFormJsonString = intFormJsonString;
    }

    public String getIntFormJsonSubmittimes() {
        return intFormJsonSubmittimes;
    }

    public void setIntFormJsonSubmittimes(String intFormJsonSubmittimes) {
        this.intFormJsonSubmittimes = intFormJsonSubmittimes;
    }

    public String getIntFormJsonSurveyid() {
        return intFormJsonSurveyid;
    }

    public void setIntFormJsonSurveyid(String intFormJsonSurveyid) {
        this.intFormJsonSurveyid = intFormJsonSurveyid;
    }

    public String getIntFormJsonSurveyuuid() {
        return intFormJsonSurveyuuid;
    }

    public void setIntFormJsonSurveyuuid(String intFormJsonSurveyuuid) {
        this.intFormJsonSurveyuuid = intFormJsonSurveyuuid;
    }

    public String getIntFormJsonUseruuid() {
        return intFormJsonUseruuid;
    }

    public void setIntFormJsonUseruuid(String intFormJsonUseruuid) {
        this.intFormJsonUseruuid = intFormJsonUseruuid;
    }

    public String getIntFormJsonUuid() {
        return intFormJsonUuid;
    }

    public void setIntFormJsonUuid(String intFormJsonUuid) {
        this.intFormJsonUuid = intFormJsonUuid;
    }

    public String getIntFormJsonFormDefaultName() {
        return intFormJsonFormDefaultName;
    }

    public void setIntFormJsonFormDefaultName(String intFormJsonFormDefaultName) {
        this.intFormJsonFormDefaultName = intFormJsonFormDefaultName;
    }

}
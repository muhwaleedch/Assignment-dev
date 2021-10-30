package com.system.survey.dto.survey;

import java.io.Serializable;


/**
 * The persistent class for the int_form_Json database table.
 */
public class IntFormJsonDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private int intFormJsonId;

    private String intFormJsonFormid;

    private String intFormJsonFormuuid;

    private byte[] intFormJsonString;

    private String intFormJsonSubmittimes;

    private String intFormJsonSurveyid;

    private String intFormJsonSurveyuuid;

    private String intFormJsonUseruuid;

    private String intFormJsonUuid;

    private String intFormJsonFormDefaultName;

    public IntFormJsonDto() {
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
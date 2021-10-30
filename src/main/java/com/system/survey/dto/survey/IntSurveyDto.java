package com.system.survey.dto.survey;

import com.system.survey.enums.ActiveStatus;

import java.util.List;

public class IntSurveyDto {

    List<IntFormDto> formDtos = null;
    private int intSurveyId;
    private String intSurveyDesc;
    private String intSurveyName;
    private String intSurveyShortdesc;
    private String intSurveyUuid;
    private ActiveStatus activeStatus;

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


    public ActiveStatus getActiveStatus() {
        return activeStatus;
    }


    public void setActiveStatus(ActiveStatus activeStatus) {
        this.activeStatus = activeStatus;
    }


    public List<IntFormDto> getFormDtos() {
        return formDtos;
    }


    public void setFormDtos(List<IntFormDto> formDtos) {
        this.formDtos = formDtos;
    }

}

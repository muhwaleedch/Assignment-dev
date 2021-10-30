package com.system.survey.dto.survey;

import com.system.survey.enums.ActiveStatus;

import java.util.List;

public class IntFormDto {

    private int intFormId;

    private String intFormDesc;

    private String intFormName;

    private String intFormShortdesc;

    private String intFormUuid;

    private ActiveStatus activeStatus;

    private String intFormPageNoOfQuestions;

    private List<String> surveyUuids;

    public int getIntFormId() {
        return intFormId;
    }


    public void setIntFormId(int intFormId) {
        this.intFormId = intFormId;
    }


    public String getIntFormDesc() {
        return intFormDesc;
    }


    public void setIntFormDesc(String intFormDesc) {
        this.intFormDesc = intFormDesc;
    }


    public String getIntFormName() {
        return intFormName;
    }


    public void setIntFormName(String intFormName) {
        this.intFormName = intFormName;
    }


    public String getIntFormShortdesc() {
        return intFormShortdesc;
    }


    public void setIntFormShortdesc(String intFormShortdesc) {
        this.intFormShortdesc = intFormShortdesc;
    }


    public String getIntFormUuid() {
        return intFormUuid;
    }


    public void setIntFormUuid(String intFormUuid) {
        this.intFormUuid = intFormUuid;
    }


    public ActiveStatus getActiveStatus() {
        return activeStatus;
    }


    public void setActiveStatus(ActiveStatus activeStatus) {
        this.activeStatus = activeStatus;
    }


    public String getIntFormPageNoOfQuestions() {
        return intFormPageNoOfQuestions;
    }


    public void setIntFormPageNoOfQuestions(String intFormPageNoOfQuestions) {
        this.intFormPageNoOfQuestions = intFormPageNoOfQuestions;
    }


    public List<String> getSurveyUuids() {
        return surveyUuids;
    }


    public void setSurveyUuids(List<String> surveyUuids) {
        this.surveyUuids = surveyUuids;
    }
}

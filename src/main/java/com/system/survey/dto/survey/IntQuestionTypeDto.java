package com.system.survey.dto.survey;

/**
 * The persistent class for the int_question_type database table.
 */
public class IntQuestionTypeDto {

    private int intQuestionTypeId;

    private String intQuestionTypeDesc;

    private String intQuestionTypeName;

    private String intQuestionTypeShortdesc;

    private String intQuestionTypeUuid;

    public IntQuestionTypeDto() {
    }

    public int getIntQuestionTypeId() {
        return intQuestionTypeId;
    }

    public void setIntQuestionTypeId(int intQuestionTypeId) {
        this.intQuestionTypeId = intQuestionTypeId;
    }

    public String getIntQuestionTypeDesc() {
        return intQuestionTypeDesc;
    }

    public void setIntQuestionTypeDesc(String intQuestionTypeDesc) {
        this.intQuestionTypeDesc = intQuestionTypeDesc;
    }

    public String getIntQuestionTypeName() {
        return intQuestionTypeName;
    }

    public void setIntQuestionTypeName(String intQuestionTypeName) {
        this.intQuestionTypeName = intQuestionTypeName;
    }

    public String getIntQuestionTypeShortdesc() {
        return intQuestionTypeShortdesc;
    }

    public void setIntQuestionTypeShortdesc(String intQuestionTypeShortdesc) {
        this.intQuestionTypeShortdesc = intQuestionTypeShortdesc;
    }

    public String getIntQuestionTypeUuid() {
        return intQuestionTypeUuid;
    }

    public void setIntQuestionTypeUuid(String intQuestionTypeUuid) {
        this.intQuestionTypeUuid = intQuestionTypeUuid;
    }

}
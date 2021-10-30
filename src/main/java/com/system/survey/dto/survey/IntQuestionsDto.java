package com.system.survey.dto.survey;

import java.util.List;

public class IntQuestionsDto {

    private int intQuestionId;

    private byte[] intQuestionBlob;

    private String intQuestionCompletequestion;

    private String intQuestionIntQuestionTypeid;

    private String intQuestionIntQuestionTypeuuid;

    private String intQuestionName;

    private String intQuestionUuid;

    private List<IntQuestionsAnsweroptionDto> intQuestionsAnswerOptionDtos;

    private List<IntQuestionUserreplyDto> intQuestionUserReplies;

    private IntQuestionAttachDto intQuestionAttachDto;

    private String questionType;

    private List<IntQuestionsDto> subQuestions;

    private List<String> formsUuid;

    private String intQuestionParentUuid;

    private String intQuestionUsagestatus;

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

    public List<IntQuestionsAnsweroptionDto> getIntQuestionsAnswerOptionDtos() {
        return intQuestionsAnswerOptionDtos;
    }

    public void setIntQuestionsAnswerOptionDtos(List<IntQuestionsAnsweroptionDto> intQuestionsAnswerDtos) {
        this.intQuestionsAnswerOptionDtos = intQuestionsAnswerDtos;
    }

    public String getQuestionType() {
        return questionType;
    }

    public void setQuestionType(String questionType) {
        this.questionType = questionType;
    }

    public List<IntQuestionUserreplyDto> getIntQuestionUserReplies() {
        return intQuestionUserReplies;
    }

    public void setIntQuestionUserReplies(List<IntQuestionUserreplyDto> intQuestionUserReplies) {
        this.intQuestionUserReplies = intQuestionUserReplies;
    }

    public IntQuestionAttachDto getIntQuestionAttachDto() {
        return intQuestionAttachDto;
    }

    public void setIntQuestionAttachDto(IntQuestionAttachDto intQuestionAttachDto) {
        this.intQuestionAttachDto = intQuestionAttachDto;
    }

    public List<IntQuestionsDto> getSubQuestions() {
        return subQuestions;
    }

    public void setSubQuestions(List<IntQuestionsDto> subQuestions) {
        this.subQuestions = subQuestions;
    }

    public List<String> getFormsUuid() {
        return formsUuid;
    }

    public void setFormsUuid(List<String> formsUuid) {
        this.formsUuid = formsUuid;
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

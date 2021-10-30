package com.system.survey.dto.survey;

import java.io.Serializable;


/**
 * The persistent class for the int_question_userreply database table.
 */
public class IntQuestionUserreplyDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long intQuestionUserreplyId;

    private String intQuestionUserreplyQuestionId;

    private String intQuestionUserreplyQuestionUuid;

    private String intQuestionUserreplyReply;

    private String intQuestionUserreplyUserId;

    private String intQuestionUserreplyUserUuid;

    private String intQuestionUserreplyUuid;

    public IntQuestionUserreplyDto() {
    }

    public Long getIntQuestionUserreplyId() {
        return this.intQuestionUserreplyId;
    }

    public void setIntQuestionUserreplyId(Long intQuestionUserreplyId) {
        this.intQuestionUserreplyId = intQuestionUserreplyId;
    }

    public String getIntQuestionUserreplyQuestionId() {
        return this.intQuestionUserreplyQuestionId;
    }

    public void setIntQuestionUserreplyQuestionId(String intQuestionUserreplyQuestionId) {
        this.intQuestionUserreplyQuestionId = intQuestionUserreplyQuestionId;
    }

    public String getIntQuestionUserreplyQuestionUuid() {
        return this.intQuestionUserreplyQuestionUuid;
    }

    public void setIntQuestionUserreplyQuestionUuid(String intQuestionUserreplyQuestionUuid) {
        this.intQuestionUserreplyQuestionUuid = intQuestionUserreplyQuestionUuid;
    }

    public String getIntQuestionUserreplyReply() {
        return this.intQuestionUserreplyReply;
    }

    public void setIntQuestionUserreplyReply(String intQuestionUserreplyReply) {
        this.intQuestionUserreplyReply = intQuestionUserreplyReply;
    }

    public String getIntQuestionUserreplyUserId() {
        return this.intQuestionUserreplyUserId;
    }

    public void setIntQuestionUserreplyUserId(String intQuestionUserreplyUserId) {
        this.intQuestionUserreplyUserId = intQuestionUserreplyUserId;
    }

    public String getIntQuestionUserreplyUserUuid() {
        return this.intQuestionUserreplyUserUuid;
    }

    public void setIntQuestionUserreplyUserUuid(String intQuestionUserreplyUserUuid) {
        this.intQuestionUserreplyUserUuid = intQuestionUserreplyUserUuid;
    }

    public String getIntQuestionUserreplyUuid() {
        return this.intQuestionUserreplyUuid;
    }

    public void setIntQuestionUserreplyUuid(String intQuestionUserreplyUuid) {
        this.intQuestionUserreplyUuid = intQuestionUserreplyUuid;
    }

}
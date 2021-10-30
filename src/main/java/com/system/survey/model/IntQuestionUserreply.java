package com.system.survey.model;

import javax.persistence.*;
import java.io.Serializable;


/**
 * The persistent class for the int_question_userreply database table.
 */
@Entity
@Table(name = "int_question_userreply")
@NamedQuery(name = "IntQuestionUserreply.findAll", query = "SELECT i FROM IntQuestionUserreply i")
public class IntQuestionUserreply extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "int_question_userreply_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long intQuestionUserreplyId;

    @Column(name = "int_question_userreply_question_id")
    private String intQuestionUserreplyQuestionId;

    @Column(name = "int_question_userreply_question_uuid")
    private String intQuestionUserreplyQuestionUuid;

    @Column(name = "int_question_userreply_reply")
    private String intQuestionUserreplyReply;

    @Column(name = "int_question_userreply_user_id")
    private String intQuestionUserreplyUserId;

    @Column(name = "int_question_userreply_user_uuid")
    private String intQuestionUserreplyUserUuid;

    @Column(name = "int_question_userreply_uuid")
    private String intQuestionUserreplyUuid;

    public IntQuestionUserreply() {
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
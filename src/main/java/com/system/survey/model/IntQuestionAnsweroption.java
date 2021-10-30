package com.system.survey.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.io.Serializable;


/**
 * The persistent class for the int_question_answeroption database table.
 */
@Entity
@Table(name = "int_question_answeroption")
@NamedQuery(name = "IntQuestionAnsweroption.findAll", query = "SELECT i FROM IntQuestionAnsweroption i")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class IntQuestionAnsweroption extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "int_question_answeroption_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int intQuestionAnsweroptionId;

    @Column(name = "int_question_answeroption_answer")
    private String intQuestionAnsweroptionAnswer;

    @Column(name = "int_question_answeroption_int_question_id")
    private String intQuestionAnsweroptionIntQuestionId;

    @Column(name = "int_question_answeroption_int_question_uuid")
    private String intQuestionAnsweroptionIntQuestionUuid;

    @Column(name = "int_question_answeroption_uuid")
    private String intQuestionAnsweroptionUuid;

    public IntQuestionAnsweroption() {
    }

    public int getIntQuestionAnsweroptionId() {
        return intQuestionAnsweroptionId;
    }

    public void setIntQuestionAnsweroptionId(int intQuestionAnsweroptionId) {
        this.intQuestionAnsweroptionId = intQuestionAnsweroptionId;
    }

    public String getIntQuestionAnsweroptionAnswer() {
        return intQuestionAnsweroptionAnswer;
    }

    public void setIntQuestionAnsweroptionAnswer(String intQuestionAnsweroptionAnswer) {
        this.intQuestionAnsweroptionAnswer = intQuestionAnsweroptionAnswer;
    }

    public String getIntQuestionAnsweroptionIntQuestionId() {
        return intQuestionAnsweroptionIntQuestionId;
    }

    public void setIntQuestionAnsweroptionIntQuestionId(String intQuestionAnsweroptionIntQuestionId) {
        this.intQuestionAnsweroptionIntQuestionId = intQuestionAnsweroptionIntQuestionId;
    }

    public String getIntQuestionAnsweroptionIntQuestionUuid() {
        return intQuestionAnsweroptionIntQuestionUuid;
    }

    public void setIntQuestionAnsweroptionIntQuestionUuid(String intQuestionAnsweroptionIntQuestionUuid) {
        this.intQuestionAnsweroptionIntQuestionUuid = intQuestionAnsweroptionIntQuestionUuid;
    }

    public String getIntQuestionAnsweroptionUuid() {
        return intQuestionAnsweroptionUuid;
    }

    public void setIntQuestionAnsweroptionUuid(String intQuestionAnsweroptionUuid) {
        this.intQuestionAnsweroptionUuid = intQuestionAnsweroptionUuid;
    }

}
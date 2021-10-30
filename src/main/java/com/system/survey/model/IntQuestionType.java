package com.system.survey.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.io.Serializable;


/**
 * The persistent class for the int_question_type database table.
 */
@Entity
@Table(name = "int_question_type")
@NamedQuery(name = "IntQuestionType.findAll", query = "SELECT i FROM IntQuestionType i")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class IntQuestionType extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "int_question_type_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int intQuestionTypeId;

    @Column(name = "int_question_type_desc")
    private String intQuestionTypeDesc;

    @Column(name = "int_question_type_name")
    private String intQuestionTypeName;

    @Column(name = "int_question_type_shortdesc")
    private String intQuestionTypeShortdesc;

    @Column(name = "int_question_type_uuid")
    private String intQuestionTypeUuid;

    public IntQuestionType() {
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
package com.system.survey.model;

import javax.persistence.*;
import java.io.Serializable;


/**
 * The persistent class for the int_question_attach_type database table.
 */
@Entity
@Table(name = "int_question_attach_type")
@NamedQuery(name = "IntQuestionAttachType.findAll", query = "SELECT i FROM IntQuestionAttachType i")
public class IntQuestionAttachType extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "int_question_attach_type_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int intQuestionAttachTypeId;

    @Column(name = "int_question_attach_type_desc")
    private String intQuestionAttachTypeDesc;

    @Column(name = "int_question_attach_type_name")
    private String intQuestionAttachTypeName;

    @Column(name = "int_question_attach_type_shortdesc")
    private String intQuestionAttachTypeShortdesc;

    @Column(name = "int_question_attach_type_uuid")
    private String intQuestionAttachTypeUuid;

    public IntQuestionAttachType() {
    }

    public int getIntQuestionAttachTypeId() {
        return this.intQuestionAttachTypeId;
    }

    public void setIntQuestionAttachTypeId(int intQuestionAttachTypeId) {
        this.intQuestionAttachTypeId = intQuestionAttachTypeId;
    }

    public String getIntQuestionAttachTypeDesc() {
        return this.intQuestionAttachTypeDesc;
    }

    public void setIntQuestionAttachTypeDesc(String intQuestionAttachTypeDesc) {
        this.intQuestionAttachTypeDesc = intQuestionAttachTypeDesc;
    }

    public String getIntQuestionAttachTypeName() {
        return this.intQuestionAttachTypeName;
    }

    public void setIntQuestionAttachTypeName(String intQuestionAttachTypeName) {
        this.intQuestionAttachTypeName = intQuestionAttachTypeName;
    }

    public String getIntQuestionAttachTypeShortdesc() {
        return this.intQuestionAttachTypeShortdesc;
    }

    public void setIntQuestionAttachTypeShortdesc(String intQuestionAttachTypeShortdesc) {
        this.intQuestionAttachTypeShortdesc = intQuestionAttachTypeShortdesc;
    }

    public String getIntQuestionAttachTypeUuid() {
        return this.intQuestionAttachTypeUuid;
    }

    public void setIntQuestionAttachTypeUuid(String intQuestionAttachTypeUuid) {
        this.intQuestionAttachTypeUuid = intQuestionAttachTypeUuid;
    }

}
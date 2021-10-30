package com.system.survey.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.io.Serializable;


/**
 * The persistent class for the int_form database table.
 */
@Entity
@Table(name = "int_form")
@NamedQuery(name = "IntForm.findAll", query = "SELECT i FROM IntForm i")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class IntForm extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "int_form_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int intFormId;

    @Column(name = "int_form_desc")
    private String intFormDesc;

    @Column(name = "int_form_name")
    private String intFormName;

    @Column(name = "int_form_shortdesc")
    private String intFormShortdesc;

    @Column(name = "int_form_uuid")
    private String intFormUuid;

    @Column(name = "int_form_pageNoOfQuestions")
    private String intFormPageNoOfQuestions;


    public IntForm() {
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

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

    public String getIntFormPageNoOfQuestions() {
        return intFormPageNoOfQuestions;
    }


    public void setIntFormPageNoOfQuestions(String intFormPageNoOfQuestions) {
        this.intFormPageNoOfQuestions = intFormPageNoOfQuestions;
    }

}
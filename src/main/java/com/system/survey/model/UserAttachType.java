package com.system.survey.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;

@Entity
@Table(name = "user_attach_type")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserAttachType extends BaseEntity {

    @Id
    @Column(name = "user_attach_type_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userAttachTypeId;

    @Column(name = "user_attach_type_uuid")
    private String userAttachTypeUuid;

    @Column(name = "user_attach_type_name")
    private String userAttachTypeName;

    @Column(name = "user_attach_type_shortdesc")
    private String userAttachTypeShortDesc;

    @Column(name = "user_attach_type_desc")
    private String userAttachTypeDesc;

    public Long getUserAttachTypeId() {
        return userAttachTypeId;
    }

    public void setUserAttachTypeId(Long userAttachTypeId) {
        this.userAttachTypeId = userAttachTypeId;
    }

    public String getUserAttachTypeUuid() {
        return userAttachTypeUuid;
    }

    public void setUserAttachTypeUuid(String userAttachTypeUuid) {
        this.userAttachTypeUuid = userAttachTypeUuid;
    }

    public String getUserAttachTypeName() {
        return userAttachTypeName;
    }

    public void setUserAttachTypeName(String userAttachTypeName) {
        this.userAttachTypeName = userAttachTypeName;
    }

    public String getUserAttachTypeShortDesc() {
        return userAttachTypeShortDesc;
    }

    public void setUserAttachTypeShortDesc(String userAttachTypeShortDesc) {
        this.userAttachTypeShortDesc = userAttachTypeShortDesc;
    }

    public String getUserAttachTypeDesc() {
        return userAttachTypeDesc;
    }

    public void setUserAttachTypeDesc(String userAttachTypeDesc) {
        this.userAttachTypeDesc = userAttachTypeDesc;
    }

}

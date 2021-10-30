package com.system.survey.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;

@Entity
@Table(name = "user_type")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserType {

    @Id
    @Column(name = "user_type_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userTypeId;

    @Column(name = "user_type_uuid")
    private String userTypeUuid;

    @Column(name = "user_type_desc")
    private String userTypeDesc;

    @Column(name = "user_type_name")
    private String userTypeName;

    @Column(name = "user_type_shortDescription")
    private String userTypeShortDescription;

    public Long getUserTypeId() {
        return userTypeId;
    }

    public void setUserTypeId(Long userTypeId) {
        this.userTypeId = userTypeId;
    }

    public String getUserTypeUuid() {
        return userTypeUuid;
    }

    public void setUserTypeUuid(String userTypeUuid) {
        this.userTypeUuid = userTypeUuid;
    }

    public String getUserTypeDesc() {
        return userTypeDesc;
    }

    public void setUserTypeDesc(String userTypeDesc) {
        this.userTypeDesc = userTypeDesc;
    }

    public String getUserTypeName() {
        return userTypeName;
    }

    public void setUserTypeName(String userTypeName) {
        this.userTypeName = userTypeName;
    }

    public String getUserTypeShortDescription() {
        return userTypeShortDescription;
    }

    public void setUserTypeShortDescription(String userTypeShortDescription) {
        this.userTypeShortDescription = userTypeShortDescription;
    }

}

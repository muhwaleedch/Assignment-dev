package com.system.survey.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.Gson;

import javax.persistence.*;


@Entity
@Table(name = "organization")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Organization extends BaseEntity {

    @Id
    @Column(name = "organisation_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long organisationId;

    @Column(name = "organization_uuid", nullable = false)
    private String organizationUuid;

    @Column(name = "organization_name")
    private String organizationName;

    @Column(name = "organization_shortdescription")
    private String organizationShortDescription;

    @Column(name = "organization_description")
    private String organizationDescription;

    public Organization() {
    }

    public Long getOrganisationId() {
        return organisationId;
    }

    public void setOrganisationId(Long organisationId) {
        this.organisationId = organisationId;
    }

    public String getOrganizationUuid() {
        return organizationUuid;
    }

    public void setOrganizationUuid(String organizationUuid) {
        this.organizationUuid = organizationUuid;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getOrganizationShortDescription() {
        return organizationShortDescription;
    }

    public void setOrganizationShortDescription(String organizationShortDescription) {
        this.organizationShortDescription = organizationShortDescription;
    }

    public String getOrganizationDescription() {
        return organizationDescription;
    }

    public void setOrganizationDescription(String organizationDescription) {
        this.organizationDescription = organizationDescription;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}

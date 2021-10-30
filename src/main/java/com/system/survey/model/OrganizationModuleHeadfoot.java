package com.system.survey.model;

import javax.persistence.*;
import java.io.Serializable;


/**
 * The persistent class for the organization_module_Headfoot database table.
 */
@Entity
@Table(name = "organization_module_Headfoot")
public class OrganizationModuleHeadfoot extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "organization_module_Headfoot_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int organizationModuleHeadfootId;

    @Column(name = "organization_module_Headfoot_desc")
    private String organizationModuleHeadfootDesc;

    @Lob
    @Column(name = "organization_module_Headfoot_footer")
    private byte[] organizationModuleHeadfootFooter;

    @Lob
    @Column(name = "organization_module_Headfoot_header")
    private byte[] organizationModuleHeadfootHeader;

    @Column(name = "organization_module_Headfoot_module_id")
    private String organizationModuleHeadfootModuleId;

    @Column(name = "organization_module_Headfoot_module_uuid")
    private String organizationModuleHeadfootModuleUuid;

    @Column(name = "organization_module_Headfoot_name")
    private String organizationModuleHeadfootName;

    @Column(name = "organization_module_Headfoot_orgName")
    private String organizationModuleHeadfootOrgName;

    @Column(name = "organization_module_Headfoot_orguuid")
    private String organizationModuleHeadfootOrguuid;

    @Lob
    @Column(name = "organization_module_Headfoot_outputlogo")
    private byte[] organizationModuleHeadfootOutputLogo;

    @Column(name = "organization_module_Headfoot_outputtype")
    private String organizationModuleHeadfootOutputType;

    @Column(name = "organization_module_Headfoot_uuid")
    private String organizationModuleHeadfootUuid;

    @Column(name = "organization_module_Headfootcol_module_name")
    private String organizationModuleHeadfootcolModuleName;

    public OrganizationModuleHeadfoot() {
    }

    public int getOrganizationModuleHeadfootId() {
        return organizationModuleHeadfootId;
    }

    public void setOrganizationModuleHeadfootId(int organizationModuleHeadfootId) {
        this.organizationModuleHeadfootId = organizationModuleHeadfootId;
    }

    public String getOrganizationModuleHeadfootDesc() {
        return organizationModuleHeadfootDesc;
    }

    public void setOrganizationModuleHeadfootDesc(String organizationModuleHeadfootDesc) {
        this.organizationModuleHeadfootDesc = organizationModuleHeadfootDesc;
    }

    public byte[] getOrganizationModuleHeadfootFooter() {
        return organizationModuleHeadfootFooter;
    }

    public void setOrganizationModuleHeadfootFooter(byte[] organizationModuleHeadfootFooter) {
        this.organizationModuleHeadfootFooter = organizationModuleHeadfootFooter;
    }

    public byte[] getOrganizationModuleHeadfootHeader() {
        return organizationModuleHeadfootHeader;
    }

    public void setOrganizationModuleHeadfootHeader(byte[] organizationModuleHeadfootHeader) {
        this.organizationModuleHeadfootHeader = organizationModuleHeadfootHeader;
    }

    public String getOrganizationModuleHeadfootModuleId() {
        return organizationModuleHeadfootModuleId;
    }

    public void setOrganizationModuleHeadfootModuleId(String organizationModuleHeadfootModuleId) {
        this.organizationModuleHeadfootModuleId = organizationModuleHeadfootModuleId;
    }

    public String getOrganizationModuleHeadfootModuleUuid() {
        return organizationModuleHeadfootModuleUuid;
    }

    public void setOrganizationModuleHeadfootModuleUuid(String organizationModuleHeadfootModuleUuid) {
        this.organizationModuleHeadfootModuleUuid = organizationModuleHeadfootModuleUuid;
    }

    public String getOrganizationModuleHeadfootName() {
        return organizationModuleHeadfootName;
    }

    public void setOrganizationModuleHeadfootName(String organizationModuleHeadfootName) {
        this.organizationModuleHeadfootName = organizationModuleHeadfootName;
    }

    public String getOrganizationModuleHeadfootOrgName() {
        return organizationModuleHeadfootOrgName;
    }

    public void setOrganizationModuleHeadfootOrgName(String organizationModuleHeadfootOrgName) {
        this.organizationModuleHeadfootOrgName = organizationModuleHeadfootOrgName;
    }

    public String getOrganizationModuleHeadfootOrguuid() {
        return organizationModuleHeadfootOrguuid;
    }

    public void setOrganizationModuleHeadfootOrguuid(String organizationModuleHeadfootOrguuid) {
        this.organizationModuleHeadfootOrguuid = organizationModuleHeadfootOrguuid;
    }

    public byte[] getOrganizationModuleHeadfootOutputLogo() {
        return organizationModuleHeadfootOutputLogo;
    }

    public void setOrganizationModuleHeadfootOutputLogo(byte[] organizationModuleHeadfootOutputLogo) {
        this.organizationModuleHeadfootOutputLogo = organizationModuleHeadfootOutputLogo;
    }

    public String getOrganizationModuleHeadfootOutputType() {
        return organizationModuleHeadfootOutputType;
    }

    public void setOrganizationModuleHeadfootOutputType(String organizationModuleHeadfootOutputType) {
        this.organizationModuleHeadfootOutputType = organizationModuleHeadfootOutputType;
    }

    public String getOrganizationModuleHeadfootUuid() {
        return organizationModuleHeadfootUuid;
    }

    public void setOrganizationModuleHeadfootUuid(String organizationModuleHeadfootUuid) {
        this.organizationModuleHeadfootUuid = organizationModuleHeadfootUuid;
    }

    public String getOrganizationModuleHeadfootcolModuleName() {
        return organizationModuleHeadfootcolModuleName;
    }

    public void setOrganizationModuleHeadfootcolModuleName(String organizationModuleHeadfootcolModuleName) {
        this.organizationModuleHeadfootcolModuleName = organizationModuleHeadfootcolModuleName;
    }

}
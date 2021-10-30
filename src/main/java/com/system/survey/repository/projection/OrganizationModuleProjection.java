package com.system.survey.repository.projection;

import java.util.UUID;

public interface OrganizationModuleProjection {

    public Long getOrganizationModuleId();

    public String getOrganizationModuleUuid();

    public Long getOrganisationId();

    public UUID getOrganizationUuid();

    public String getOrganizationName();

    public String getOrganizationShortDescription();

    public String getOrganizationDescription();

    public Long getModulesLookupId();

    public UUID getModulesLookupUuid();

    public String getModulesLookupNumber();

    public String getModulesLookupShortDescription();

    public String getModulesLookupName();

    public String getModulesLookupDescription();

}

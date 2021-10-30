package com.system.survey.repository.projection;

import com.system.survey.enums.ActiveStatus;

import java.sql.Timestamp;

public interface UserOrganizationMappingProjection {

    public Long getId();

    public String getOrgId();

    public String getUserId();

    public Timestamp getUpdatedDts();

    public Timestamp getCreatedDts();

    public ActiveStatus getActiveStatus();
}

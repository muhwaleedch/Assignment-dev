package com.system.survey.repository.projection;

import com.system.survey.enums.ActiveStatus;

import java.sql.Timestamp;

public interface UserGroupMappingProjection {

    public Long getId();

    public String getGroupId();

    public String getUserId();

    public Timestamp getCreatedDts();

    public ActiveStatus getActiveStatus();

    public Timestamp getUpdatedDts();
}

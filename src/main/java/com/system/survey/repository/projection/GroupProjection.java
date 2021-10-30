package com.system.survey.repository.projection;

import com.system.survey.enums.ActiveStatus;

import java.sql.Timestamp;

public interface GroupProjection {

    public Long getGroupId();

    public String getGroupUuid();

    public String getGroupName();

    public String getGroupShortName();

    public String getGroupDesc();

    public Timestamp getCreatedDts();

    public String getCreatedBy();

    public ActiveStatus getActiveStatus();

    public String getUpdatedBy();

    public Timestamp getUpdatedDts();

}

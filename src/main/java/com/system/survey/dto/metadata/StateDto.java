package com.system.survey.dto.metadata;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StateDto {

    private Long statesId;

    private String statesUuid;

    private String name;

    public Long getStatesId() {
        return statesId;
    }

    public void setStatesId(Long statesId) {
        this.statesId = statesId;
    }

    public String getStatesUuid() {
        return statesUuid;
    }

    public void setStatesUuid(String statesUuid) {
        this.statesUuid = statesUuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

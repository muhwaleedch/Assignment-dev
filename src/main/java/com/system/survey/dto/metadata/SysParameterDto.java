package com.system.survey.dto.metadata;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.Gson;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SysParameterDto {

    private Long systemParameterId;

    private String sysParameterUuid;

    private String sysParameterName;

    private String sysParameterValue;

    public Long getSystemParameterId() {
        return systemParameterId;
    }

    public void setSystemParameterId(Long systemParameterId) {
        this.systemParameterId = systemParameterId;
    }

    public String getSysParameterUuid() {
        return sysParameterUuid;
    }

    public void setSysParameterUuid(String sysParameterUuid) {
        this.sysParameterUuid = sysParameterUuid;
    }

    public String getSysParameterName() {
        return sysParameterName;
    }

    public void setSysParameterName(String sysParameterName) {
        this.sysParameterName = sysParameterName;
    }

    public String getSysParameterValue() {
        return sysParameterValue;
    }

    public void setSysParameterValue(String sysParameterValue) {
        this.sysParameterValue = sysParameterValue;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }

}

package com.system.survey.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;

@Entity
@Table(name = "sys_parameter")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SysParameter extends BaseEntity {

    @Id
    @Column(name = "system_parameter_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long systemParameterId;

    @Column(name = "sys_parameter_uuid")
    private String sysParameterUuid;

    @Column(name = "sys_parameter_name")
    private String sysParameterName;

    @Column(name = "sys_parameter_value")
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

}

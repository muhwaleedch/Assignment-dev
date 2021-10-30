package com.system.survey.dto.metadata;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AddressTypeDto {

    private Long addressTypeId;

    private String addressTypeName;

    private String addressTypeUuid;

    public Long getAddressTypeId() {
        return addressTypeId;
    }

    public void setAddressTypeId(Long addressTypeId) {
        this.addressTypeId = addressTypeId;
    }

    public String getAddressTypeName() {
        return addressTypeName;
    }

    public void setAddressTypeName(String addressTypeName) {
        this.addressTypeName = addressTypeName;
    }

    public String getAddressTypeUuid() {
        return addressTypeUuid;
    }

    public void setAddressTypeUuid(String addressTypeUuid) {
        this.addressTypeUuid = addressTypeUuid;
    }


}

package com.system.survey.dto.address;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AddressUserDto {

    private Long addressUserId;

    private String addressUserUuid;

    private String addressUuid;

    private String userUuid;

    public Long getAddressUserId() {
        return addressUserId;
    }

    public void setAddressUserId(Long addressUserId) {
        this.addressUserId = addressUserId;
    }

    public String getAddressUserUuid() {
        return addressUserUuid;
    }

    public void setAddressUserUuid(String addressUserUuid) {
        this.addressUserUuid = addressUserUuid;
    }

    public String getAddressUuid() {
        return addressUuid;
    }

    public void setAddressUuid(String addressUuid) {
        this.addressUuid = addressUuid;
    }

    public String getUserUuid() {
        return userUuid;
    }

    public void setUserUuid(String userUuid) {
        this.userUuid = userUuid;
    }

}

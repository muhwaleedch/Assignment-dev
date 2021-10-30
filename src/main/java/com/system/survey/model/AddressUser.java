package com.system.survey.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;

@Entity
@Table(name = "address_user")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AddressUser extends BaseEntity {

    @Id
    @Column(name = "address_user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressUserId;

    @Column(name = "address_user_uuid")
    private String addressUserUuid;

    @Column(name = "address_uuid")
    private String addressUuid;

    @Column(name = "user_uuid")
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

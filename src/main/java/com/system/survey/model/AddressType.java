package com.system.survey.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;

@Entity
@Table(name = "address_type")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AddressType {

    @Id
    @Column(name = "address_type_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressTypeId;

    @Column(name = "address_type_name")
    private String addressTypeName;

    @Column(name = "address_type_uuid")
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

package com.system.survey.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;

@Entity
@Table(name = "states")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class State {

    @Id
    @Column(name = "states_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long statesId;

    @Column(name = "states_uuid", nullable = false)
    private String statesUuid;

    @Column(name = "name")
    private String name;

    @Column(name = "country_uuid")
    private String countryUuid;

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

    public String getCountryUuid() {
        return countryUuid;
    }

    public void setCountryUuid(String countryUuid) {
        this.countryUuid = countryUuid;
    }

}

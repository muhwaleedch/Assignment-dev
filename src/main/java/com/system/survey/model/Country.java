package com.system.survey.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;

@Entity
@Table(name = "countries")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Country {

    @Id
    @Column(name = "countries_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long countriesId;

    @Column(name = "countries_uuid", nullable = false)
    private String countriesUuid;

    @Column(name = "name")
    private String name;

    @Column(name = "iso3")
    private String iso3;

    public Long getCountriesId() {
        return countriesId;
    }

    public void setCountriesId(Long countriesId) {
        this.countriesId = countriesId;
    }

    public String getCountriesUuid() {
        return countriesUuid;
    }

    public void setCountriesUuid(String countriesUuid) {
        this.countriesUuid = countriesUuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIso3() {
        return iso3;
    }

    public void setIso3(String iso3) {
        this.iso3 = iso3;
    }

}

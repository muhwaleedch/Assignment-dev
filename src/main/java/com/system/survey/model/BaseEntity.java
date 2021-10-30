package com.system.survey.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.Gson;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.sql.Timestamp;


@MappedSuperclass
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseEntity extends BaseMasterEntity {

    @Column(name = "updated_dts")
    private Timestamp updatedDts;

    @Column(name = "updated_by")
    private String updatedBy;

    public BaseEntity() {
    }

    public Timestamp getUpdatedDts() {
        return updatedDts;
    }

    public void setUpdatedDts(Timestamp updatedDts) {
        this.updatedDts = updatedDts;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedDts = new Timestamp(System.currentTimeMillis());
    }

    @PrePersist
    protected void onCreate() {
        super.setCreatedDts(new Timestamp(System.currentTimeMillis()));
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }

}

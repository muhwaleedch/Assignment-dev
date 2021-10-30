package com.system.survey.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.Gson;
import com.system.survey.enums.ActiveStatus;

import java.sql.Timestamp;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class IntCmdDto {

    private Long intCmdId;
    private String intCmdUuid;
    private String intCmdIntTypeId;
    private String intCmdIntTypeUuid;
    private String intCmdCmd;
    private String intCmdCmdUserfriendlyname;
    private String intCmdBlog;
    private Integer intCmdZebraId;
    private String intCmdZebraUuid;
    private Timestamp updatedDts;
    private String updatedBy;
    private Timestamp createdDts;
    private String createdBy;
    private ActiveStatus activeStatus;

    public IntCmdDto() {
    }

    public Long getIntCmdId() {
        return intCmdId;
    }

    public void setIntCmdId(Long intCmdId) {
        this.intCmdId = intCmdId;
    }

    public String getIntCmdUuid() {
        return intCmdUuid;
    }

    public void setIntCmdUuid(String intCmdUuid) {
        this.intCmdUuid = intCmdUuid;
    }

    public String getIntCmdIntTypeId() {
        return intCmdIntTypeId;
    }

    public void setIntCmdIntTypeId(String intCmdIntTypeId) {
        this.intCmdIntTypeId = intCmdIntTypeId;
    }

    public String getIntCmdIntTypeUuid() {
        return intCmdIntTypeUuid;
    }

    public void setIntCmdIntTypeUuid(String intCmdIntTypeUuid) {
        this.intCmdIntTypeUuid = intCmdIntTypeUuid;
    }

    public String getIntCmdCmd() {
        return intCmdCmd;
    }

    public void setIntCmdCmd(String intCmdCmd) {
        this.intCmdCmd = intCmdCmd;
    }

    public String getIntCmdCmdUserfriendlyname() {
        return intCmdCmdUserfriendlyname;
    }

    public void setIntCmdCmdUserfriendlyname(String intCmdCmdUserfriendlyname) {
        this.intCmdCmdUserfriendlyname = intCmdCmdUserfriendlyname;
    }

    public String getIntCmdBlog() {
        return intCmdBlog;
    }

    public void setIntCmdBlog(String intCmdBlog) {
        this.intCmdBlog = intCmdBlog;
    }

    public Integer getIntCmdZebraId() {
        return intCmdZebraId;
    }

    public void setIntCmdZebraId(Integer intCmdZebraId) {
        this.intCmdZebraId = intCmdZebraId;
    }

    public String getIntCmdZebraUuid() {
        return intCmdZebraUuid;
    }

    public void setIntCmdZebraUuid(String intCmdZebraUuid) {
        this.intCmdZebraUuid = intCmdZebraUuid;
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

    public Timestamp getCreatedDts() {
        return createdDts;
    }

    public void setCreatedDts(Timestamp createdDts) {
        this.createdDts = createdDts;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public ActiveStatus getActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(ActiveStatus activeStatus) {
        this.activeStatus = activeStatus;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}

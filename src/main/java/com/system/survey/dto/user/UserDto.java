package com.system.survey.dto.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.Gson;
import com.system.survey.enums.ActiveStatus;

import java.sql.Date;
import java.sql.Timestamp;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto {

    private Long userId;
    private String userUuid;
    private String userFirstName;
    private String userMiddleName;
    private String userLastName;
    private String address;
    private String userActivatedDate;
    private String userAuthUserId;
    private String userContactnumber;
    private String userEmail;
    private Date userExpirationDate;
    private String userGroupid;
    private String userjobId;
    private String userLastactivityDate;
    private String userOrgId;
    private String userPassword;
    private String userRoleId;
    private String userRoleid;
    private String userUserId;
    private Timestamp updatedDts;
    private String updatedBy;
    private Timestamp createdDts;
    private String createdBy;
    private ActiveStatus activeStatus;
    private String registerBy;
    private String userType;
    private String userPasswordReset;

    public UserDto() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserUuid() {
        return userUuid;
    }

    public void setUserUuid(String userUuid) {
        this.userUuid = userUuid;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserMiddleName() {
        return userMiddleName;
    }

    public void setUserMiddleName(String userMiddleName) {
        this.userMiddleName = userMiddleName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUserActivatedDate() {
        return userActivatedDate;
    }

    public void setUserActivatedDate(String userActivatedDate) {
        this.userActivatedDate = userActivatedDate;
    }

    public String getUserAuthUserId() {
        return userAuthUserId;
    }

    public void setUserAuthUserId(String userAuthUserId) {
        this.userAuthUserId = userAuthUserId;
    }

    public String getUserContactnumber() {
        return userContactnumber;
    }

    public void setUserContactnumber(String userContactnumber) {
        this.userContactnumber = userContactnumber;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public Date getUserExpirationDate() {
        return userExpirationDate;
    }

    public void setUserExpirationDate(Date userExpirationDate) {
        this.userExpirationDate = userExpirationDate;
    }

    public String getUserGroupid() {
        return userGroupid;
    }

    public void setUserGroupid(String userGroupid) {
        this.userGroupid = userGroupid;
    }

    public String getUserjobId() {
        return userjobId;
    }

    public void setUserjobId(String userjobId) {
        this.userjobId = userjobId;
    }

    public String getUserLastactivityDate() {
        return userLastactivityDate;
    }

    public void setUserLastactivityDate(String userLastactivityDate) {
        this.userLastactivityDate = userLastactivityDate;
    }

    public String getUserOrgId() {
        return userOrgId;
    }

    public void setUserOrgId(String userOrgId) {
        this.userOrgId = userOrgId;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(String userRoleId) {
        this.userRoleId = userRoleId;
    }

    public String getUserRoleid() {
        return userRoleid;
    }

    public void setUserRoleid(String userRoleid) {
        this.userRoleid = userRoleid;
    }

    public String getUserUserId() {
        return userUserId;
    }

    public void setUserUserId(String userUserId) {
        this.userUserId = userUserId;
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

    public String getRegisterBy() {
        return registerBy;
    }

    public void setRegisterBy(String registerBy) {
        this.registerBy = registerBy;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getUserPasswordReset() {
        return userPasswordReset;
    }

    public void setUserPasswordReset(String userPasswordReset) {
        this.userPasswordReset = userPasswordReset;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }

    public enum RegisterByOptions {byEmail, byPhone}
}

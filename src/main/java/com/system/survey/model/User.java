package com.system.survey.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.Gson;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "user")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User extends BaseEntity {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(name = "user_uuid", nullable = false)
    private String userUuid;

    @Column(name = "user_first_name")
    private String userFirstName;

    @Column(name = "user_middle_name")
    private String userMiddleName;

    @Column(name = "user_last_name")
    private String userLastName;

    @Column(name = "address")
    private String address;

    @Column(name = "user_activated_date")
    private Timestamp userActivatedDate;

    @Column(name = "user_auth_user_id")
    private String userAuthUserId;

    @Column(name = "user_contactnumber")
    private String userContactnumber;

    @Column(name = "user_email")
    private String userEmail;

    @Column(name = "user_expiration_date")
    private Timestamp userExpirationDate;

    @Column(name = "user_group_id")
    private String userGroupid;

    @Column(name = "user_job_id")
    private String userjobId;

    @Column(name = "user_lastactivity_date")
    private Timestamp userLastactivityDate;

    @Column(name = "user_org_id")
    private String userOrgId;

    @Column(name = "user_password")
    private String userPassword;

    @Column(name = "user_user_id")
    private String userUserId;

    @Column(name = "user_role_id")
    private String userRoleId;

    @Column(name = "user_password_reset")
    private String userPasswordReset;

    public User() {
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

    public Timestamp getUserActivatedDate() {
        return userActivatedDate;
    }

    public void setUserActivatedDate(Timestamp userActivatedDate) {
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

    public Timestamp getUserExpirationDate() {
        return userExpirationDate;
    }

    public void setUserExpirationDate(Timestamp userExpirationDate) {
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

    public Timestamp getUserLastactivityDate() {
        return userLastactivityDate;
    }

    public void setUserLastactivityDate(Timestamp userLastactivityDate) {
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

    public String getUserUserId() {
        return userUserId;
    }

    public void setUserUserId(String userUserId) {
        this.userUserId = userUserId;
    }

    public String getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(String userRoleId) {
        this.userRoleId = userRoleId;
    }

    public String getUserPasswordReset() {
        return userPasswordReset;
    }

    public void setUserPasswordReset(String userPasswordResetFlag) {
        this.userPasswordReset = userPasswordResetFlag;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}

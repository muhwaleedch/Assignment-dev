package com.system.survey.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.Gson;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResetPasswordWrapperDTO {
    private String userPasswordReset;
    private String confirmPassword;

    public ResetPasswordWrapperDTO() {
    }

    public ResetPasswordWrapperDTO(String userPassword, String confirmPassword) {
        this.userPasswordReset = userPassword;
        this.confirmPassword = confirmPassword;
    }

    public String getUserPasswordReset() {
        return userPasswordReset;
    }

    public void setUserPasswordReset(String userPasswordReset) {
        this.userPasswordReset = userPasswordReset;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}

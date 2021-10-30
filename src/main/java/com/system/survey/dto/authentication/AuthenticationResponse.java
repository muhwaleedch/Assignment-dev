package com.system.survey.dto.authentication;

public class AuthenticationResponse {

    private final String jwt;

    private final String userType;

    private final String userName;

    private final String userPasswordReset;

    public AuthenticationResponse(String jwt, String userType, String userName, String userPasswordReset) {
        // TODO Auto-generated constructor stub
        this.jwt = jwt;
        this.userType = userType;
        this.userName = userName;
        this.userPasswordReset = userPasswordReset;
    }

    public String getJwt() {
        return jwt;
    }

    public String getUserType() {
        return userType;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserPasswordReset() {
        return userPasswordReset;
    }
}

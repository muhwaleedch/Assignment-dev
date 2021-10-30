package com.system.survey.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ConfigurationProperties
@PropertySource("classpath:application.properties")
public class ApplicationProperties {

    @Value("${com.system.survey.default.org.name}")
    private String defaultSurveyOrgName;

    @Value("${session.expiry.time.in.min}")
    private int sessionExpiryTimeInMin;

    @Value("${com.system.survey.user.type}")
    private String surveyUser;

    @Value("${com.system.survey.admin.type}")
    private String surveyAdmin;

    @Value("${com.system.survey.from.email}")
    private String fromEmail;

    @Value("${com.system.survey.from.password}")
    private String fromPassword;

    @Value("${com.system.survey.gmailSmtpServer}")
    private String gmailSmtpServer;

    @Value("${com.system.survey.email.subject}")
    private String emailSubject;

    @Value("${com.system.survey.email.text}")
    private String emailText;

    @Value("${com.system.survey.twilio.account_sid}")
    private String accountSID;

    @Value("${com.system.survey.twilio.auth_token}")
    private String authToken;

    @Value("${com.system.survey.twilio.phoneNumber}")
    private String fromPhone;

    public String getDefaultSurveyOrgName() {
        return defaultSurveyOrgName;
    }

    public int getSessionExpiryTimeInMin() {
        return sessionExpiryTimeInMin;
    }

    public String getSurveyUser() {
        return surveyUser;
    }

    public String getSurveyAdmin() {
        return surveyAdmin;
    }

    public String getFromEmail() {
        return fromEmail;
    }

    public void setFromEmail(String fromEmail) {
        this.fromEmail = fromEmail;
    }

    public String getFromPassword() {
        return fromPassword;
    }

    public void setFromPassword(String fromPassword) {
        this.fromPassword = fromPassword;
    }

    public String getGmailSmtpServer() {
        return gmailSmtpServer;
    }

    public void setGmailSmtpServer(String gmailSmtpServer) {
        this.gmailSmtpServer = gmailSmtpServer;
    }

    public String getEmailSubject() {
        return emailSubject;
    }

    public void setEmailSubject(String emailSubject) {
        this.emailSubject = emailSubject;
    }

    public String getEmailText() {
        return emailText;
    }

    public void setEmailText(String emailText) {
        this.emailText = emailText;
    }

    public String getAccountSID() {
        return accountSID;
    }

    public String getAuthToken() {
        return authToken;
    }

    public String getFromPhone() {
        return fromPhone;
    }

    public void setFromPhone(String fromPhone) {
        this.fromPhone = fromPhone;
    }
}

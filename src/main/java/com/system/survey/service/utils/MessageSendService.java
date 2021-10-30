package com.system.survey.service.utils;

import com.system.survey.config.ApplicationProperties;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Service
public class MessageSendService {

    private final String accountSID;
    private final String authToken;
    private final String fromEmail;
    private final String fromPassword;
    private final String fromPhone;

    private final Logger logger = LoggerFactory.getLogger(MessageSendService.class);

    public MessageSendService(ApplicationProperties applicationProperties) {
        this.accountSID = applicationProperties.getAccountSID();
        this.authToken = applicationProperties.getAuthToken();
        this.fromEmail = applicationProperties.getFromEmail();
        this.fromPassword = applicationProperties.getFromPassword();
        this.fromPhone = applicationProperties.getFromPhone();
    }

    public final boolean sendEmail(String to, String msg) {
        Properties properties = new Properties();

        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.socketFactory.port", "465");
        properties.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.port", "465");

        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, fromPassword);
            }
        });
        logger.info("session initiated");
        try {
            MimeMessage mimeMessage = new MimeMessage(session);
            InternetAddress internetAddress = new InternetAddress(to);
            mimeMessage.addRecipient(javax.mail.Message.RecipientType.TO, internetAddress);
            logger.info("message creation");

            String subject = "Password Reset";
            mimeMessage.setSubject(subject);

            String message = "Your new password to login to your account is " + msg + ". Thanks for using our services";
            mimeMessage.setText(message);
            logger.info("messageCreated");
            Transport.send(mimeMessage);
            logger.info("email sent successfully");
            return true;
        } catch (MessagingException e) {
            logger.info("exception occurred" + e);
            return false;
        }
    }

    public final boolean sendMessage(String toNumber, String randomGeneratedPassword) {
       try {
           Twilio.init(accountSID, authToken);
           Message message = Message.creator(
                           new com.twilio.type.PhoneNumber(toNumber),
                           new com.twilio.type.PhoneNumber(fromPhone),
                           "This is your updated password, kindly log in with this password to change your password: " + randomGeneratedPassword)
                   .create();

           logger.info("This is the sent password!: " + randomGeneratedPassword);
           return true;
       } catch (Exception e) {
           logger.info("message failed" + e.getMessage());
           return false;
       }
    }
}
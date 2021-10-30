package com.system.survey.service.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class EncryptionUtils {

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String encode(String dataToEncode) {
        return passwordEncoder.encode(dataToEncode);
    }

}

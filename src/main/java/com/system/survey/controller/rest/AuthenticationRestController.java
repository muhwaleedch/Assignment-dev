package com.system.survey.controller.rest;

import com.system.survey.config.ApplicationProperties;
import com.system.survey.dto.Response;
import com.system.survey.dto.authentication.AuthenticationRequest;
import com.system.survey.dto.authentication.AuthenticationResponse;
import com.system.survey.dto.authentication.UserPrincipal;
import com.system.survey.service.user.IUserService;
import com.system.survey.service.utils.JWTUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/survey")
public class AuthenticationRestController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private IUserService userService;

    @Autowired
    private ApplicationProperties applicationProperties;

    @Autowired
    private JWTUtil jwtUtil;

    private Logger logger = LoggerFactory.getLogger(AuthenticationRestController.class);

    @RequestMapping(value = "/user/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {

        ResponseEntity<?> responseEntity = null;

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
            final UserDetails userDetails = userService.loadUserByUsername(authenticationRequest.getUsername());
            UserPrincipal userPrincipal = (UserPrincipal) userDetails;
            if (userPrincipal.getUserDto().getUserType().trim().equalsIgnoreCase(applicationProperties.getSurveyUser().trim())) {
                String jwt = jwtUtil.generateToken(userPrincipal);
                String firstName = userPrincipal.getUserDto().getUserFirstName() != null ? userPrincipal.getUserDto().getUserFirstName() : "";
                String middleName = userPrincipal.getUserDto().getUserMiddleName() != null ? userPrincipal.getUserDto().getUserMiddleName() : "";
                String lastName = userPrincipal.getUserDto().getUserLastName() != null ? userPrincipal.getUserDto().getUserLastName() : "";

                String name = firstName + " " + middleName + " " + lastName;

                responseEntity = ResponseEntity.ok(new AuthenticationResponse(jwt, userPrincipal.getUserDto().getUserType(), name, userPrincipal.getUserDto().getUserPasswordReset()));
            } else {
                throw new BadCredentialsException("user is not of surveyuser type");
            }
        } catch (BadCredentialsException e) {
            responseEntity = new ResponseEntity<>(new Response("UNAUTHORIZED", "Invalid Username or Password"), HttpStatus.UNAUTHORIZED);
        }
        return responseEntity;
    }

    @RequestMapping(value = "/admin/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAdminAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {

        ResponseEntity<?> responseEntity = null;

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
            final UserDetails userDetails = userService.loadUserByUsername(authenticationRequest.getUsername());
            UserPrincipal userPrincipal = (UserPrincipal) userDetails;
            if (userPrincipal.getUserDto().getUserType().trim().equalsIgnoreCase(applicationProperties.getSurveyAdmin().trim())) {
                String jwt = jwtUtil.generateToken(userPrincipal);

                String firstName = userPrincipal.getUserDto().getUserFirstName() != null ? userPrincipal.getUserDto().getUserFirstName() : "";
                String middleName = userPrincipal.getUserDto().getUserMiddleName() != null ? userPrincipal.getUserDto().getUserMiddleName() : "";
                String lastName = userPrincipal.getUserDto().getUserLastName() != null ? userPrincipal.getUserDto().getUserLastName() : "";

                String name = firstName + " " + middleName + " " + lastName;

                responseEntity = ResponseEntity.ok(new AuthenticationResponse(jwt, userPrincipal.getUserDto().getUserType(), name, userPrincipal.getUserDto().getUserPasswordReset()));
            } else {
                throw new BadCredentialsException("user is not of admin type");
            }
        } catch (BadCredentialsException e) {
            responseEntity = new ResponseEntity<>(new Response("UNAUTHORIZED", "Invalid Username or Password"), HttpStatus.UNAUTHORIZED);
        }
        return responseEntity;
    }
}

package com.system.survey.controller.rest;

import com.system.survey.dto.ResetPasswordWrapperDTO;
import com.system.survey.dto.Response;
import com.system.survey.dto.address.AddressDto;
import com.system.survey.dto.authentication.UserPrincipal;
import com.system.survey.dto.user.UserAttachDto;
import com.system.survey.dto.user.UserDto;
import com.system.survey.exception.ExceptionUtil;
import com.system.survey.service.user.IUserService;
import com.system.survey.service.utils.JWTUtil;
import com.system.survey.service.utils.MessageSendService;
import com.system.survey.service.utils.UtilFunctions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Base64;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/survey/user")
public class UserRestController {

    private Logger logger = LoggerFactory.getLogger(UserRestController.class);
    private final int GENERATED_PASSWORD_LENGTH = 10;

    @Autowired
    private IUserService userService;

    @Autowired
    private MessageSendService messageSendService;

    @Autowired
    private JWTUtil jwtUtil;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<?> registerUser(@RequestBody UserDto requestUserDto) {
        try {
            if (!userService.checkIfUserExists(requestUserDto)) {
                UserDto processedUserDto = userService.createUser(requestUserDto);
                return new ResponseEntity<>(new Response("Success", "User save successfully", processedUserDto), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(new Response("Conflict", "User already exists with provided Email/Contact Number"), HttpStatus.CONFLICT);
            }
        } catch (Exception ex) {
            logger.error("An error occurred while createUser ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/updateUser", method = RequestMethod.POST)
    public ResponseEntity<?> updateUser(@RequestBody UserDto userDto) {
        try {
            Optional<UserDto> userDtoOptional = userService.updateUser(userDto);
            if (userDtoOptional.isPresent()) {
                return new ResponseEntity<>(this.userService.updateUser(userDto), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(new Response("ERROR", "Some Error occurred and User didn't updated, Contact With Support"), HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception ex) {
            logger.error("An error occurred while updateUser ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred and User didn't updated, Contact With Support"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/findAllUser", method = RequestMethod.GET)
    public ResponseEntity<?> findAllUser() {
        logger.info("##### findAllUser Start");
        try {
            return new ResponseEntity<>(this.userService.findAllUser(), HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while findAllUser ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/findUserByUserUuid", method = RequestMethod.GET)
    public ResponseEntity<?> findUserByUserUuid(@RequestParam String userUuid) {
        logger.info("##### findRoleByRoleUuid Start");
        try {
            return new ResponseEntity<>(this.userService.findUserByUserUuid(userUuid), HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while findUserByUserUuid ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/deleteUserByUserUuid", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteUserByUserUuid(@RequestParam String userUuid) {
        logger.info("##### deleteUserByUserUuid Start");
        try {
            return new ResponseEntity<>(this.userService.deleteUserByUserUuid(userUuid), HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while deleteUserByUserUuid ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/findUserByUserUserId", method = RequestMethod.GET)
    public ResponseEntity<?> findUserByUserAuthUserId(@RequestParam String userUserId) {
        try {
            ResponseEntity<?> responseEntity = null;
            Optional<UserDto> userDtoOptional = userService.findUserByUserUserId(userUserId);
            if (userDtoOptional.isPresent()) {
                userDtoOptional.get().setUserPassword("");
                responseEntity = ResponseEntity.ok(new Response("Success", "User save successfully", userDtoOptional.get()));
            } else {
                responseEntity = new ResponseEntity<>(new Response("User Not Found", "User not found"), HttpStatus.NOT_FOUND);
            }
            return responseEntity;
        } catch (Exception ex) {
            logger.error("An error occurred while findUserByUserUuid ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred, Contact With Support"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/saveUserAddress", method = RequestMethod.POST)
    public ResponseEntity<?> saveUserAddress(@RequestBody AddressDto addressDto) {
        try {
            UserPrincipal userPrincipal = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            Optional<AddressDto> addressDtoOptional = userService.saveUserAddress(addressDto, userPrincipal.getUserDto().getUserUuid());
            if (addressDtoOptional.isPresent()) {
                return new ResponseEntity<>(addressDtoOptional.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(new Response("ERROR", "Some Error occurred and Address details didn't updated, Contact With Support"), HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception ex) {
            logger.error("An error occurred while saving user address ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred and Address didn't updated, Contact With Support"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/findUserAddress", method = RequestMethod.GET)
    public ResponseEntity<?> findUserAddress() {
        try {
            UserPrincipal userPrincipal = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            return new ResponseEntity<>(new Response("SUCCESS", "User Addresses Fetched Succesfully", userService.findAddresesByUserUserId(userPrincipal.getUsername())), HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while finding user address ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred and Address for user can't be fetched, Contact With Support"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/deleteUserAddress/{addressUuid}", method = RequestMethod.GET)
    public ResponseEntity<?> deleteUserAddressByAddressUuid(@PathVariable String addressUuid) {
        try {
            UserPrincipal userPrincipal = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            userService.markUserAddressInActive(addressUuid, userPrincipal.getUserDto().getUserUuid());
            return new ResponseEntity<>(new Response("SUCCESS", "User Addresses Deleted Succesfully", null), HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while deleting user address ", ExceptionUtil.getRootCauseMessage(ex));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred and Address for user can't be deleted, Contact With Support"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/updateProfilePicture", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<?> updateProfilePicture(@RequestPart("file") MultipartFile file) {
        try {
            UserPrincipal userPrincipal = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            UserAttachDto userAttachDto = userService.updateProfilePicture(userPrincipal.getUserDto(), file);
            return new ResponseEntity<>(new Response("SUCCESS", "User profile picture saved successfully", userAttachDto), HttpStatus.OK);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            logger.error("An error occurred while saving user attachment ", ExceptionUtil.getRootCauseMessage(e));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred aand user profile picture can't be saved, Contact With Support"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/getProfilePicture", method = RequestMethod.GET)
    public ResponseEntity<?> getProfilePicture() {
        try {
            UserPrincipal userPrincipal = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            Optional<UserAttachDto> userAttachDto = userService.getProfilePicture(userPrincipal.getUserDto());
            if (userAttachDto.isPresent()) {
                return ResponseEntity.ok()
                        .contentType(MediaType.IMAGE_GIF)
                        .contentType(MediaType.IMAGE_JPEG)
                        .contentType(MediaType.IMAGE_PNG)
                        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + userAttachDto.get().getUserAttachPath() + "\"")
                        .body(new ByteArrayResource(Base64.getEncoder().encodeToString(userAttachDto.get().getUserAttachBlob()).getBytes()));
            } else {
                return new ResponseEntity<>(new Response("SUCCESS", "User profile picture not found", null), HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            logger.error("An error occurred while fetching user profile picture", ExceptionUtil.getRootCauseMessage(e));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred aand user profile picture can't be found, Contact With Support"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/saveUserAttachment", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<?> saveUserAttachement(@RequestPart("attachmentTypeUuid") String attachmentTypeUuid, @RequestPart("file") MultipartFile file) {
        try {
            UserPrincipal userPrincipal = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            UserAttachDto userAttachDto = userService.saveUserAttachment(userPrincipal.getUserDto(), attachmentTypeUuid, file);
            return new ResponseEntity<>(new Response("SUCCESS", "User attachment saved successfully", userAttachDto), HttpStatus.OK);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            logger.error("An error occurred while saving user attachment ", ExceptionUtil.getRootCauseMessage(e));
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred aand user attahcment can't be saved, Contact With Support"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/getUserAttachment", method = RequestMethod.GET)
    public ResponseEntity<?> getUserAttachment(@RequestParam String attachmentTypeUuid) {
        try {
            UserPrincipal userPrincipal = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            Optional<UserAttachDto> userAttachDtos = userService.findUserAttachmentsByAttachmentTypeUuid(userPrincipal.getUserDto(), attachmentTypeUuid);
            Optional<UserAttachDto> userAttachDto = Optional.empty();
            if (userAttachDtos.isPresent()) {
                userAttachDto = Optional.of(userAttachDtos.get());
            }
            if (userAttachDto.isPresent()) {
                return ResponseEntity.ok()
                        .contentType(MediaType.parseMediaTypes(userAttachDto.get().getContentType()).get(0))
                        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + userAttachDto.get().getUserAttachPath() + "\"")
                        .body(new ByteArrayResource(Base64.getEncoder().encodeToString(userAttachDto.get().getUserAttachBlob()).getBytes()));
            } else {
                return new ResponseEntity<>(new Response("ERROR", "User attachment not found", null), HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            logger.error("An error occurred while fetching user attachment ", e);
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred and user attachment can't be found, Contact With Support"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/findUserAttachments", method = RequestMethod.GET)
    public ResponseEntity<?> findUserAttachments() {
        try {
            UserPrincipal userPrincipal = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            List<UserAttachDto> userAttachDtos = userService.findAllUserAttachments(userPrincipal.getUserDto().getUserUuid());
            userAttachDtos.forEach(userAttachDto -> userAttachDto.setUserAttachBlob(null));
            return new ResponseEntity<>(new Response("SUCCESS", "User Attachments Fetched Succesfully", userAttachDtos), HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while finding user attachments ", ex);
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred and attachments for user can't be fetched, Contact With Support"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/deleteUserAttachment", method = RequestMethod.GET)
    public ResponseEntity<?> deleteUserAttachments(@RequestParam String attachmentTypeUuid) {
        try {
            UserPrincipal userPrincipal = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            userService.deleteUserAttachment(userPrincipal.getUserDto(), attachmentTypeUuid);
            return new ResponseEntity<>(new Response("SUCCESS", "User Attachment Deleted Succesfully", null), HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("An error occurred while deleting user attachments ", ex);
            return new ResponseEntity<>(new Response("ERROR", "Some Error occurred and attachment of user can't be deleted, Contact With Support"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/forgot-password", method = RequestMethod.GET)
    public ResponseEntity<?> findUserSendEmail(@RequestParam String userEmail, @RequestParam String type) {
        logger.info("findUserSendEmail started");
        ResponseEntity<?> responseEntity;
        boolean isEmail = type.equals("byEmail");
        try {
            Optional<UserDto> userDtoOptional = this.userService.findUserByUserUserId(userEmail);
            if (userDtoOptional.isPresent()) {
                String randomPassword = UtilFunctions.getAlphaNumericString(GENERATED_PASSWORD_LENGTH);
                UserDto userDto = userDtoOptional.get();
                boolean isMailSentSuccessfully;
                if (isEmail) {
                    isMailSentSuccessfully = this.messageSendService.sendEmail(userDto.getUserEmail(), randomPassword);
                } else {
                    isMailSentSuccessfully = this.messageSendService.sendMessage(userDto.getUserContactnumber(), randomPassword);
                }
                logger.info("isMailSentSuccessfully status: " + isMailSentSuccessfully);
                if (isMailSentSuccessfully) {
                    userDto.setUserPassword(randomPassword);
                    userDto.setUserPasswordReset("Y");
                    this.userService.updateUser(userDto);
                    return ResponseEntity.ok(new Response("Success", isEmail ? "An Email with instruction sent successfully" : "A Message with further instructions has been sent."));
                }
                throw new Exception("Cannot Send " + (isEmail ? "Email" : "Message"));
            } else {
                throw new Exception("User not found");
            }
        } catch (Exception ex) {
            responseEntity = new ResponseEntity<>(new Response("ERROR", ExceptionUtil.getRootCauseMessage(ex)), HttpStatus.NOT_FOUND);
        }
        logger.info("findUserSendEmail ended successfully");
        return responseEntity;
    }

    @RequestMapping(value = "/change-password")
    public ResponseEntity<?> changePassword(@RequestHeader("Authorization") String authorizationToken, @RequestBody ResetPasswordWrapperDTO resetPasswordWrapperDTO) {
        logger.info("changePassword started");
        ResponseEntity<?> responseEntity;
        try {
            Optional<UserDto> userDtoOptional = this.userService.findUserByUserUserId(jwtUtil.extractUsername(authorizationToken));
            if (userDtoOptional.isPresent()) {
                this.userService.changePassword(resetPasswordWrapperDTO, userDtoOptional.get().getUserEmail());
                return new ResponseEntity<>(new Response("SUCCESS", "Password Changed Successfully"), HttpStatus.OK);
            }
            throw new Exception("Error Occurred");
        } catch (Exception ex) {
            responseEntity = new ResponseEntity<>(new Response("ERROR", ExceptionUtil.getRootCauseMessage(ex)), HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }
}

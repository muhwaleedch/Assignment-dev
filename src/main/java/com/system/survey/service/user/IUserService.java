package com.system.survey.service.user;

import com.system.survey.dto.ResetPasswordWrapperDTO;
import com.system.survey.dto.Response;
import com.system.survey.dto.address.AddressDto;
import com.system.survey.dto.user.UserAttachDto;
import com.system.survey.dto.user.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

public interface IUserService extends UserDetailsService {

    public UserDto createUser(UserDto userDto) throws Exception;

    public Optional<UserDto> updateUser(UserDto userDto) throws Exception;

    public Response findAllUser();

    public Response findUserByUserUuid(String userUuid);

    Optional<UserDto> findUserByPhoneNumber(String phoneNumber) throws Exception;

    public Response deleteUserByUserUuid(String userUuid);

    public boolean checkIfUserExists(UserDto userDto) throws Exception;

    public Optional<UserDto> findUserByUserUserId(String userAuthUserId) throws Exception;

    public Optional<AddressDto> saveUserAddress(AddressDto addressDto, String userUuid) throws Exception;

    List<AddressDto> findAddresesByUserUserId(String userUserId) throws Exception;

    void markUserAddressInActive(String addressUuid, String userUuid) throws Exception;

    UserAttachDto saveUserAttachment(UserDto userDto, String attachmentTypeUuid, MultipartFile multipartFile) throws Exception;

    List<UserAttachDto> findAllUserAttachments(String userUuid) throws Exception;

    UserAttachDto updateProfilePicture(UserDto userDto, MultipartFile multipartFile) throws Exception;

    Optional<UserAttachDto> getProfilePicture(UserDto userDto) throws Exception;

    Optional<UserAttachDto> findUserAttachmentsByAttachmentTypeUuid(UserDto userDto, String attachmentTypeUuid) throws Exception;

    void deleteUserAttachment(UserDto userDto, String attachmentTypeUuid) throws Exception;

    void changePassword(ResetPasswordWrapperDTO resetPasswordWrapperDTO, String emailAddress) throws Exception;

}

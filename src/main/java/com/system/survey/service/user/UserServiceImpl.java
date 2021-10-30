package com.system.survey.service.user;

import com.system.survey.config.ApplicationProperties;
import com.system.survey.dto.ResetPasswordWrapperDTO;
import com.system.survey.dto.Response;
import com.system.survey.dto.address.AddressDto;
import com.system.survey.dto.authentication.UserPrincipal;
import com.system.survey.dto.user.UserAttachDto;
import com.system.survey.dto.user.UserDto;
import com.system.survey.enums.ActiveStatus;
import com.system.survey.model.*;
import com.system.survey.repository.address.AddressRepository;
import com.system.survey.repository.address.AddressUserRepository;
import com.system.survey.repository.countries.CountriesRepository;
import com.system.survey.repository.organization.OrganizationRepository;
import com.system.survey.repository.states.StatesRepository;
import com.system.survey.repository.sysparameter.SysParameterRepository;
import com.system.survey.repository.user.*;
import com.system.survey.service.utils.EncryptionUtils;
import com.system.survey.service.utils.ObjectTransformationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements IUserService {

    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrganizationRepository orginzationRepository;

    @Autowired
    private ObjectTransformationService objTransformationService;

    @Autowired
    private ApplicationProperties applicationProperties;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private AddressUserRepository addressUserRepository;

    @Autowired
    private CountriesRepository countryRepostory;

    @Autowired
    private StatesRepository statesRepository;

    @Autowired
    private EncryptionUtils encryptionUtil;

    @Autowired
    private SysParameterRepository sysParameterRepository;

    @Autowired
    private UserAttachRepository userAttachRepository;

    @Autowired
    private UserAttachTypeRepository userAttachTypeRepository;

    @Autowired
    private UserTypeRepository userTypeRepository;

    @Autowired
    private UserOrganizationMappingRepository userOrgMapRepo;

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public UserDto createUser(UserDto userDto) throws Exception {
        logger.info("Going to register New User :" + userDto);
        try {
            User user = objTransformationService.transformUserDtoToUserModel(userDto);
            user.setUserPassword(encryptionUtil.encode(user.getUserPassword()));
            user.setUserUserId(userDto.getUserContactnumber() != null ? userDto.getUserContactnumber().toUpperCase() : userDto.getUserContactnumber());
            if (userDto.getRegisterBy() != null && userDto.getRegisterBy().equalsIgnoreCase(UserDto.RegisterByOptions.byEmail.toString())) {
                user.setUserUserId(userDto.getUserEmail() != null ? userDto.getUserEmail().toUpperCase() : userDto.getUserEmail());
            }
            Optional<Organization> orgOptional = orginzationRepository.findByOrganizationNameAndActiveStatus(applicationProperties.getDefaultSurveyOrgName(), ActiveStatus.Y);
            String orginzationUuid = "";
            if (orgOptional.isPresent()) {
                orginzationUuid = orgOptional.get().getOrganizationUuid();
                user.setUserOrgId(orginzationUuid);
            }
            Optional<UserType> userTypeOptional = Optional.empty();
            if ("admin".equalsIgnoreCase(userDto.getUserType())) {
                userTypeOptional = userTypeRepository.findUserTypeByUserTypeName(applicationProperties.getSurveyAdmin());
            } else {
                userTypeOptional = userTypeRepository.findUserTypeByUserTypeName(applicationProperties.getSurveyUser());
            }
            user = this.userRepository.saveAndFlush(user);
            String userTypeId = userTypeOptional.get().getUserTypeUuid();
            UserOrganizationMapping orgMap = new UserOrganizationMapping();
            orgMap.setOrgId(orginzationUuid);
            orgMap.setUserId(user.getUserUuid());
            orgMap.setUserTypeId(userTypeId);
            orgMap.setActiveStatus(1);
            this.userOrgMapRepo.save(orgMap);
            return objTransformationService.transformUserModelToUserDto(user);
        } catch (Exception e) {
            logger.error("Error while registering new User", e);
            throw new Exception("Error while registering new user.");
        }
    }


    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public boolean checkIfUserExists(UserDto userDto) throws Exception {
        // TODO Auto-generated method stub

        try {
            String userUserId = userDto.getUserContactnumber() != null ? userDto.getUserContactnumber().toUpperCase() : userDto.getUserContactnumber();
            if (userDto.getRegisterBy() != null && userDto.getRegisterBy().equalsIgnoreCase(UserDto.RegisterByOptions.byEmail.toString())) {
                userUserId = userDto.getUserEmail() != null ? userDto.getUserEmail().toUpperCase() : userDto.getUserEmail();
            }
            Optional<User> user = userRepository.findUserByUserUserId(userUserId);
            return user.isPresent();
        } catch (Exception e) {
            logger.error("Error while registering new User", e);
            throw new Exception("Error while registering new user.");
        }
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Optional<UserDto> updateUser(UserDto userDto) throws Exception {
        if (userDto.getUserUuid() == null) {
            throw new IllegalArgumentException("UserDto userUuid cannot but null or blank");
        }
        try {
            Optional<UserDto> updatedUserDto = Optional.empty();
            Optional<User> userOptional = this.userRepository.findUserByUserUuid(userDto.getUserUuid());
            if (userOptional.isPresent()) {
                User user = userOptional.get();
                if (userDto.getUserPassword() != null && !userDto.getUserPassword().isEmpty()) {
                    userDto.setUserPassword(encryptionUtil.encode(userDto.getUserPassword()));
                }
                objTransformationService.transformUserDtoToExistingUserModel(userDto, user);
                user = this.userRepository.saveAndFlush(user);
                updatedUserDto = Optional.of(objTransformationService.transformUserModelToUserDto(user));
            }
            return updatedUserDto;
        } catch (Exception e) {
            logger.error("Error updating user", e);
            throw new Exception("Error while updating user");
        }
    }

    @Override
    public Response findAllUser() {
        return new Response("Success", "User find successfully", this.userRepository.findAll());
    }

    @Override
    public Response findUserByUserUuid(String userUuid) {
        Optional<User> user = this.userRepository.findUserByUserUuid(userUuid);
        if (user.isPresent()) {
            return new Response("Success", "User find successfully", user.get());
        } else {
            return new Response("Success", "User not find");
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public Optional<UserDto> findUserByPhoneNumber(String phoneNumber) throws Exception {
        try {
            Optional<UserDto> userDtoOptional = Optional.empty();
            Optional<User> user = userRepository.findUserByUserContactnumber(phoneNumber);
            if (user.isPresent()) {
                userDtoOptional = Optional.of(objTransformationService.transformUserModelToUserDto(user.get()));
            }
            return userDtoOptional;
        } catch (Exception e) {
            logger.error("Error findUserByUserAuthUserId", e);
            throw new Exception("Error while finding user by userAuthUserId.");
        }
    }

    @Override
    public Response deleteUserByUserUuid(String userUuid) {
        Optional<User> user = this.userRepository.findUserByUserUuid(userUuid);
        user.get().setActiveStatus(ActiveStatus.N);
        this.userRepository.saveAndFlush(user.get());
        return new Response("Success", "Delete successfully");
    }


    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // TODO Auto-generated method stub
        Optional<User> userOptional = userRepository.findUserByUserUserId(username);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            Optional<UserOrganizationMapping> userOrgOpt = userOrgMapRepo.findUserOrganizationMappingByUserId(user.getUserUuid());

            UserPrincipal userDetail = new UserPrincipal();
            UserDto userDto = objTransformationService.transformUserModelToUserDto(user);
            userDto.setUserType(applicationProperties.getSurveyUser());
            if (userOrgOpt.isPresent()) {
                Optional<UserType> userTypeOptional = userTypeRepository.findByUserTypeUuid(userOrgOpt.get().getUserTypeId());
                if (userTypeOptional.isPresent()) {
                    userDto.setUserType(userTypeOptional.get().getUserTypeName() != null ? userTypeOptional.get().getUserTypeName().toLowerCase() : applicationProperties.getSurveyUser());
                }
            }
            userDetail.setUserDto(userDto);
            return userDetail;
        } else {
            throw new UsernameNotFoundException("No User found with provided Username");
        }
    }


    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public Optional<UserDto> findUserByUserUserId(String userAuthUserId) throws Exception {
        // TODO Auto-generated method stub

        try {
            Optional<UserDto> userDtoOptional = Optional.empty();
            userAuthUserId = userAuthUserId != null ? userAuthUserId.toUpperCase() : userAuthUserId;
            Optional<User> user = userRepository.findUserByUserUserId(userAuthUserId);
            if (user.isPresent()) {
                userDtoOptional = Optional.of(objTransformationService.transformUserModelToUserDto(user.get()));
            }
            return userDtoOptional;
        } catch (Exception e) {
            logger.error("Error findUserByUserAuthUserId", e);
            throw new Exception("Error while finding user by userAuthUserId.");
        }
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Optional<AddressDto> saveUserAddress(AddressDto addressDto, String userUuid) throws Exception {
        try {
            Optional<AddressDto> addressDtoOptional = Optional.empty();
            Address addressModel = null;
            String addressUuid = addressDto.getAddressUuid() == null || addressDto.getAddressUuid().isEmpty() ? "_new" : addressDto.getAddressUuid();
            if (addressUuid.endsWith("_new")) {
                addressDto.setAddressUuid(UUID.randomUUID().toString());
            }
            String countryUuid = addressDto.getCountry();
            countryUuid = countryUuid != null ? countryUuid.split("\\|")[0] : "0000-0000-0000-0000-0000";

//		Optional<User> userOpt = userRepository.findUserByUserUserId(userAuthUserId);
            Optional<Country> countryOpt = countryRepostory.findByCountriesUuid(countryUuid);

//		if(!userOpt.isPresent()) {
//			throw new Exception("Unable to find user while saving address for user");
//		}

            if (!countryOpt.isPresent()) {
                throw new Exception("Unable to find country details while saving address for user");
            }

            String addressStateName = "N/A";
            if (addressDto.getState() != null && !addressDto.getState().equalsIgnoreCase("N/A")) {
                Optional<State> stateOpt = statesRepository.findByStatesUuid(addressDto.getState());
                if (!stateOpt.isPresent()) {
                    throw new Exception("Unable to find state details while saving address for user");
                }
                State state = stateOpt.get();
                addressStateName = state.getName();
            }
//		User user = userOpt.get();
            Country country = countryOpt.get();
            addressDto.setCountryName(country.getName());
            addressDto.setStateName(addressStateName);

            Optional<Address> addressOpt = addressRepository.findByAddressUuid(addressDto.getAddressUuid());
            Optional<AddressUser> addressUserOpt = addressUserRepository.findAddressUserByAddressUuidAndUserUuid(addressDto.getAddressUuid(), userUuid);
            if (addressOpt.isPresent()) {
                addressModel = addressOpt.get();
            }

            addressModel = objTransformationService.transformAddressDtoToAddressModel(addressDto, addressModel);

            addressModel = addressRepository.saveAndFlush(addressModel);

            if (!addressUserOpt.isPresent()) {
                AddressUser addressUser = new AddressUser();
                addressUser.setUserUuid(userUuid);
                addressUser.setAddressUuid(addressDto.getAddressUuid());
                addressUser.setAddressUserUuid(UUID.randomUUID().toString());
                addressUser.setActiveStatus(ActiveStatus.Y);
                addressUserRepository.saveAndFlush(addressUser);
            }
            addressDto.setAddressId(addressModel.getAddressId());
            addressDtoOptional = Optional.of(addressDto);
            return addressDtoOptional;
        } catch (Exception e) {
            logger.error("Error saving user Address details", e);
            throw new Exception("Error saving user Address details");
        }
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public List<AddressDto> findAddresesByUserUserId(String userUserId) throws Exception {
        try {
            return objTransformationService.transformAddressModelsToAddressDtos(addressRepository.findAddressByUserUserId(userUserId));
        } catch (Exception e) {
            logger.error("Error fetching addresses for userUserId: " + userUserId, e);
            throw new Exception("Error fetching addresses for userUserId: " + userUserId);
        }
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void markUserAddressInActive(String addressUuid, String userUuid) throws Exception {
        try {
            Optional<Address> addressOpt = addressRepository.findByAddressUuid(addressUuid);
            if (addressOpt.isPresent()) {
                Address address = addressOpt.get();
                address.setActiveStatus(ActiveStatus.N);
                addressRepository.save(address);
            }

            Optional<AddressUser> addressUserOpt = addressUserRepository.findAddressUserByAddressUuidAndUserUuid(addressUuid, userUuid);
            if (addressUserOpt.isPresent()) {
                AddressUser addressUser = addressUserOpt.get();
                addressUser.setActiveStatus(ActiveStatus.N);
                addressUserRepository.save(addressUser);
            }
        } catch (Exception e) {
            logger.error("Error marking addresses in-active for addressUuid: " + addressUuid, e);
            throw new Exception("Error marking addresses in-active for addressUuid: " + addressUuid);
        }
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public UserAttachDto updateProfilePicture(UserDto userDto, MultipartFile multipartFile) throws Exception {
        try {
            Optional<SysParameter> sysParameterOptProfile = sysParameterRepository.findSysParameterBySysParameterName("profile_pictures_dir");
            Optional<UserAttachType> userAttachType = userAttachTypeRepository.findUserAttachTypeByUserAttachTypeName("profile");
            if (sysParameterOptProfile.isPresent() && userAttachType.isPresent()) {
                String attachmentTypeUuid = userAttachType.get().getUserAttachTypeUuid();

                Optional<UserAttach> userAttachments = userAttachRepository.findUserAttachmentsByUserUuidAndAttachmentTypeUuid(userDto.getUserUuid(), attachmentTypeUuid);
                UserAttach userAttach = null;

                String fileDownloadPath = "";
                String saveToDirectory = sysParameterOptProfile.get().getSysParameterValue();


                Files.createDirectories(Paths.get(saveToDirectory));

                if (userAttachments.isPresent()) {
                    userAttach = userAttachments.get();
                    userAttach.setUserAttachBlob(null);
                    fileDownloadPath = userAttach.getUserAttachPath();
                } else {
                    String fileNameUuid = UUID.randomUUID().toString();
                    String orignalFileName = multipartFile.getOriginalFilename();
                    // Code block to save attachment type
                    fileNameUuid += orignalFileName.substring(orignalFileName.indexOf('.'), orignalFileName.length());
                    fileDownloadPath = saveToDirectory + File.separator + fileNameUuid;

                    userAttach = new UserAttach();
                    userAttach.setUserAttachUuid(UUID.randomUUID().toString());
                    userAttach.setActiveStatus(ActiveStatus.Y);
                    userAttach.setUserUserUuid(userDto.getUserUuid());
                    userAttach.setUserUserId(userDto.getUserUserId());
                    userAttach.setUserAttachPath(fileDownloadPath);
                    userAttach.setUserAttachTypeUuid(attachmentTypeUuid);
                }
                byte[] bytes = multipartFile.getBytes();
                if (multipartFile.getSize() <= 64000) {
                    userAttach.setUserAttachBlob(bytes);
                }
                userAttach = userAttachRepository.save(userAttach);

                Path path = Paths.get(fileDownloadPath);
                Files.write(path, bytes);
                return objTransformationService.transformUserAttachModelToUserAttachDto(userAttach);
            } else {
                throw new Exception("required configurations not defined. Either 'profile_pictures_dir' not defined in sys_parameters or 'profile' in user_attach_type tables");
            }
        } catch (Exception e) {
            logger.error("Error saving user profile picture attachment", e);
            throw new Exception("Error saving user profile picture attachment");
        }
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Optional<UserAttachDto> getProfilePicture(UserDto userDto) throws Exception {
        try {
            Optional<UserAttachDto> userAttachDtoOpt = Optional.empty();
            Optional<UserAttachType> userAttachType = userAttachTypeRepository.findUserAttachTypeByUserAttachTypeName("profile");
            if (userAttachType.isPresent()) {
                String attachmentTypeUuid = userAttachType.get().getUserAttachTypeUuid();
                Optional<UserAttach> userAttachments = userAttachRepository.findUserAttachmentsByUserUuidAndAttachmentTypeUuid(userDto.getUserUuid(), attachmentTypeUuid);
                if (userAttachments.isPresent()) {
                    UserAttachDto userAttachDto = objTransformationService.transformUserAttachModelToUserAttachDto(userAttachments.get());
                    if (userAttachDto.getUserAttachBlob() == null) {
                        userAttachDto.setUserAttachBlob(Files.readAllBytes(Paths.get(userAttachDto.getUserAttachPath())));
                    }
                    userAttachDtoOpt = Optional.of(userAttachDto);
                }
                return userAttachDtoOpt;
            } else {
                throw new Exception("required configurations not defined in user_attach_type table.");
            }
        } catch (Exception e) {
            logger.error("Error fetching user profile picture attachment", e);
            throw new Exception("Error fetching user profile picture attachment");
        }
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public UserAttachDto saveUserAttachment(UserDto userDto, String attachmentTypeUuid, MultipartFile multipartFile) throws Exception {
        try {
            Optional<SysParameter> sysParameterOptAttach = sysParameterRepository.findSysParameterBySysParameterName("attachments_dir");
            Optional<SysParameter> sysParameterOptPersistIn = sysParameterRepository.findSysParameterBySysParameterName("attachment_repository");
            if (sysParameterOptAttach.isPresent() && sysParameterOptPersistIn.isPresent()) {

                Optional<UserAttach> userAttachments = userAttachRepository.findUserAttachmentsByUserUuidAndAttachmentTypeUuid(userDto.getUserUuid(), attachmentTypeUuid);

                String fileDownloadPath = "";
                String saveToDirectory = sysParameterOptAttach.get().getSysParameterValue();


                Files.createDirectories(Paths.get(saveToDirectory));

                if (userAttachments.isPresent()) {
                    UserAttach userAttach = userAttachments.get();
                    //fileDownloadPath = userAttach.getUserAttachPath();
                    userAttach.setActiveStatus(ActiveStatus.N);
                    userAttach.setUserAttachUpdateStatus("Y");
                    userAttach.setUserAttachAdminVerifyStatus("N");
                    userAttach = userAttachRepository.save(userAttach);
                }

                String fileNameUuid = UUID.randomUUID().toString();
                String orignalFileName = multipartFile.getOriginalFilename();
                // Code block to save attachment type
                fileNameUuid += "_" + orignalFileName;
                fileDownloadPath = saveToDirectory + File.separator + fileNameUuid;

                UserAttach userAttachNew = new UserAttach();
                userAttachNew.setUserAttachUuid(UUID.randomUUID().toString());
                userAttachNew.setUserUserUuid(userDto.getUserUuid());
                userAttachNew.setUserUserId(userDto.getUserUserId());
                userAttachNew.setUserAttachPath(fileDownloadPath);
                userAttachNew.setUserAttachTypeUuid(attachmentTypeUuid);
                userAttachNew.setUserAttachOrgFilenamePath(orignalFileName);
                userAttachNew.setActiveStatus(ActiveStatus.Y);
                userAttachNew.setUserAttachUpdateStatus("N");
                userAttachNew.setUserAttachAdminVerifyStatus("N");

                byte[] bytes = multipartFile.getBytes();
                if (multipartFile.getSize() <= 64000) {
                    userAttachNew.setUserAttachBlob(bytes);
                }
                userAttachNew = userAttachRepository.save(userAttachNew);
                Path path = Paths.get(fileDownloadPath);
                Files.write(path, bytes);
                return objTransformationService.transformUserAttachModelToUserAttachDto(userAttachNew);
            } else {
                throw new Exception("required configurations not defined in sys_parameters.");
            }
        } catch (Exception e) {
            logger.error("Error saving user attachment", e);
            throw new Exception("Error saving user attachment");
        }
    }


    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public List<UserAttachDto> findAllUserAttachments(String userUuid) throws Exception {
        // TODO Auto-generated method stub
        return objTransformationService.transformUserAttachModelsToUserAttachDtos(userAttachRepository.findAllActiveUserAttachments(userUuid));

    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Optional<UserAttachDto> findUserAttachmentsByAttachmentTypeUuid(UserDto userDto, String attachmentTypeUuid) throws Exception {
        // TODO Auto-generated method stub
        Optional<UserAttach> userAttachment = userAttachRepository.findUserAttachmentsByUserUuidAndAttachmentTypeUuid(userDto.getUserUuid(), attachmentTypeUuid);
        Optional<UserAttachDto> userAttachDtoOpt = Optional.empty();
        if (userAttachment.isPresent()) {
            UserAttachDto userAttach = objTransformationService.transformUserAttachModelToUserAttachDto(userAttachment.get());
            Path fileDiskPath = Paths.get(userAttach.getUserAttachPath());
            if (Files.exists(fileDiskPath)) {
                userAttach.setUserAttachBlob(Files.readAllBytes(Paths.get(userAttach.getUserAttachPath())));
                userAttach.setContentType(Files.probeContentType(Paths.get(userAttach.getUserAttachPath())));
            }
            userAttachDtoOpt = Optional.of(userAttach);
        }
        return userAttachDtoOpt;

    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void deleteUserAttachment(UserDto userDto, String attachmentTypeUuid) throws Exception {
        Optional<UserAttach> userAttachment = userAttachRepository.findUserAttachmentsByUserUuidAndAttachmentTypeUuid(userDto.getUserUuid(), attachmentTypeUuid);
        if (userAttachment.isPresent()) {
            UserAttach userAttach = userAttachment.get();
            userAttach.setActiveStatus(ActiveStatus.N);
            userAttach.setUserAttachUpdateStatus("Y");
            userAttachRepository.save(userAttach);
        }
    }

    @Override
    public void changePassword(ResetPasswordWrapperDTO resetPasswordWrapperDTO, String emailAddress) throws Exception {
        this.userRepository.changePasswordAndStatus(this.encryptionUtil.encode(resetPasswordWrapperDTO.getConfirmPassword()), emailAddress, resetPasswordWrapperDTO.getUserPasswordReset());
    }
}

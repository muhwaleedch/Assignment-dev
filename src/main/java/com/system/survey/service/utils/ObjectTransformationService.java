package com.system.survey.service.utils;

import com.system.survey.dto.address.AddressDto;
import com.system.survey.dto.metadata.AddressTypeDto;
import com.system.survey.dto.metadata.CountryDto;
import com.system.survey.dto.metadata.StateDto;
import com.system.survey.dto.metadata.UIMenuItemDetailsDto;
import com.system.survey.dto.survey.*;
import com.system.survey.dto.user.UserAttachDto;
import com.system.survey.dto.user.UserDto;
import com.system.survey.enums.ActiveStatus;
import com.system.survey.model.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ObjectTransformationService {

    public User transformUserDtoToUserModel(UserDto userDto) {
        User user = new User();
        user.setUserUuid(UUID.randomUUID().toString());
        user.setUserFirstName(userDto.getUserFirstName());
        user.setUserMiddleName(userDto.getUserMiddleName());
        user.setUserLastName(userDto.getUserLastName());
        user.setAddress(userDto.getAddress());
        //user.setUserActivatedDate(userDto.getUserActivatedDate().toLocalDate());
        user.setUserAuthUserId(userDto.getUserAuthUserId());
        user.setUserContactnumber(userDto.getUserContactnumber());
        user.setUserEmail(userDto.getUserEmail());
        //user.setUserExpirationDate(userDto.getUserExpirationDate());
        user.setUserGroupid(userDto.getUserGroupid());
        user.setUserjobId(userDto.getUserjobId());
        //user.setUserLastactivityDate(userDto.getUserLastactivityDate());
        user.setUserOrgId(userDto.getUserOrgId());
        user.setUserPassword(userDto.getUserPassword());
        user.setUserRoleId(userDto.getUserRoleId());
        user.setCreatedBy(userDto.getCreatedBy());
        user.setUserUserId(userDto.getUserUserId());
        user.setActiveStatus(ActiveStatus.Y);
        return user;
    }

    public UserDto transformUserModelToUserDto(User user) {

        UserDto userDto = new UserDto();
        userDto.setUserUuid(user.getUserUuid());
        userDto.setUserFirstName(user.getUserFirstName());
        userDto.setUserMiddleName(user.getUserMiddleName());
        userDto.setUserLastName(user.getUserLastName());
        userDto.setAddress(user.getAddress());
        //user.setUserActivatedDate(user.getUserActivatedDate().toLocalDate());
        userDto.setUserAuthUserId(user.getUserAuthUserId());
        userDto.setUserContactnumber(user.getUserContactnumber());
        userDto.setUserEmail(user.getUserEmail());
        //userDto.setUserExpirationDate(user.getUserExpirationDate());
        userDto.setUserGroupid(user.getUserGroupid());
        userDto.setUserjobId(user.getUserjobId());
        //userDto.setUserLastactivityDate(user.getUserLastactivityDate());
        userDto.setUserOrgId(user.getUserOrgId());
        userDto.setUserPassword(user.getUserPassword());
        userDto.setUserRoleId(user.getUserRoleId());
        userDto.setCreatedBy(user.getCreatedBy());
        userDto.setUserUserId(user.getUserUserId());
        userDto.setActiveStatus(user.getActiveStatus());
        userDto.setUserPasswordReset(user.getUserPasswordReset());
        return userDto;
    }

    public void transformUserDtoToExistingUserModel(UserDto userDto, User user) {
        if (userDto.getUserUuid() != null && !userDto.getUserUuid().isEmpty()) {
            user.setUserUuid(userDto.getUserUuid());
        }
        if (userDto.getUserFirstName() != null && !userDto.getUserFirstName().isEmpty()) {
            user.setUserFirstName(userDto.getUserFirstName());
        }
        if (userDto.getUserMiddleName() != null && !userDto.getUserMiddleName().isEmpty()) {
            user.setUserMiddleName(userDto.getUserMiddleName());
        }
        if (userDto.getUserLastName() != null && !userDto.getUserLastName().isEmpty()) {
            user.setUserLastName(userDto.getUserLastName());
        }
        if (userDto.getAddress() != null && !userDto.getAddress().isEmpty()) {
            user.setAddress(userDto.getAddress());
        }
        if (userDto.getUserAuthUserId() != null && !userDto.getUserAuthUserId().isEmpty()) {
            user.setUserAuthUserId(userDto.getUserAuthUserId());
        }
        if (userDto.getUserContactnumber() != null && !userDto.getUserContactnumber().isEmpty()) {
            user.setUserContactnumber(userDto.getUserContactnumber());
        }
        if (userDto.getUserEmail() != null && !userDto.getUserEmail().isEmpty()) {
            user.setUserEmail(userDto.getUserEmail());
        }
        if (userDto.getUserGroupid() != null && !userDto.getUserGroupid().isEmpty()) {
            user.setUserGroupid(userDto.getUserGroupid());
        }
        if (userDto.getUserjobId() != null && !userDto.getUserjobId().isEmpty()) {
            user.setUserjobId(userDto.getUserjobId());
        }
        if (userDto.getUserOrgId() != null && !userDto.getUserOrgId().isEmpty()) {
            user.setUserOrgId(userDto.getUserOrgId());
        }
        if (userDto.getUserPassword() != null && !userDto.getUserPassword().isEmpty()) {
            user.setUserPassword(userDto.getUserPassword());
        }
        if (userDto.getUserRoleId() != null && !userDto.getUserRoleId().isEmpty()) {
            user.setUserRoleId(userDto.getUserRoleId());
        }
        if (userDto.getUserUserId() != null && !userDto.getUserUserId().isEmpty()) {
            user.setUserUserId(userDto.getUserUserId());
        }
        if (userDto.getUpdatedBy() != null && !userDto.getUpdatedBy().isEmpty()) {
            user.setUpdatedBy(userDto.getUpdatedBy());
        }
        if (userDto.getUserPasswordReset() != null && !userDto.getUserPasswordReset().isEmpty()) {
            user.setUserPasswordReset(userDto.getUserPasswordReset());
        }
    }

    public List<CountryDto> transformCountryModelsToCountryDtos(List<Country> countryModels) {
        return countryModels.stream().map(this::transformCountryModelToCountryDto).collect(Collectors.toList());
    }

    public CountryDto transformCountryModelToCountryDto(Country country) {
        CountryDto countryDto = new CountryDto();
        countryDto.setCountryId(country.getCountriesId());
        countryDto.setCountriesUuid(country.getCountriesUuid());
        countryDto.setName(country.getName());
        countryDto.setIso3(country.getIso3());
        return countryDto;
    }

    public List<StateDto> transformStateModelsToStateDtos(List<State> stateModels) {
        return stateModels.stream().map(this::transformStateModelToStateDto).collect(Collectors.toList());
    }

    public StateDto transformStateModelToStateDto(State state) {
        StateDto stateDto = new StateDto();
        stateDto.setStatesId(state.getStatesId());
        stateDto.setStatesUuid(state.getStatesUuid());
        stateDto.setName(state.getName());
        return stateDto;
    }

    public List<AddressTypeDto> transformAddressTypeModelsToAddressTypeDtos(List<AddressType> addressTypeModels) {
        return addressTypeModels.stream().map(this::transformAddressTypeModelToAddressTypeDto).collect(Collectors.toList());
    }

    public AddressTypeDto transformAddressTypeModelToAddressTypeDto(AddressType addressType) {
        AddressTypeDto addressTypeDto = new AddressTypeDto();
        addressTypeDto.setAddressTypeId(addressType.getAddressTypeId());
        addressTypeDto.setAddressTypeName(addressType.getAddressTypeName());
        addressTypeDto.setAddressTypeUuid(addressType.getAddressTypeUuid());
        return addressTypeDto;
    }

    public Address transformAddressDtoToAddressModel(AddressDto address, Address addressObj) {
        if (addressObj == null)
            addressObj = new Address();

        addressObj.setAddressCity(address.getCity());
        addressObj.setAddressCountry(address.getCountryName());
        addressObj.setAddressCountryCode(address.getCountry());
        addressObj.setAddressLine1(address.getAddressLine1());
        addressObj.setAddressLine2(address.getAddressLine2());
        addressObj.setAddressLine3(address.getAddressLine3());
        addressObj.setAddressState(address.getStateName());
        addressObj.setAddressStateCode(address.getState());
        addressObj.setAddressTypeUuid(address.getAddressType());
        addressObj.setAddressZip(address.getZipcode());
        addressObj.setAddressUuid(address.getAddressUuid());
        addressObj.setActiveStatus(address.getActiveStatus());
        addressObj.setAddressSourceSystem(address.getAddressSourceSystem());
        addressObj.setAddressSourceType(address.getAddressSourceType());
        return addressObj;
    }

    public List<AddressDto> transformAddressModelsToAddressDtos(List<Address> addressModels) {
        return addressModels.stream().map(this::transformAddressModelToAddressDto).collect(Collectors.toList());
    }

    public AddressDto transformAddressModelToAddressDto(Address address) {
        AddressDto addressObj = new AddressDto();
        addressObj.setCity(address.getAddressCity());
        addressObj.setCountryName(address.getAddressCountry());
        addressObj.setCountry(address.getAddressCountryCode());
        addressObj.setAddressLine1(address.getAddressLine1());
        addressObj.setAddressLine2(address.getAddressLine2());
        addressObj.setAddressLine3(address.getAddressLine3());
        addressObj.setStateName(address.getAddressState());
        addressObj.setState(address.getAddressStateCode());
        addressObj.setAddressType(address.getAddressTypeUuid());
        addressObj.setZipcode(address.getAddressZip());
        addressObj.setAddressUuid(address.getAddressUuid());
        addressObj.setActiveStatus(address.getActiveStatus());
        addressObj.setAddressSourceSystem(address.getAddressSourceSystem());
        addressObj.setAddressSourceType(address.getAddressSourceType());
        return addressObj;
    }

    public List<UserAttachDto> transformUserAttachModelsToUserAttachDtos(List<UserAttach> userAttachModels) {
        return userAttachModels.stream().map(this::transformUserAttachModelToUserAttachDto).collect(Collectors.toList());
    }

    public UserAttachDto transformUserAttachModelToUserAttachDto(UserAttach userAttachModel) {
        UserAttachDto userAttachDto = new UserAttachDto();

        userAttachDto.setActiveStatus(userAttachModel.getActiveStatus());
        userAttachDto.setUserAttachBlob(userAttachModel.getUserAttachBlob());
        userAttachDto.setUserAttachId(userAttachModel.getUserAttachId());
        userAttachDto.setUserAttachPath(userAttachModel.getUserAttachPath());
        userAttachDto.setUserAttachUuid(userAttachModel.getUserUserUuid());
        userAttachDto.setUserUserId(userAttachModel.getUserUserId());
        userAttachDto.setUserUserUuid(userAttachModel.getUserUserUuid());
        userAttachDto.setUserAttachTypeUuid(userAttachModel.getUserAttachTypeUuid());
        userAttachDto.setUserAttachOrgFilenamePath(userAttachModel.getUserAttachOrgFilenamePath() != null ? userAttachModel.getUserAttachOrgFilenamePath() : "");
        return userAttachDto;
    }

    public List<UIMenuItemDetailsDto> transformUIMenuItemDetailModelsToDtos(List<UIMenuItemDetails> uiDetailModels) {
        return uiDetailModels.stream().map(this::transformUIMenuItemDetailModelToDto).collect(Collectors.toList());
    }

    public UIMenuItemDetailsDto transformUIMenuItemDetailModelToDto(UIMenuItemDetails b) {
        UIMenuItemDetailsDto a = new UIMenuItemDetailsDto();
        a.setUiMenuItemDetailsId(b.getUiMenuItemDetailsId());
        a.setUiMenuItemDetailsUuid(b.getUiMenuItemDetailsUuid());
        a.setUiMenuItemDetailsName(b.getUiMenuItemDetailsName());
        a.setUiMenuItemDetailsFrontDispName(b.getUiMenuItemDetailsFrontDispName());
        a.setUiMenuItemDetailsOnScreenDisplayOption(b.getUiMenuItemDetailsOnScreenDisplayOption());
        a.setUiMenuItemDetailsSortOrder(b.getUiMenuItemDetailsSortOrder());
        a.setUiMenuItemDetailsAttachmentTypeUuid(b.getUiMenuItemDetailsAttachmentTypeUuid());
        a.setUiMenuItemDetailsAttachmentTypeName(b.getUiMenuItemDetailsAttachmentTypeName());
        a.setUiMenuItemDetailsMenuId(b.getUiMenuItemDetailsMenuId());
        a.setUiMenuItemDetailsMenuUuid(b.getUiMenuItemDetailsMenuUuid());
        a.setUiMenuItemDetailsInpDefaultText(b.getUiMenuItemDetailsInpDefaultText());
        a.setUiMenuItemDetailsPermissionRoleUuid(b.getUiMenuItemDetailsPermissionRoleUuid());
        a.setUiMenuItemDetailsPermissionRoleName(b.getUiMenuItemDetailsPermissionRoleName());
        a.setUiMenuItemDetailsSizeInMb(b.getUiMenuItemDetailsSizeInMb());
        a.setUiMenuItemDetailsExtOfAttachments(b.getUiMenuItemDetailsExtOfAttachments());
        return a;
    }

    public List<IntSurveyDto> transformIntSurveyModelsToIntSurveyDtos(List<IntSurvey> b) {
        return b.stream().map(this::transformIntSurveyModelToIntSurveyDto).collect(Collectors.toList());
    }

    public IntSurveyDto transformIntSurveyModelToIntSurveyDto(IntSurvey b) {
        IntSurveyDto a = new IntSurveyDto();
        a.setIntSurveyId(b.getIntSurveyId());
        a.setIntSurveyDesc(b.getIntSurveyDesc());
        a.setIntSurveyName(b.getIntSurveyName());
        a.setIntSurveyShortdesc(b.getIntSurveyShortdesc());
        a.setIntSurveyUuid(b.getIntSurveyUuid());
        a.setActiveStatus(b.getActiveStatus());
        return a;
    }

    public List<IntSurvey> transformIntSurveyDtosToIntSurveyModels(List<IntSurveyDto> b) {
        return b.stream().map(this::transformIntSurveyDtoToIntSurveyModel).collect(Collectors.toList());
    }

    public IntSurvey transformIntSurveyDtoToIntSurveyModel(IntSurveyDto b) {
        IntSurvey a = new IntSurvey();
        a.setIntSurveyId(b.getIntSurveyId());
        a.setIntSurveyDesc(b.getIntSurveyDesc());
        a.setIntSurveyName(b.getIntSurveyName());
        a.setIntSurveyShortdesc(b.getIntSurveyShortdesc());
        a.setIntSurveyUuid(b.getIntSurveyUuid());
        a.setActiveStatus(b.getActiveStatus());
        return a;
    }

    public List<IntFormDto> transformIntFormModelsToIntFormDtos(List<IntForm> b) {
        return b.stream().map(this::transformIntFormModelToIntFormDto).collect(Collectors.toList());
    }

    public IntFormDto transformIntFormModelToIntFormDto(IntForm b) {
        IntFormDto a = new IntFormDto();
        a.setIntFormId(b.getIntFormId());
        a.setIntFormDesc(b.getIntFormDesc());
        a.setIntFormName(b.getIntFormName());
        a.setIntFormShortdesc(b.getIntFormShortdesc());
        a.setIntFormUuid(b.getIntFormUuid());
        a.setActiveStatus(b.getActiveStatus());
        a.setIntFormPageNoOfQuestions(b.getIntFormPageNoOfQuestions());
        return a;
    }

    public List<IntQuestionsDto> transformIntQuestionModelsToDtos(List<IntQuestion> b) {
        return b.stream().map(this::transformIntQuestionModelToDto).collect(Collectors.toList());
    }

    public IntForm transformIntFormDtoToModel(IntFormDto b) {
        IntForm a = new IntForm();
        a.setIntFormId(b.getIntFormId());
        a.setIntFormDesc(b.getIntFormDesc());
        a.setIntFormName(b.getIntFormName());
        a.setIntFormShortdesc(b.getIntFormShortdesc());
        a.setIntFormUuid(b.getIntFormUuid());
        a.setActiveStatus(b.getActiveStatus());
        a.setIntFormPageNoOfQuestions(b.getIntFormPageNoOfQuestions());
        return a;
    }

    public List<IntQuestion> transformIntQuestionDtosToModels(List<IntQuestionsDto> b) {
        return b.stream().map(this::transformIntQuestionDtoToModel).collect(Collectors.toList());
    }

    public IntQuestion transformIntQuestionDtoToModel(IntQuestionsDto b) {
        IntQuestion a = new IntQuestion();
        a.setIntQuestionId(b.getIntQuestionId());
        a.setIntQuestionBlob(b.getIntQuestionBlob());
        a.setIntQuestionCompletequestion(b.getIntQuestionCompletequestion());
        a.setIntQuestionIntQuestionTypeid(b.getIntQuestionIntQuestionTypeid());
        a.setIntQuestionIntQuestionTypeuuid(b.getIntQuestionIntQuestionTypeuuid());
        a.setIntQuestionName(b.getIntQuestionName());
        a.setIntQuestionUuid(b.getIntQuestionUuid());
        String parentQuestionUuid = b.getIntQuestionParentUuid() == null || b.getIntQuestionParentUuid().isEmpty() ? null : b.getIntQuestionParentUuid();
        a.setIntQuestionParentUuid(parentQuestionUuid);
        a.setIntQuestionUsagestatus(b.getIntQuestionUsagestatus());

        return a;
    }

    public IntQuestionsDto transformIntQuestionModelToDto(IntQuestion b) {
        IntQuestionsDto a = new IntQuestionsDto();
        a.setIntQuestionId(b.getIntQuestionId());
        a.setIntQuestionBlob(b.getIntQuestionBlob());
        a.setIntQuestionCompletequestion(b.getIntQuestionCompletequestion());
        a.setIntQuestionIntQuestionTypeid(b.getIntQuestionIntQuestionTypeid());
        a.setIntQuestionIntQuestionTypeuuid(b.getIntQuestionIntQuestionTypeuuid());
        a.setIntQuestionName(b.getIntQuestionName());
        a.setIntQuestionUuid(b.getIntQuestionUuid());
        a.setIntQuestionParentUuid(b.getIntQuestionParentUuid());
        a.setIntQuestionUsagestatus(b.getIntQuestionUsagestatus());

        return a;
    }

    public List<IntQuestionsAnsweroptionDto> transformIntQuestionAnswerModelToDto(List<IntQuestionAnsweroption> b) {
        return b.stream().map(this::transformIntQuestionAnswerModelToDto).collect(Collectors.toList());
    }

    public IntQuestionsAnsweroptionDto transformIntQuestionAnswerModelToDto(IntQuestionAnsweroption b) {
        IntQuestionsAnsweroptionDto a = new IntQuestionsAnsweroptionDto();
        a.setIntQuestionAnsweroptionId(b.getIntQuestionAnsweroptionId());
        a.setIntQuestionAnsweroptionAnswer(b.getIntQuestionAnsweroptionAnswer());
        a.setIntQuestionAnsweroptionIntQuestionId(b.getIntQuestionAnsweroptionIntQuestionId());
        a.setIntQuestionAnsweroptionIntQuestionUuid(b.getIntQuestionAnsweroptionIntQuestionUuid());
        a.setIntQuestionAnsweroptionUuid(b.getIntQuestionAnsweroptionUuid());
        return a;
    }

    public List<IntQuestionTypeDto> transformIntQuestionTypeModelsToDtos(List<IntQuestionType> b) {
        return b.stream().map(this::transformIntQuestionTypeModelToDto).collect(Collectors.toList());
    }

    public IntQuestionTypeDto transformIntQuestionTypeModelToDto(IntQuestionType b) {
        IntQuestionTypeDto a = new IntQuestionTypeDto();

        a.setIntQuestionTypeId(b.getIntQuestionTypeId());
        a.setIntQuestionTypeDesc(b.getIntQuestionTypeDesc());
        a.setIntQuestionTypeName(b.getIntQuestionTypeName());
        a.setIntQuestionTypeShortdesc(b.getIntQuestionTypeShortdesc());
        a.setIntQuestionTypeUuid(b.getIntQuestionTypeUuid());


        return a;
    }

    public IntQuestionUserreply transformReplyToIntQuestionUserReplyModel(String reply, IntQuestion question, UserDto userDto) {
        IntQuestionUserreply userReply = new IntQuestionUserreply();
        userReply.setIntQuestionUserreplyUuid(UUID.randomUUID().toString());
        userReply.setIntQuestionUserreplyQuestionUuid(question.getIntQuestionUuid());
        userReply.setIntQuestionUserreplyQuestionId(String.valueOf(question.getIntQuestionId()));
        userReply.setIntQuestionUserreplyUserId(userDto.getUserUserId());
        userReply.setIntQuestionUserreplyUserUuid(userDto.getUserUuid());
        userReply.setActiveStatus(ActiveStatus.Y);
        userReply.setIntQuestionUserreplyReply((String) reply);
        return userReply;
    }

    public List<IntQuestionUserreplyDto> transformIntQuestionUserreplyModelsToDtos(List<IntQuestionUserreply> b) {
        return b.stream().map(this::transformIntQuestionUserreplyModelToDto).collect(Collectors.toList());
    }

    public IntQuestionUserreplyDto transformIntQuestionUserreplyModelToDto(IntQuestionUserreply b) {
        IntQuestionUserreplyDto a = new IntQuestionUserreplyDto();
        a.setIntQuestionUserreplyId(b.getIntQuestionUserreplyId());
        a.setIntQuestionUserreplyQuestionId(b.getIntQuestionUserreplyQuestionId());
        a.setIntQuestionUserreplyQuestionUuid(b.getIntQuestionUserreplyQuestionUuid());
        a.setIntQuestionUserreplyReply(b.getIntQuestionUserreplyReply());
        a.setIntQuestionUserreplyUserId(b.getIntQuestionUserreplyUserId());
        a.setIntQuestionUserreplyUserUuid(b.getIntQuestionUserreplyUserUuid());
        a.setIntQuestionUserreplyUuid(b.getIntQuestionUserreplyUuid());

        return a;
    }

    public IntFormJsonDto transformIntFormJsonModelToDto(IntFormJson b) {
        IntFormJsonDto a = new IntFormJsonDto();
        a.setIntFormJsonId(b.getIntFormJsonId());
        a.setIntFormJsonFormid(b.getIntFormJsonFormid());
        a.setIntFormJsonFormuuid(b.getIntFormJsonFormuuid());
        a.setIntFormJsonString(b.getIntFormJsonString());
        a.setIntFormJsonSubmittimes(b.getIntFormJsonSubmittimes());
        a.setIntFormJsonSurveyid(b.getIntFormJsonSurveyid());
        a.setIntFormJsonSurveyuuid(b.getIntFormJsonSurveyuuid());
        a.setIntFormJsonUseruuid(b.getIntFormJsonUseruuid());
        a.setIntFormJsonUuid(b.getIntFormJsonUuid());
        a.setIntFormJsonFormDefaultName(b.getIntFormJsonFormDefaultName());

        return a;
    }
}

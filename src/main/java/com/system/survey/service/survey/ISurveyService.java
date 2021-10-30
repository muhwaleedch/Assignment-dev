package com.system.survey.service.survey;

import com.system.survey.dto.survey.*;
import com.system.survey.dto.user.UserDto;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface ISurveyService {

    List<IntSurveyDto> findAllActiveSurveys();

    List<IntFormDto> findIntFormsBySurveyUuid(String surveyUuid);

    List<IntQuestionsDto> findIntQuestionsByFormUuid(UserDto userDto, String formUuid);

    void addUpdateUserSurveyResponse(UserDto userDto, Map<String, Object> surveyResponses, String formUuid, String formName, String surveyUuid) throws Exception;

    IntSurveyDto saveUpdateSurveyInformation(IntSurveyDto surveyDto) throws Exception;

    Optional<IntFormJsonDto> findIntFormJsonByFormName(String formName, UserDto userDto) throws Exception;

    void deleteSurveyInformation(String surveyUuid) throws Exception;

    IntFormDto saveIntForm(IntFormDto intFormDto) throws Exception;

    List<IntFormDto> findAllActiveIntFormList();

    void deleteFormInformation(String formUuid) throws Exception;

    List<IntQuestionsDto> findAllActiveParentIntQuestionList();

    List<IntQuestionTypeDto> findAllActiveQuestionTypes();

    IntQuestionsDto saveIntQuestion(IntQuestionsDto intQuestionsDto);

    List<IntQuestionsDto> findAllActiveIntQuestionList();

    void deleteIntQuestion(String questionUuid) throws Exception;

    void generatePdf(UserDto userDto, String formUuid) throws Exception;

    void saveSurveyFormAssociation(String surveyUuid, List<String> formUuids) throws Exception;

}

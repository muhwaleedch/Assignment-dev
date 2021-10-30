package com.system.survey.repository.survey;

import com.system.survey.model.IntQuestionSurveyForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IntQuestionSurveyFormRepository extends JpaRepository<IntQuestionSurveyForm, Long> {

    @Query(nativeQuery = true, value = "select * from int_question_survey_form where int_question_survey_form_formuuid= :formUuid and int_question_survey_form_surveyuuid = :surveyUuid and active_status = 'Y'")
    Optional<IntQuestionSurveyForm> findIntQuestionSurveyFormByFormUuidSurveyUuid(@Param("formUuid") String formUuid, @Param("surveyUuid") String surveyUuid);

    @Modifying
    @Query(nativeQuery = true, value = "update int_question_survey_form set active_status = 'N' WHERE int_question_survey_form_surveyuuid= :surveyUuid and active_status = 'Y'")
    void updateIntQuestionSurveyFormToInActive(@Param("surveyUuid") String surveyUuid);

    @Query(nativeQuery = true, value = "select * from int_question_survey_form where int_question_survey_form_formuuid= :formUuid and active_status = 'Y'")
    List<IntQuestionSurveyForm> findIntQuestionSurveyFormByFormUuid(@Param("formUuid") String formUuid);

    @Query(nativeQuery = true, value = "select * from int_question_survey_form where int_question_survey_form_surveyuuid= :surveyUuid and active_status = 'Y'")
    List<IntQuestionSurveyForm> findIntQuestionSurveyFormBySurveyUuid(@Param("surveyUuid") String surveyUuid);

}

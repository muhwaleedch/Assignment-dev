package com.system.survey.repository.survey;

import com.system.survey.model.IntForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IntFormRepository extends JpaRepository<IntForm, Long> {

    @Query(value = "select i.* from int_form i JOIN int_question_survey_form iqs ON (i.int_form_uuid = iqs.int_question_survey_form_formuuid) where iqs.int_question_survey_form_surveyuuid= :surveyUuid and i.active_status = 'Y' and iqs.active_status = 'Y' ", nativeQuery = true)
    List<IntForm> findIntFormByIntSurveyUuid(@Param("surveyUuid") String surveyUuid);

    @Query(nativeQuery = true, value = "select * from int_form where int_form_uuid = :intFormUuid and active_status = 'Y'")
    Optional<IntForm> findIntFormByIntFormUuid(@Param("intFormUuid") String intFormUuid);

    @Query(nativeQuery = true, value = "select * from int_form where active_status = 'Y' ")
    List<IntForm> findAllActiveIntForm();
}

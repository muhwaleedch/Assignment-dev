package com.system.survey.repository.survey;

import com.system.survey.model.IntSurvey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IntSurveyRepository extends JpaRepository<IntSurvey, Long> {

    @Query(value = "select * from int_survey where active_status = 'Y' ", nativeQuery = true)
    List<IntSurvey> findAllActiveSurveys();

    @Query(value = "select * from int_survey where int_survey_uuid= :surveyUuid and active_status = 'Y' ", nativeQuery = true)
    Optional<IntSurvey> findIntSurveyBySurveyUuid(@Param("surveyUuid") String surveyUuid);
}

package com.system.survey.repository.survey;

import com.system.survey.model.IntFormJson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IntFormJsonRepository extends JpaRepository<IntFormJson, Long> {

    @Query(nativeQuery = true, value = "select * from int_form_Json where int_form_Json_surveyuuid= :surveyUuid  AND int_form_Json_formuuid= :formUuid AND int_form_Json_useruuid= :userUuid and active_status = 'Y' ")
    Optional<IntFormJson> findFormJsonByUserUuidFormUuidSurveyUuid(@Param("surveyUuid") String surveyUuid, @Param("formUuid") String formUuid, @Param("userUuid") String userUuid);

    @Query(nativeQuery = true, value = "select * from int_form_Json where int_form_Json_formDefaultname= :formName AND int_form_Json_useruuid= :userUuid and active_status = 'Y' ")
    Optional<IntFormJson> findFormJsonByFormNameUserUuid(@Param("formName") String formName, @Param("userUuid") String userUuid);

}

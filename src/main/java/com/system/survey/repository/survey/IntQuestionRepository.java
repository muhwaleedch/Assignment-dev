package com.system.survey.repository.survey;

import com.system.survey.model.IntQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IntQuestionRepository extends JpaRepository<IntQuestion, Long> {

    @Query(nativeQuery = true, value = "select iq.* from int_question iq JOIN int_question_form_question ifq ON (iq.int_question_uuid = ifq.int_question_form_question_questionuuid) where ifq.int_question_form_question_formuuid = :formUuid and int_question_parentuuid is null and iq.active_status = 'Y' and ifq.active_status = 'Y' ")
    List<IntQuestion> findIntQuestionsByIntFormUuid(@Param("formUuid") String formUuid);

    @Query(nativeQuery = true, value = "select * from int_question where int_question_uuid = :questionUuid and active_status = 'Y'")
    Optional<IntQuestion> findIntQuestionByQuestionUuid(@Param("questionUuid") String intQuestionIntQuestionTypeuuid);

    @Query(nativeQuery = true, value = "select * from int_question where int_question_parentuuid = :parentUuid and active_status = 'Y'")
    List<IntQuestion> findIntQuestionsByIntQuestionParentUuid(@Param("parentUuid") String parentUuid);

    @Query(nativeQuery = true, value = "select * from int_question where int_question_int_question_typeuuid IN (select distinct int_question_type_uuid from int_question_type where int_question_type_name = 'parent_question' and active_status='Y') AND active_status = 'Y'")
    List<IntQuestion> findAllActiveParentIntQuestions();

    @Query(nativeQuery = true, value = "select * from int_question where active_status = 'Y'")
    List<IntQuestion> findAllActiveIntQuestions();

}

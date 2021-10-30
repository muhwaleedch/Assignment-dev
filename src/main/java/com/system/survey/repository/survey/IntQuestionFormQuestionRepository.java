package com.system.survey.repository.survey;

import com.system.survey.model.IntQuestionFormQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IntQuestionFormQuestionRepository extends JpaRepository<IntQuestionFormQuestion, Long> {

    @Modifying
    @Query(nativeQuery = true, value = "update int_question_form_question set active_status = 'N' where int_question_form_question_questionuuid = :questionUuid")
    public void updateInActiveIntQuestionFormQuestionByQuestionUuid(@Param("questionUuid") String questionUuid);

    @Query(nativeQuery = true, value = "select * from int_question_form_question where active_status = 'Y' and int_question_form_question_questionuuid = :questionUuid")
    public List<IntQuestionFormQuestion> findIntQuestionFromQuestionByQuestionUuid(@Param("questionUuid") String questionUuid);

}

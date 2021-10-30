package com.system.survey.repository.survey;

import com.system.survey.model.IntQuestionAnsweroption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IntQuestionAnsweroptionRepository extends JpaRepository<IntQuestionAnsweroption, Long> {

    @Query(nativeQuery = true, value = "select qa.* from int_question_answeroption qa where qa.int_question_answeroption_int_question_uuid = :questionUuid and qa.active_status = 'Y'")
    List<IntQuestionAnsweroption> findQuestionAnserOptionsByQuestionUuid(@Param("questionUuid") String questionUuid);

    @Modifying
    @Query(nativeQuery = true, value = " update int_question_answeroption set active_status = 'N' where active_status = 'Y' and int_question_answeroption_int_question_uuid = :questionUuid")
    void updateInActiveQuestionAnswerOptoinsByQuestionUuid(@Param("questionUuid") String questionUuid);
}

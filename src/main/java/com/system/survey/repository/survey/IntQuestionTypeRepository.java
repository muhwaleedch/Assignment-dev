package com.system.survey.repository.survey;

import com.system.survey.model.IntQuestionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IntQuestionTypeRepository extends JpaRepository<IntQuestionType, Long> {

    @Query(nativeQuery = true, value = "select * from int_question_type where int_question_type_uuid = :questionTypeUuid and active_status = 'Y'")
    Optional<IntQuestionType> findIntQuestionTypeByIntQuestionTypeUuid(@Param("questionTypeUuid") String questionTypeUuid);

    @Query(nativeQuery = true, value = "select * from int_question_type where active_status = 'Y'")
    List<IntQuestionType> findAllActiveQuestionTypes();

}

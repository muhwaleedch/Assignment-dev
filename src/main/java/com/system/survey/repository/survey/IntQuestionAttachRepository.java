package com.system.survey.repository.survey;

import com.system.survey.model.IntQuestionAttach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IntQuestionAttachRepository extends JpaRepository<IntQuestionAttach, Long> {

    @Query(nativeQuery = true, value = "select * from int_question_attach where int_question_useruuid= :userUuid and int_question_attach_questionuuid= :questionUuid and active_status='Y' ")
    Optional<IntQuestionAttach> findQuestionAttachmentByQuestionUuidUserUuid(@Param("questionUuid") String questionUuid, @Param("userUuid") String userUuid);

}

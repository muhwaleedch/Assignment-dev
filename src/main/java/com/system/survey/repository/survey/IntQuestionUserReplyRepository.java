package com.system.survey.repository.survey;

import com.system.survey.model.IntQuestionUserreply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IntQuestionUserReplyRepository extends JpaRepository<IntQuestionUserreply, Long> {

    @Query(nativeQuery = true, value = "select * from int_question_userreply where int_question_userreply_user_uuid = :userUuid and int_question_userreply_question_uuid= :questionUuid and active_status = 'Y';")
    List<IntQuestionUserreply> findIntQuestionUserReplyByUserUuidAndQuestionUuid(@Param("userUuid") String userUuid, @Param("questionUuid") String questionUuid);

}

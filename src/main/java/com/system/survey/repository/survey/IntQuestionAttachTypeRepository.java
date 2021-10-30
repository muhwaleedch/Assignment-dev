package com.system.survey.repository.survey;

import com.system.survey.model.IntQuestionAttachType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IntQuestionAttachTypeRepository extends JpaRepository<IntQuestionAttachType, Long> {

    @Query(nativeQuery = true, value = "select * from int_question_attach_type where int_question_attach_type_name= :name and active_status = 'Y' ")
    Optional<IntQuestionAttachType> findIntQuestionAttachTypeByIntQuestionAttachTypeName(@Param("name") String name);

}

package com.system.survey.repository.user;

import com.system.survey.model.UserAttachType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserAttachTypeRepository extends JpaRepository<UserAttachType, Long> {

    Optional<UserAttachType> findUserAttachTypeByUserAttachTypeName(String userAttachTypeName);

}

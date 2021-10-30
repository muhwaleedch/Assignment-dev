package com.system.survey.repository.user;

import com.system.survey.model.UserType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserTypeRepository extends JpaRepository<UserType, Long> {

    Optional<UserType> findUserTypeByUserTypeName(String userTypeName);

    Optional<UserType> findByUserTypeUuid(String userTypeUuid);

}

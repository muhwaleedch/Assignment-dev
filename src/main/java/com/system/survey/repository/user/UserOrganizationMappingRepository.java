package com.system.survey.repository.user;

import com.system.survey.model.UserOrganizationMapping;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserOrganizationMappingRepository extends JpaRepository<UserOrganizationMapping, Long> {

    Optional<UserOrganizationMapping> findUserOrganizationMappingByUserId(String userId);

}

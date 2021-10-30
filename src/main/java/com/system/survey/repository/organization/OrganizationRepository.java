package com.system.survey.repository.organization;

import com.system.survey.enums.ActiveStatus;
import com.system.survey.model.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Long> {

    Optional<Organization> findByOrganizationNameAndActiveStatus(String organizationName, ActiveStatus activeStatus);

    Optional<Organization> findByOrganizationUuidAndActiveStatus(String organizationUuid, ActiveStatus activeStatus);

    Optional<Organization> findByOrganizationUuid(String organizationUuid);

    List<Organization> findAllByActiveStatus(ActiveStatus activeStatus);

}

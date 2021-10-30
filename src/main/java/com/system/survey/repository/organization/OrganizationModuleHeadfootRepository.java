package com.system.survey.repository.organization;

import com.system.survey.model.OrganizationModuleHeadfoot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrganizationModuleHeadfootRepository extends JpaRepository<OrganizationModuleHeadfoot, Long> {

    @Query(nativeQuery = true, value = "select * from organization_module_Headfoot where active_status='Y' and organization_module_Headfoot_orgName =:orgName and organization_module_Headfoot_outputtype =:outputType")
    Optional<OrganizationModuleHeadfoot> findOrganizationModuleHeadfootByOrgNameAndOutputType(@Param("orgName") String orgName, @Param("outputType") String outputType);

}

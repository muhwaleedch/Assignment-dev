package com.system.survey.repository.user;

import com.system.survey.model.UserAttach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserAttachRepository extends JpaRepository<UserAttach, Long> {

    @Query(value = "select ua.* from user_attach ua join user_attach_type uat ON (ua.user_attach_type_uuid = uat.user_attach_type_uuid) where ua.user_useruuid = :userUuid and ua.active_status = 'Y'and uat.user_attach_type_name <> 'profile' ", nativeQuery = true)
    List<UserAttach> findAllActiveUserAttachments(@Param("userUuid") String userUuid);

    @Query(value = "select * from user_attach where user_useruuid = :userUuid and user_attach_type_uuid = :userAttachTypeUuid and active_status = 'Y' ", nativeQuery = true)
    Optional<UserAttach> findUserAttachmentsByUserUuidAndAttachmentTypeUuid(@Param("userUuid") String userUuid, @Param("userAttachTypeUuid") String userAttachTypeUuid);
}

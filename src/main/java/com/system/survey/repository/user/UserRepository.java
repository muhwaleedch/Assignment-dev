package com.system.survey.repository.user;

import com.system.survey.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findUserByUserUuid(String userUuid);

    Optional<User> findUserByUserAuthUserId(String userAuthUserId);

    Optional<User> findUserByUserUserId(String userUserId);

    @Query(value = "select u.* from user u JOIN userorganizationmapping uom ON (u.user_uuid = uom.userId) JOIN user_type ut ON (uom.usertypeid = ut.user_type_uuid) where ut.user_type_name = :surveyuser and u.user_user_id = :userUserId", nativeQuery = true)
    Optional<User> findUserByUserUserId(@Param("surveyuser") String surveyUser, @Param("userUserId") String userUserId);

    Optional<User> findUserByUserContactnumber(String phoneNumber);

    @Transactional
    @Modifying
    @Query(value = "UPDATE user SET user_password = :updatedPassword, user_password_reset = :status WHERE user_email = :emailAddress", nativeQuery = true)
    void changePasswordAndStatus(@Param("updatedPassword") String updatedPassword, @Param("emailAddress") String emailAddress, @Param("status") String status);
}

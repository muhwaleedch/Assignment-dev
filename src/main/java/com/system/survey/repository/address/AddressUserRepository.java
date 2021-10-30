package com.system.survey.repository.address;

import com.system.survey.model.AddressUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface AddressUserRepository extends JpaRepository<AddressUser, Long> {

    @Query(value = "SELECT * FROM address_user WHERE address_uuid = :addressUuid AND user_uuid = :userUuid", nativeQuery = true)
    Optional<AddressUser> findAddressUserByAddressUuidAndUserUuid(@Param("addressUuid") String addressUuid, @Param("userUuid") String userUuid);

    @Modifying
    @Query(value = "delete from address_user where address_uuid = :addressUuid", nativeQuery = true)
    void deleteAddressUserByAddressUuid(@Param("addressUuid") String addressUuid);
}

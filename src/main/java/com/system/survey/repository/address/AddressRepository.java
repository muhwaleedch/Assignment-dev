package com.system.survey.repository.address;

import com.system.survey.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AddressRepository extends JpaRepository<Address, Long> {

    Optional<Address> findByAddressUuid(String addressUuid);

    @Query(value = "select a.* from address a join address_user au ON (a.address_uuid = au.address_uuid) where a.active_status = 'Y' and au.user_uuid = (select user_uuid from user u where u.user_user_id = :userUserId)", nativeQuery = true)
    List<Address> findAddressByUserUserId(@Param("userUserId") String userUserId);

    @Modifying
    @Query(value = "delete from address where address_uuid = :addressUuid", nativeQuery = true)
    void deleteAddressByAddressUuid(@Param("addressUuid") String addressUuid);
}

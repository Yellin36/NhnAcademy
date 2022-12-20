package com.nhnacademy.office.repository.household_movement_address;

import com.nhnacademy.office.domain.household_movement_address.HouseholdMovementAddressDto;
import com.nhnacademy.office.entity.HouseholdMovementAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface HouseholdMovementAddressRepositoryCustom  {
    List<HouseholdMovementAddressDto> getByHouseholdSerialNumber(Long householdSerialNumber);

}

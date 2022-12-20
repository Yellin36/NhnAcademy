package com.nhnacademy.office.service.household_movement_address;

import com.nhnacademy.office.domain.household_movement_address.HouseholdMovementAddressModifyRequest;
import com.nhnacademy.office.domain.household_movement_address.HouseholdMovementAddressRegisterRequest;
import com.nhnacademy.office.entity.HouseholdMovementAddress;

import java.time.LocalDate;

public interface HouseholdMovementAddressService {
    HouseholdMovementAddress registerHouseholdMovementAddress(Long householdSerialNumber, HouseholdMovementAddressRegisterRequest request);

    void updateHouseholdMovementAddress(Long householdSerialNumber, LocalDate reportDate, HouseholdMovementAddressModifyRequest request);

    void deleteHouseholdMovementAddress(Long householdSerialNumber, LocalDate reportDate);
}

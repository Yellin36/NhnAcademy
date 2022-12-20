package com.nhnacademy.office.service.household;

import com.nhnacademy.office.domain.household.HouseholdRegisterRequest;
import com.nhnacademy.office.entity.Household;

public interface HouseholdService {
    Household registerHousehold(HouseholdRegisterRequest request);

    void deleteHousehold(Long householdSerialNumber);
}

package com.nhnacademy.office.service.household_composition_resident;

import com.nhnacademy.office.domain.household_composition_resident.HouseholdCompositionResidentRegisterRequest;
import com.nhnacademy.office.entity.HouseholdCompositionResident;
import org.springframework.transaction.annotation.Transactional;

public interface HouseholdCompositionResidentService {

    HouseholdCompositionResident registerHouseholdCompositionResident(Long householdSerialNumber, HouseholdCompositionResidentRegisterRequest request);

    void deleteHouseholdCompositionResident(Long householdSerialNumber, Long residentSerialNumber);
}

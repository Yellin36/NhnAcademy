package com.nhnacademy.office.repository.household_composition_resident;

import com.nhnacademy.office.domain.household_composition_resident.HouseholdCompositionResidentDto;
import com.nhnacademy.office.entity.HouseholdCompositionResident;
import com.nhnacademy.office.entity.Resident;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface HouseholdCompositionResidentRepositoryCustom {
    boolean existsByResident(Resident resident);

    List<HouseholdCompositionResidentDto> getByHouseholdSerialNumber(Long householdSerialNumber);
}

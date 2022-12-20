package com.nhnacademy.office.repository.household_composition_resident;

import com.nhnacademy.office.entity.HouseholdCompositionResident;
import com.nhnacademy.office.entity.Resident;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;


public interface HouseholdCompositionResidentRepository extends HouseholdCompositionResidentRepositoryCustom,
        JpaRepository<HouseholdCompositionResident, HouseholdCompositionResident.Pk> {
    boolean existsByPk(HouseholdCompositionResident.Pk pk);

    boolean existsByResident(Resident resident);

    int countByPk_HouseholdSerialNumber(Long householdSerialNumber);

    @Transactional
    void deleteByPk(HouseholdCompositionResident.Pk pk);
}

package com.nhnacademy.office.repository.household;

import com.nhnacademy.office.entity.Household;
import com.nhnacademy.office.entity.Resident;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface HouseholdRepository extends JpaRepository<Household, Long> {
    boolean existsByHouseholdSerialNumber(Long householdSerialNumber);

    boolean existsByHouseholdResident(Resident householdResident);

    Optional<Household> findByHouseholdResident(Resident householdResident);

    Optional<Household> findByHouseholdSerialNumber(Long householdSerialNumber);

    @Transactional
    void deleteByHouseholdSerialNumber(Long householdSerialNumber);
}

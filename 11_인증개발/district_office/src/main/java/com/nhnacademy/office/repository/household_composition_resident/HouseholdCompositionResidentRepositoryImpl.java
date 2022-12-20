package com.nhnacademy.office.repository.household_composition_resident;

import com.nhnacademy.office.domain.household_composition_resident.HouseholdCompositionResidentDto;
import com.nhnacademy.office.domain.household_composition_resident.QHouseholdCompositionResidentDto;
import com.nhnacademy.office.entity.HouseholdCompositionResident;
import com.nhnacademy.office.entity.QHouseholdCompositionResident;
import com.nhnacademy.office.entity.QResident;
import com.nhnacademy.office.entity.Resident;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public class HouseholdCompositionResidentRepositoryImpl extends QuerydslRepositorySupport implements HouseholdCompositionResidentRepositoryCustom {

    public HouseholdCompositionResidentRepositoryImpl() {
        super(HouseholdCompositionResident.class);
    }

    @Override
    public boolean existsByResident(Resident resident) {
        QHouseholdCompositionResident householdCompositionResident = QHouseholdCompositionResident.householdCompositionResident;

        long count = from(householdCompositionResident)
                .where(householdCompositionResident.household.householdResident.eq(resident)
                        .or(householdCompositionResident.resident.eq(resident)))
                .select(householdCompositionResident.count())
                .fetchCount();
        return count > 0;
    }

    @Override
    public List<HouseholdCompositionResidentDto> getByHouseholdSerialNumber(Long householdSerialNumber) {
        QHouseholdCompositionResident householdCompositionResident = QHouseholdCompositionResident.householdCompositionResident;
        QResident resident = QResident.resident;

        return from(householdCompositionResident)
                .rightJoin(householdCompositionResident.resident, resident)
                .select(new QHouseholdCompositionResidentDto(
                        householdCompositionResident.householdRelationshipCode,
                        resident.name,
                        resident.residentRegistrationNumber,
                        householdCompositionResident.reportDate,
                        householdCompositionResident.householdCompositionChangeReasonCode
                ))
                .where(householdCompositionResident.household.householdSerialNumber.eq(householdSerialNumber))
                .fetch();
    }
}

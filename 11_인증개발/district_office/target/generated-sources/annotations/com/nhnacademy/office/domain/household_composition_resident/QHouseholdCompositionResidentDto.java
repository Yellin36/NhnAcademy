package com.nhnacademy.office.domain.household_composition_resident;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.nhnacademy.office.domain.household_composition_resident.QHouseholdCompositionResidentDto is a Querydsl Projection type for HouseholdCompositionResidentDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QHouseholdCompositionResidentDto extends ConstructorExpression<HouseholdCompositionResidentDto> {

    private static final long serialVersionUID = 316719804L;

    public QHouseholdCompositionResidentDto(com.querydsl.core.types.Expression<String> householdRelationshipCode, com.querydsl.core.types.Expression<String> name, com.querydsl.core.types.Expression<String> registrationNumber, com.querydsl.core.types.Expression<java.time.LocalDate> reportDate, com.querydsl.core.types.Expression<String> householdCompositionChangeReasonCode) {
        super(HouseholdCompositionResidentDto.class, new Class<?>[]{String.class, String.class, String.class, java.time.LocalDate.class, String.class}, householdRelationshipCode, name, registrationNumber, reportDate, householdCompositionChangeReasonCode);
    }

}


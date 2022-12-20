package com.nhnacademy.office.domain.household_movement_address;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.nhnacademy.office.domain.household_movement_address.QHouseholdMovementAddressDto is a Querydsl Projection type for HouseholdMovementAddressDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QHouseholdMovementAddressDto extends ConstructorExpression<HouseholdMovementAddressDto> {

    private static final long serialVersionUID = 1626699600L;

    public QHouseholdMovementAddressDto(com.querydsl.core.types.Expression<java.time.LocalDate> houseMovementReportDate, com.querydsl.core.types.Expression<String> houseMovementAddress, com.querydsl.core.types.Expression<String> lastAddressYn) {
        super(HouseholdMovementAddressDto.class, new Class<?>[]{java.time.LocalDate.class, String.class, String.class}, houseMovementReportDate, houseMovementAddress, lastAddressYn);
    }

}


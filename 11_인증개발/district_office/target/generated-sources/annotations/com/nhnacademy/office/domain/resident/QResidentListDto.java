package com.nhnacademy.office.domain.resident;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.nhnacademy.office.domain.resident.QResidentListDto is a Querydsl Projection type for ResidentListDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QResidentListDto extends ConstructorExpression<ResidentListDto> {

    private static final long serialVersionUID = -651089932L;

    public QResidentListDto(com.querydsl.core.types.Expression<Long> residentSerialNumber, com.querydsl.core.types.Expression<String> name, com.querydsl.core.types.Expression<String> genderCode, com.querydsl.core.types.Expression<String> residentRegistrationNumber, com.querydsl.core.types.Expression<String> registrationBaseAddress) {
        super(ResidentListDto.class, new Class<?>[]{long.class, String.class, String.class, String.class, String.class}, residentSerialNumber, name, genderCode, residentRegistrationNumber, registrationBaseAddress);
    }

}


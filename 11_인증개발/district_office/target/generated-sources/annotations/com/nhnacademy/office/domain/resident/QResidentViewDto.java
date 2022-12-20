package com.nhnacademy.office.domain.resident;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.nhnacademy.office.domain.resident.QResidentViewDto is a Querydsl Projection type for ResidentViewDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QResidentViewDto extends ConstructorExpression<ResidentViewDto> {

    private static final long serialVersionUID = -378827635L;

    public QResidentViewDto(com.querydsl.core.types.Expression<String> name, com.querydsl.core.types.Expression<String> residentRegistrationNumber, com.querydsl.core.types.Expression<String> genderCode, com.querydsl.core.types.Expression<Integer> birthReportCode, com.querydsl.core.types.Expression<Integer> deathReportCode) {
        super(ResidentViewDto.class, new Class<?>[]{String.class, String.class, String.class, int.class, int.class}, name, residentRegistrationNumber, genderCode, birthReportCode, deathReportCode);
    }

}


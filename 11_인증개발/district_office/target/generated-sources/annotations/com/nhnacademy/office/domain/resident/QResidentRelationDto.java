package com.nhnacademy.office.domain.resident;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.nhnacademy.office.domain.resident.QResidentRelationDto is a Querydsl Projection type for ResidentRelationDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QResidentRelationDto extends ConstructorExpression<ResidentRelationDto> {

    private static final long serialVersionUID = -856819626L;

    public QResidentRelationDto(com.querydsl.core.types.Expression<String> role, com.querydsl.core.types.Expression<String> name, com.querydsl.core.types.Expression<java.time.LocalDateTime> birthDate, com.querydsl.core.types.Expression<String> registrationNumber, com.querydsl.core.types.Expression<String> genderCode) {
        super(ResidentRelationDto.class, new Class<?>[]{String.class, String.class, java.time.LocalDateTime.class, String.class, String.class}, role, name, birthDate, registrationNumber, genderCode);
    }

}


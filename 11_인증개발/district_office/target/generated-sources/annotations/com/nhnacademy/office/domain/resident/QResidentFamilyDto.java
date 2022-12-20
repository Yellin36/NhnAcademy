package com.nhnacademy.office.domain.resident;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.nhnacademy.office.domain.resident.QResidentFamilyDto is a Querydsl Projection type for ResidentFamilyDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QResidentFamilyDto extends ConstructorExpression<ResidentFamilyDto> {

    private static final long serialVersionUID = 1257088686L;

    public QResidentFamilyDto(com.querydsl.core.types.Expression<String> name, com.querydsl.core.types.Expression<String> registrationNumber) {
        super(ResidentFamilyDto.class, new Class<?>[]{String.class, String.class}, name, registrationNumber);
    }

}


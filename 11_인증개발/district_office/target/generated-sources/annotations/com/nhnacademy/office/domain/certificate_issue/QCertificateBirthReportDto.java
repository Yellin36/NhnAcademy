package com.nhnacademy.office.domain.certificate_issue;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.nhnacademy.office.domain.certificate_issue.QCertificateBirthReportDto is a Querydsl Projection type for CertificateBirthReportDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QCertificateBirthReportDto extends ConstructorExpression<CertificateBirthReportDto> {

    private static final long serialVersionUID = -171604347L;

    public QCertificateBirthReportDto(com.querydsl.core.types.Expression<java.time.LocalDate> birthDeathReportDate, com.querydsl.core.types.Expression<String> name, com.querydsl.core.types.Expression<String> genderCode, com.querydsl.core.types.Expression<java.time.LocalDateTime> birthDate, com.querydsl.core.types.Expression<String> birthPlaceCode, com.querydsl.core.types.Expression<String> registrationBaseAddress, com.querydsl.core.types.Expression<String> reportResidentName, com.querydsl.core.types.Expression<String> reportResidentRegistrationNumber, com.querydsl.core.types.Expression<String> birthReportQualificationsCode, com.querydsl.core.types.Expression<String> email, com.querydsl.core.types.Expression<String> phoneNumber) {
        super(CertificateBirthReportDto.class, new Class<?>[]{java.time.LocalDate.class, String.class, String.class, java.time.LocalDateTime.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class}, birthDeathReportDate, name, genderCode, birthDate, birthPlaceCode, registrationBaseAddress, reportResidentName, reportResidentRegistrationNumber, birthReportQualificationsCode, email, phoneNumber);
    }

}


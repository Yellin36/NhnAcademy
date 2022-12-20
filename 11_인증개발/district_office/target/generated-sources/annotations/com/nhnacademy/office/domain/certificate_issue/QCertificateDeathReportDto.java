package com.nhnacademy.office.domain.certificate_issue;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.nhnacademy.office.domain.certificate_issue.QCertificateDeathReportDto is a Querydsl Projection type for CertificateDeathReportDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QCertificateDeathReportDto extends ConstructorExpression<CertificateDeathReportDto> {

    private static final long serialVersionUID = 2091451504L;

    public QCertificateDeathReportDto(com.querydsl.core.types.Expression<java.time.LocalDate> birthDeathReportDate, com.querydsl.core.types.Expression<String> name, com.querydsl.core.types.Expression<String> registrationNumber, com.querydsl.core.types.Expression<java.time.LocalDateTime> deathDate, com.querydsl.core.types.Expression<String> deathPlaceCode, com.querydsl.core.types.Expression<String> deathPlaceAddress, com.querydsl.core.types.Expression<String> reportResidentName, com.querydsl.core.types.Expression<String> reportResidentRegistrationNumber, com.querydsl.core.types.Expression<String> deathReportQualificationsCode, com.querydsl.core.types.Expression<String> email, com.querydsl.core.types.Expression<String> phoneNumber) {
        super(CertificateDeathReportDto.class, new Class<?>[]{java.time.LocalDate.class, String.class, String.class, java.time.LocalDateTime.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class}, birthDeathReportDate, name, registrationNumber, deathDate, deathPlaceCode, deathPlaceAddress, reportResidentName, reportResidentRegistrationNumber, deathReportQualificationsCode, email, phoneNumber);
    }

}


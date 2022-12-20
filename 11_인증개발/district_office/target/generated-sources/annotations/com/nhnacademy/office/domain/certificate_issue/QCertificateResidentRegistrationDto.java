package com.nhnacademy.office.domain.certificate_issue;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.nhnacademy.office.domain.certificate_issue.QCertificateResidentRegistrationDto is a Querydsl Projection type for CertificateResidentRegistrationDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QCertificateResidentRegistrationDto extends ConstructorExpression<CertificateResidentRegistrationDto> {

    private static final long serialVersionUID = 274144925L;

    public QCertificateResidentRegistrationDto(com.querydsl.core.types.Expression<java.time.LocalDate> certificateIssueDate, com.querydsl.core.types.Expression<Long> certificateConfirmationNumber, com.querydsl.core.types.Expression<Long> householdSerialNumber, com.querydsl.core.types.Expression<String> name, com.querydsl.core.types.Expression<String> compositionReasonCode, com.querydsl.core.types.Expression<java.time.LocalDate> compositionDate) {
        super(CertificateResidentRegistrationDto.class, new Class<?>[]{java.time.LocalDate.class, long.class, long.class, String.class, String.class, java.time.LocalDate.class}, certificateIssueDate, certificateConfirmationNumber, householdSerialNumber, name, compositionReasonCode, compositionDate);
    }

}


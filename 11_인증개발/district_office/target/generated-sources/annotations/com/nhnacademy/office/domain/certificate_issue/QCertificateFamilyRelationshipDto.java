package com.nhnacademy.office.domain.certificate_issue;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.nhnacademy.office.domain.certificate_issue.QCertificateFamilyRelationshipDto is a Querydsl Projection type for CertificateFamilyRelationshipDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QCertificateFamilyRelationshipDto extends ConstructorExpression<CertificateFamilyRelationshipDto> {

    private static final long serialVersionUID = -1261342230L;

    public QCertificateFamilyRelationshipDto(com.querydsl.core.types.Expression<java.time.LocalDate> certificateIssueDate, com.querydsl.core.types.Expression<Long> certificateConfirmationNumber, com.querydsl.core.types.Expression<String> registrationAddress, com.querydsl.core.types.Expression<String> name, com.querydsl.core.types.Expression<java.time.LocalDateTime> birthDate, com.querydsl.core.types.Expression<String> registrationNumber, com.querydsl.core.types.Expression<String> genderCode) {
        super(CertificateFamilyRelationshipDto.class, new Class<?>[]{java.time.LocalDate.class, long.class, String.class, String.class, java.time.LocalDateTime.class, String.class, String.class}, certificateIssueDate, certificateConfirmationNumber, registrationAddress, name, birthDate, registrationNumber, genderCode);
    }

}


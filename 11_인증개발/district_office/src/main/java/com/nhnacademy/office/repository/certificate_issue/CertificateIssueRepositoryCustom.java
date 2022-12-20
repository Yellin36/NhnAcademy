package com.nhnacademy.office.repository.certificate_issue;

import com.nhnacademy.office.domain.certificate_issue.CertificateFamilyRelationshipDto;
import com.nhnacademy.office.domain.certificate_issue.CertificateResidentRegistrationDto;
import com.nhnacademy.office.entity.Resident;

public interface CertificateIssueRepositoryCustom {
    CertificateFamilyRelationshipDto getFamilyRelationCertificateByResident(Resident resident);

    CertificateResidentRegistrationDto getResidentRegistrationCertificateByResident(Resident resident);
}

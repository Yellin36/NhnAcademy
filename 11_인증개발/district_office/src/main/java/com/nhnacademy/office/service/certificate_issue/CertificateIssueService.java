package com.nhnacademy.office.service.certificate_issue;

import com.nhnacademy.office.domain.certificate_issue.CertificateBirthReportDto;
import com.nhnacademy.office.domain.certificate_issue.CertificateDeathReportDto;
import com.nhnacademy.office.domain.certificate_issue.CertificateFamilyRelationshipDto;
import com.nhnacademy.office.domain.certificate_issue.CertificateResidentRegistrationDto;
import com.nhnacademy.office.entity.CertificateIssue;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CertificateIssueService {
    CertificateFamilyRelationshipDto getFamilyRelationshipCertificate(Long serialNumber);

    CertificateResidentRegistrationDto getResidentRegistrationCertificate(Long serialNumber);

    CertificateBirthReportDto getBirthReportCertificate(Long serialNumber);

    CertificateDeathReportDto getDeathReportCertificate(Long serialNumber);

    Page<CertificateIssue> getCertificateIssues(Pageable pageable, Long serialNumber);
}

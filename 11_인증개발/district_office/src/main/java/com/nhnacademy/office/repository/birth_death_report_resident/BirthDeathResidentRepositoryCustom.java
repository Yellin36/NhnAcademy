package com.nhnacademy.office.repository.birth_death_report_resident;

import com.nhnacademy.office.domain.certificate_issue.CertificateBirthReportDto;
import com.nhnacademy.office.domain.certificate_issue.CertificateDeathReportDto;
import com.nhnacademy.office.entity.Resident;

public interface BirthDeathResidentRepositoryCustom {

    CertificateBirthReportDto getBirthReportCertificateByResident(Resident residentO);

    CertificateDeathReportDto getDeathReportCertificateByResident(Resident resident);
}

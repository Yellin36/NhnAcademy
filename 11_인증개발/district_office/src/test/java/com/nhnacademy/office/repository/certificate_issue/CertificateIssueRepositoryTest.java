package com.nhnacademy.office.repository.certificate_issue;

import com.nhnacademy.office.config.RootConfig;
import com.nhnacademy.office.config.WebConfig;
import com.nhnacademy.office.domain.certificate_issue.CertificateFamilyRelationshipDto;
import com.nhnacademy.office.domain.certificate_issue.CertificateResidentRegistrationDto;
import com.nhnacademy.office.entity.Resident;
import com.nhnacademy.office.repository.resident.ResidentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@Transactional
@ContextHierarchy({
        @ContextConfiguration(classes = RootConfig.class),
        @ContextConfiguration(classes = WebConfig.class)
})
class CertificateIssueRepositoryTest {
    @Autowired
    ResidentRepository residentRepository;

    @Autowired
    CertificateIssueRepository certificateIssueRepository;

    @Test
    void getResidentRegistrationCertificateByResident() {
        Resident resident = residentRepository.findByResidentSerialNumber(4L).get();

        CertificateResidentRegistrationDto residents = certificateIssueRepository.getResidentRegistrationCertificateByResident(resident);

        System.out.println(resident);
    }
}
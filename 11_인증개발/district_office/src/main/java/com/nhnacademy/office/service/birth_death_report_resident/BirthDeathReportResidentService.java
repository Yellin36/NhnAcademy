package com.nhnacademy.office.service.birth_death_report_resident;

import com.nhnacademy.office.domain.BirthDeathCode;
import com.nhnacademy.office.domain.birth_death_report_resident.*;
import com.nhnacademy.office.domain.resident.ResidentViewDto;
import com.nhnacademy.office.entity.BirthDeathReportResident;

import java.util.List;

public interface BirthDeathReportResidentService {
    BirthDeathReportResident registerBirthReportResident(Long serialNumber, BirthDeathRegisterRequest request);

    BirthDeathReportResident registerDeathReportResident(Long serialNumber, BirthDeathRegisterRequest request);

    void updateBirthDeathReportResident(Long serialNumber, Long targetSerialNumber, BirthDeathModifyRequest request, BirthDeathCode code);

    void deleteBirthDeathReportResident(Long serialNumber, Long targetSerialNumber, BirthDeathCode code);
}

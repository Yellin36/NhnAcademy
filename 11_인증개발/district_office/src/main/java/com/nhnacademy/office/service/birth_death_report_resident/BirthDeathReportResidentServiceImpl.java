package com.nhnacademy.office.service.birth_death_report_resident;

import com.nhnacademy.office.domain.BirthDeathCode;
import com.nhnacademy.office.domain.birth_death_report_resident.BirthDeathModifyRequest;
import com.nhnacademy.office.domain.birth_death_report_resident.BirthDeathRegisterRequest;
import com.nhnacademy.office.domain.resident.ResidentViewDto;
import com.nhnacademy.office.entity.BirthDeathReportResident;
import com.nhnacademy.office.entity.Resident;
import com.nhnacademy.office.exception.AlreadyRegisteredException;
import com.nhnacademy.office.exception.IllegalInputException;
import com.nhnacademy.office.exception.InvalidAccessAuthorityException;
import com.nhnacademy.office.exception.NotFoundException;
import com.nhnacademy.office.repository.birth_death_report_resident.BirthDeathResidentRepository;
import com.nhnacademy.office.repository.resident.ResidentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class BirthDeathReportResidentServiceImpl implements BirthDeathReportResidentService {
    private final BirthDeathResidentRepository birthDeathResidentRepository;

    private final ResidentRepository residentRepository;

    public BirthDeathReportResidentServiceImpl(BirthDeathResidentRepository birthDeathResidentRepository,
                                               ResidentRepository residentRepository) {
        this.birthDeathResidentRepository = birthDeathResidentRepository;
        this.residentRepository = residentRepository;
    }


    @Override
    public BirthDeathReportResident registerBirthReportResident(Long serialNumber,
                                                                BirthDeathRegisterRequest request) {
        BirthDeathReportResident birthReportResident = getBirthDeathReport(serialNumber, request, BirthDeathCode.BIRTH);

        birthReportResident.setBirthReportQualificationsCode(request.getReportQualificationsCode());

        return birthDeathResidentRepository.save(birthReportResident);
    }

    @Override
    public BirthDeathReportResident registerDeathReportResident(Long serialNumber,
                                                                BirthDeathRegisterRequest request) {
        BirthDeathReportResident birthReportResident = getBirthDeathReport(serialNumber, request, BirthDeathCode.DEATH);

        birthReportResident.setDeathReportQualificationsCode(request.getReportQualificationsCode());

        return birthDeathResidentRepository.save(birthReportResident);
    }

    @Override
    public void updateBirthDeathReportResident(Long reportSerialNumber,
                                               Long targetSerialNumber,
                                               BirthDeathModifyRequest request,
                                               BirthDeathCode code) {
        BirthDeathReportResident.Pk pk = new BirthDeathReportResident.Pk(targetSerialNumber, code.getValue());

        checkReportResidentAuthority(reportSerialNumber, pk);

        birthDeathResidentRepository.updateByPk(pk, request.getEmailAddress(), request.getPhoneNumber());
    }

    @Override
    public void deleteBirthDeathReportResident(Long reportSerialNumber,
                                               Long targetSerialNumber,
                                               BirthDeathCode code) {
        BirthDeathReportResident.Pk pk = new BirthDeathReportResident.Pk(targetSerialNumber, code.getValue());

        checkReportResidentAuthority(reportSerialNumber, pk);

        birthDeathResidentRepository.deleteByPk(pk);
    }

    private void checkReportResidentAuthority(Long reportSerialNumber,
                                              BirthDeathReportResident.Pk pk) {
        Long reportResidentSerialNumber = residentRepository.findByResidentSerialNumber(reportSerialNumber)
                .orElseThrow(() -> new NotFoundException(Resident.class, reportSerialNumber))
                .getResidentSerialNumber();

        Long birthDeathReportResidentSerialNumber = birthDeathResidentRepository.findByPk(pk)
                .orElseThrow(() -> new NotFoundException(BirthDeathReportResident.class, pk))
                .getReportResident()
                .getResidentSerialNumber();

        if (!Objects.equals(reportResidentSerialNumber, birthDeathReportResidentSerialNumber)) {
            throw new InvalidAccessAuthorityException(pk, reportResidentSerialNumber);
        }
    }

    private BirthDeathReportResident getBirthDeathReport(Long reportSerialNumber,
                                                         BirthDeathRegisterRequest request,
                                                         BirthDeathCode code) {
        Long targetSerialNumber = request.getResidentSerialNumber();

        if(Objects.equals(reportSerialNumber, targetSerialNumber)) {
            throw new IllegalInputException("self", reportSerialNumber);
        }

        Resident reportResident = residentRepository.findByResidentSerialNumber(reportSerialNumber)
                .orElseThrow(() -> new NotFoundException(Resident.class, reportSerialNumber));

        Resident targetResident = residentRepository.findByResidentSerialNumber(targetSerialNumber)
                .orElseThrow(() -> new NotFoundException(Resident.class, reportSerialNumber));

        BirthDeathReportResident.Pk pk = getBirthDeathReportResidentByPk(targetSerialNumber, code);

        return getBirthDeathReportResident(request, reportResident, targetResident, pk);
    }

    private BirthDeathReportResident getBirthDeathReportResident(BirthDeathRegisterRequest request,
                                                                 Resident reportResident,
                                                                 Resident targetResident,
                                                                 BirthDeathReportResident.Pk pk) {
        BirthDeathReportResident birthDeathReportResident = new BirthDeathReportResident();

        birthDeathReportResident.setPk(pk);
        birthDeathReportResident.setReportResident(reportResident);
        birthDeathReportResident.setBirthDeathReportDate(request.getReportDate());
        birthDeathReportResident.setEmailAddress(request.getEmailAddress());
        birthDeathReportResident.setPhoneNumber(request.getPhoneNumber());
        birthDeathReportResident.setResident(targetResident);

        return birthDeathReportResident;
    }

    private BirthDeathReportResident.Pk getBirthDeathReportResidentByPk(Long targetSerialNumber, BirthDeathCode code) {
        BirthDeathReportResident.Pk pk = new BirthDeathReportResident.Pk(targetSerialNumber, code.getValue());

        if (birthDeathResidentRepository.existsByPk(pk)) {
            throw new AlreadyRegisteredException(BirthDeathReportResident.class, pk);
        }
        return pk;
    }
}

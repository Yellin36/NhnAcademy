package com.nhnacademy.office.repository.resident;

import com.nhnacademy.office.domain.QualificationCode;
import com.nhnacademy.office.domain.resident.ResidentFamilyDto;
import com.nhnacademy.office.domain.resident.ResidentListDto;
import com.nhnacademy.office.domain.resident.ResidentRelationDto;
import com.nhnacademy.office.domain.resident.ResidentViewDto;
import com.nhnacademy.office.entity.Resident;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface ResidentRepositoryCustom {
    ResidentFamilyDto getByResident(Resident residentO, QualificationCode code);

    Page<ResidentListDto> getAllBy(Pageable pageable, String userId);


    ResidentViewDto getResidentViewByResidentSerialNumber(Long residentSerialNumber);

    List<ResidentRelationDto> getAllResidentRelationByResidentSerialNumber(Long residentSerialNumber);
}

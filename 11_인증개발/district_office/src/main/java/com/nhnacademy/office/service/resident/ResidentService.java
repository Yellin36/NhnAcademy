package com.nhnacademy.office.service.resident;

import com.nhnacademy.office.domain.resident.ResidentListDto;
import com.nhnacademy.office.domain.resident.ResidentModifyRequest;
import com.nhnacademy.office.domain.resident.ResidentRegisterRequest;
import com.nhnacademy.office.domain.resident.ResidentViewDto;
import com.nhnacademy.office.entity.Resident;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ResidentService {

    Resident getResident(Long residentSerialNumber);

    List<Resident> getResidents(Pageable pageable);

    ResidentViewDto getResidentForView(Long residentSerialNumber);

    Page<ResidentListDto> getResidentsForResidentList(Pageable pageable, String userId);

    Resident registerResident(ResidentRegisterRequest request);

    int updateResident(Long serialNumber, ResidentModifyRequest request);


    void deleteResident(Long residentSerialNumber);
}

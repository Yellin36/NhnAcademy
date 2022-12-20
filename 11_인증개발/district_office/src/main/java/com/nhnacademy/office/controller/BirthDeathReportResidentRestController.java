package com.nhnacademy.office.controller;

import com.nhnacademy.office.domain.BirthDeathCode;
import com.nhnacademy.office.domain.birth_death_report_resident.BirthDeathModifyRequest;
import com.nhnacademy.office.domain.birth_death_report_resident.BirthDeathRegisterRequest;
import com.nhnacademy.office.entity.BirthDeathReportResident;
import com.nhnacademy.office.service.birth_death_report_resident.BirthDeathReportResidentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/residents/{serialNumber}")
public class BirthDeathReportResidentRestController {
    private final BirthDeathReportResidentService birthDeathReportResidentService;

    public BirthDeathReportResidentRestController(BirthDeathReportResidentService birthDeathReportResidentService) {
        this.birthDeathReportResidentService = birthDeathReportResidentService;
    }

    @PostMapping("/birth")
    public ResponseEntity<BirthDeathReportResident> registerBirthReportResident(@PathVariable("serialNumber") Long serialNumber,
                                                                                @RequestBody BirthDeathRegisterRequest request) {
        BirthDeathReportResident birthReportResident = birthDeathReportResidentService
                .registerBirthReportResident(serialNumber, request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(birthReportResident);
    }

    @PutMapping("/birth/{targetSerialNumber}")
    public ResponseEntity updateBirthReportResident(@PathVariable("serialNumber") Long serialNumber,
                                                    @PathVariable("targetSerialNumber") Long targetSerialNumber,
                                                    @RequestBody BirthDeathModifyRequest request) {
        birthDeathReportResidentService
                .updateBirthDeathReportResident(serialNumber, targetSerialNumber, request, BirthDeathCode.BIRTH);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/birth/{targetSerialNumber}")
    public ResponseEntity deleteBirthReportResident(@PathVariable("serialNumber") Long serialNumber,
                                                    @PathVariable("targetSerialNumber") Long targetSerialNumber) {
        birthDeathReportResidentService
                .deleteBirthDeathReportResident(serialNumber, targetSerialNumber, BirthDeathCode.BIRTH);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/death")
    public ResponseEntity<BirthDeathReportResident> registerDeathReportResident(@PathVariable("serialNumber") Long serialNumber,
                                                                                @RequestBody BirthDeathRegisterRequest request) {
        BirthDeathReportResident birthReportResident = birthDeathReportResidentService
                .registerDeathReportResident(serialNumber, request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(birthReportResident);
    }

    @PutMapping("/death/{targetSerialNumber}")
    public ResponseEntity updateDeathReportResident(@PathVariable("serialNumber") Long serialNumber,
                                                    @PathVariable("targetSerialNumber") Long targetSerialNumber,
                                                    @RequestBody BirthDeathModifyRequest request) {
        birthDeathReportResidentService
                .updateBirthDeathReportResident(serialNumber, targetSerialNumber, request, BirthDeathCode.DEATH);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/death/{targetSerialNumber}")
    public ResponseEntity deleteDeathReportResident(@PathVariable("serialNumber") Long serialNumber,
                                                    @PathVariable("targetSerialNumber") Long targetSerialNumber) {
        birthDeathReportResidentService
                .deleteBirthDeathReportResident(serialNumber, targetSerialNumber, BirthDeathCode.DEATH);

        return ResponseEntity.ok().build();
    }

}

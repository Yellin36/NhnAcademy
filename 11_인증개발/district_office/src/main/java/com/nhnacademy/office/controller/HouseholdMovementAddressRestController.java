package com.nhnacademy.office.controller;

import com.nhnacademy.office.domain.household_movement_address.HouseholdMovementAddressModifyRequest;
import com.nhnacademy.office.domain.household_movement_address.HouseholdMovementAddressRegisterRequest;
import com.nhnacademy.office.entity.HouseholdMovementAddress;
import com.nhnacademy.office.service.household_movement_address.HouseholdMovementAddressService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/household/{householdSerialNumber}/movement")
public class HouseholdMovementAddressRestController {
    private final HouseholdMovementAddressService householdMovementAddressService;

    public HouseholdMovementAddressRestController(HouseholdMovementAddressService householdMovementAddressService) {
        this.householdMovementAddressService = householdMovementAddressService;
    }

    @PostMapping
    public ResponseEntity<HouseholdMovementAddress>
    registerHouseholdMovementAddress(@PathVariable("householdSerialNumber") Long householdSerialNumber,
                                     @RequestBody HouseholdMovementAddressRegisterRequest request) {
        HouseholdMovementAddress householdMovementAddress =
                householdMovementAddressService.registerHouseholdMovementAddress(householdSerialNumber, request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(householdMovementAddress);
    }

    @PutMapping("/{reportDate}")
    public ResponseEntity updateHouseholdMovementAddress(@PathVariable("householdSerialNumber") Long householdSerialNumber,
                                                         @PathVariable("reportDate") @DateTimeFormat(pattern = "yyyyMMdd") LocalDate reportDate,
                                                         @RequestBody HouseholdMovementAddressModifyRequest request) {
        householdMovementAddressService.updateHouseholdMovementAddress(householdSerialNumber, reportDate, request);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{reportDate}")
    public ResponseEntity deleteHouseholdMovementAddress(@PathVariable("householdSerialNumber") Long householdSerialNumber,
                                                         @PathVariable("reportDate") @DateTimeFormat(pattern = "yyyyMMdd") LocalDate reportDate) {
        householdMovementAddressService.deleteHouseholdMovementAddress(householdSerialNumber, reportDate);

        return ResponseEntity.ok().build();
    }
}

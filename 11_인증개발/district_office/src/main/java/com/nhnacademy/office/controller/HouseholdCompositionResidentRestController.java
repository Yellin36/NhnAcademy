package com.nhnacademy.office.controller;

import com.nhnacademy.office.domain.household_composition_resident.HouseholdCompositionResidentRegisterRequest;
import com.nhnacademy.office.entity.HouseholdCompositionResident;
import com.nhnacademy.office.service.household_composition_resident.HouseholdCompositionResidentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/household/{householdSerialNumber}/composition")
public class HouseholdCompositionResidentRestController {
    private final HouseholdCompositionResidentService householdCompositionResidentService;

    public HouseholdCompositionResidentRestController(HouseholdCompositionResidentService householdCompositionResidentService) {
        this.householdCompositionResidentService = householdCompositionResidentService;
    }

    @PostMapping
    public ResponseEntity<HouseholdCompositionResident>
    registerHouseholdCompositionResident(@PathVariable("householdSerialNumber") Long householdSerialNumber,
                                         @RequestBody HouseholdCompositionResidentRegisterRequest request) {
        HouseholdCompositionResident householdCompositionResident =
                householdCompositionResidentService.registerHouseholdCompositionResident(householdSerialNumber, request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(householdCompositionResident);
    }

    @DeleteMapping("/{residentSerialNumber}")
    public ResponseEntity deleteHouseholdCompositionResident(@PathVariable("householdSerialNumber") Long householdSerialNumber,
                                                             @PathVariable("residentSerialNumber") Long residentSerialNumber) {
        householdCompositionResidentService.deleteHouseholdCompositionResident(householdSerialNumber, residentSerialNumber);

        return ResponseEntity.ok().build();
    }
}


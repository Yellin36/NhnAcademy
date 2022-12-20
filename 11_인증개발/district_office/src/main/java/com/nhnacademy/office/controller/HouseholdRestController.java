package com.nhnacademy.office.controller;

import com.nhnacademy.office.domain.household.HouseholdRegisterRequest;
import com.nhnacademy.office.entity.Household;
import com.nhnacademy.office.service.household.HouseholdService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/household")
public class HouseholdRestController {
    private  final HouseholdService householdService;

    public HouseholdRestController(HouseholdService householdService) {
        this.householdService = householdService;
    }

    @PostMapping
    public ResponseEntity<Household> registerHousehold(@RequestBody HouseholdRegisterRequest request) {
        Household household = householdService.registerHousehold(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(household);
    }

    @DeleteMapping("/{householdSerialNumber}")
    public ResponseEntity deleteHousehold(@PathVariable("householdSerialNumber") Long householdSerialNumber) {
        householdService.deleteHousehold(householdSerialNumber);

        return ResponseEntity.ok().build();
    }
}

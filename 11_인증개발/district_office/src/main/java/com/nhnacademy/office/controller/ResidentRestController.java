package com.nhnacademy.office.controller;

import com.nhnacademy.office.domain.resident.ResidentModifyRequest;
import com.nhnacademy.office.domain.resident.ResidentRegisterRequest;
import com.nhnacademy.office.entity.Resident;
import com.nhnacademy.office.exception.ValidationFailedException;
import com.nhnacademy.office.service.resident.ResidentService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/residents")
public class ResidentRestController {
    private final ResidentService residentService;
    public ResidentRestController(ResidentService residentService) {
        this.residentService = residentService;
    }

    @GetMapping
    public List<Resident> queryResidents(Pageable pageable) {
        return residentService.getResidents(pageable);
    }

    @GetMapping("/{serialNumber}")
    public Resident queryResident(@PathVariable("serialNumber") Long serialNumber) {
        return residentService.getResident(serialNumber);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Resident registerResident(@RequestBody ResidentRegisterRequest request,
                                     BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new ValidationFailedException(bindingResult);
        }

        return residentService.registerResident(request);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping("/{serialNumber}")
    public int updateResident(@PathVariable("serialNumber") Long serialNumber,
                                   @RequestBody ResidentModifyRequest request,
                                   BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new ValidationFailedException(bindingResult);
        }

        return residentService.updateResident(serialNumber, request);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @DeleteMapping("/{serialNumber}")
    public void deleteResident(@PathVariable("serialNumber") Long serialNumber) {
        residentService.deleteResident(serialNumber);
    }
}

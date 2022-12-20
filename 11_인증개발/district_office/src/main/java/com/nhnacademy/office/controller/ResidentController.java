package com.nhnacademy.office.controller;

import com.nhnacademy.office.domain.resident.ResidentListDto;
import com.nhnacademy.office.domain.resident.ResidentViewDto;
import com.nhnacademy.office.service.birth_death_report_resident.BirthDeathReportResidentService;
import com.nhnacademy.office.service.resident.ResidentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/resident")
public class ResidentController {
    private final ResidentService residentService;
    private final BirthDeathReportResidentService birthDeathReportResidentService;

    private final int PAGE_SIZE = 10;

    public ResidentController(ResidentService residentService, BirthDeathReportResidentService birthDeathReportResidentService) {
        this.residentService = residentService;
        this.birthDeathReportResidentService = birthDeathReportResidentService;
    }

    @GetMapping
    public String showResidents(@RequestParam("page") Optional<Integer> page,
                                Authentication authentication,
                                Model model) {
        int curPage = page.orElse(1);


        Page<ResidentListDto> residents = residentService.getResidentsForResidentList(
                PageRequest.of(curPage - 1, PAGE_SIZE),
                authentication.getName());

        int totalPages = residents.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        model.addAttribute("curPage", curPage);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("residents", residents);

        return "index";
    }

    @GetMapping("/{serialNumber}")
    public String showResident(@PathVariable("serialNumber") Long serialNumber,
                               Model model) {
        ResidentViewDto resident = residentService.getResidentForView(serialNumber);

        model.addAttribute("residentSerialNumber", serialNumber);
        model.addAttribute("resident", resident);

        return "resident";
    }

    @GetMapping("/{serialNumber}/delete")
    public String deleteResident(@PathVariable("serialNumber") Long serialNumber) {
        residentService.deleteResident(serialNumber);

        return "resident";
    }
}

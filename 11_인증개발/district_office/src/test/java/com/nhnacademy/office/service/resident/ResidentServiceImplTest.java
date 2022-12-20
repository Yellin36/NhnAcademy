package com.nhnacademy.office.service.resident;

import com.nhnacademy.office.config.RootConfig;
import com.nhnacademy.office.config.WebConfig;
import com.nhnacademy.office.domain.resident.ResidentModifyRequest;
import com.nhnacademy.office.entity.Resident;
import com.nhnacademy.office.exception.NotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@Transactional
@ContextHierarchy({
        @ContextConfiguration(classes = RootConfig.class),
        @ContextConfiguration(classes = WebConfig.class)
})
class ResidentServiceImplTest {
    @Autowired
    ResidentService residentService;

    @Test
    void getResident_failByNotFound_thenThrowNotFoundResidentException() {
        Long residentSerialNumber = 100000L;

        assertThatThrownBy(() ->
                residentService.getResident(residentSerialNumber))
                .isInstanceOf(NotFoundException.class);
    }

    @Test
    void getResident_success() {
        Long residentSerialNumber = 1L;

        Resident resident = residentService.getResident(residentSerialNumber);

        assertThat(resident).isNotNull();
        assertThat(resident.getResidentSerialNumber()).isEqualTo(residentSerialNumber);

        System.out.println(resident.getBirthDate());

    }

    @Test
    void getResidents_success() {
    }

    @Test
    void getResidentForView() {
    }

    @Test
    void getResidentsForResidentList() {
    }

    @Test
    void registerResident_failByAlreadyExistResident_thenThrowAlreadyRegisteredResidentException() {
    }

    @Test
    void registerResident_success() {
    }

    @Test
    void updateResident_failByNotExistResident_thenThrowNotFoundResidentException() {
        Long serialNumber = 100000L;


        assertThatThrownBy(() -> residentService.updateResident(serialNumber, new ResidentModifyRequest()))
                .isInstanceOf(NotFoundException.class);
    }

    @Test
    void updateResident() {
        Long serialNumber = 1L;
        LocalDateTime date = LocalDateTime.now();
        String code = "code";
        String address = "address";

        ResidentModifyRequest request = new ResidentModifyRequest(date, code, address);

        int result = residentService.updateResident(serialNumber, request);

        assertThat(result).isGreaterThan(0);
    }

    @Test
    void deleteResident_fail() {
    }

    @Test
    void deleteResident_success() {
    }

    private static Resident getResident(Long id) {
        Resident resident = new Resident();
        resident.setResidentSerialNumber(id);
        resident.setName("최우석");
        resident.setResidentRegistrationNumber("000000-0000000");
        resident.setGenderCode("남");
        resident.setBirthDate(LocalDateTime.now());
        resident.setBirthPlaceCode("자택");
        resident.setRegistrationBaseAddress("경기도 성남시 분당구 대왕판교로645-3번길");
        return resident;
    }
}
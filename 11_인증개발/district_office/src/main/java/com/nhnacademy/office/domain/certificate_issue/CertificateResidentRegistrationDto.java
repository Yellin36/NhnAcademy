package com.nhnacademy.office.domain.certificate_issue;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.nhnacademy.office.domain.household_composition_resident.HouseholdCompositionResidentDto;
import com.nhnacademy.office.domain.household_movement_address.HouseholdMovementAddressDto;
import com.nhnacademy.office.entity.Resident;
import com.querydsl.core.annotations.QueryProjection;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class CertificateResidentRegistrationDto {
    LocalDate certificateIssueDate;
    Long certificateConfirmationNumber;
    Long householdSerialNumber;
    String name;
    String compositionReasonCode;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
    LocalDate compositionDate;
    List<HouseholdMovementAddressDto> address;
    List<HouseholdCompositionResidentDto> composition;
    Resident resident;

    @QueryProjection
    public CertificateResidentRegistrationDto(LocalDate certificateIssueDate, Long certificateConfirmationNumber, Long householdSerialNumber, String name, String compositionReasonCode, LocalDate compositionDate) {
        this.certificateIssueDate = certificateIssueDate;
        this.certificateConfirmationNumber = certificateConfirmationNumber;
        this.householdSerialNumber = householdSerialNumber;
        this.name = name;
        this.compositionReasonCode = compositionReasonCode;
        this.compositionDate = compositionDate;
    }

}

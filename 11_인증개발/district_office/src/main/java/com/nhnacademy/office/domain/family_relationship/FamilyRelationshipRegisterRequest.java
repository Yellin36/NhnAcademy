package com.nhnacademy.office.domain.family_relationship;

import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FamilyRelationshipRegisterRequest {
    private Long familySerialNumber;
    private String relationShip;
}


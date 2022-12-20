package com.nhnacademy.office.service.family_relationship;

import com.nhnacademy.office.domain.family_relationship.FamilyRelationshipModifyRequest;
import com.nhnacademy.office.domain.family_relationship.FamilyRelationshipRegisterRequest;
import com.nhnacademy.office.entity.FamilyRelationship;
import org.springframework.stereotype.Service;

public interface FamilyRelationshipService {
    FamilyRelationship registerFamilyRelationship(Long serialNumber, FamilyRelationshipRegisterRequest request);

    void updateFamilyRelationship(Long residentSerialNumber, Long familySerialNumber, FamilyRelationshipModifyRequest request);

    void deleteFamilyRelationship(Long residentSerialNumber, Long familySerialNumber);
}

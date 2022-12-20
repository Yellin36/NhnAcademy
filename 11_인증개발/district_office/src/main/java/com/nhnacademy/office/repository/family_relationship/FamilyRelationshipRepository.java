package com.nhnacademy.office.repository.family_relationship;

import com.nhnacademy.office.entity.FamilyRelationship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface FamilyRelationshipRepository extends JpaRepository<FamilyRelationship, FamilyRelationship.Pk> {
    boolean existsByPk(FamilyRelationship.Pk pk);

    @Modifying
    @Transactional
    @Query("update FamilyRelationship " +
            "set familyRelationshipCode = :relation " +
            "where pk = :pk")
    void updateByPk(@Param("pk") FamilyRelationship.Pk pk,
                    @Param("relation") String familyRelationship);
    @Transactional
    @Modifying
    @Query("delete from FamilyRelationship " +
            "where pk.baseResidentSerialNumber = :serialNumber " +
            "or pk.familyResidentSerialNumber = :serialNumber")
    void deleteByResidentSerialNumber(@Param("serialNumber") Long serialNumber);

}

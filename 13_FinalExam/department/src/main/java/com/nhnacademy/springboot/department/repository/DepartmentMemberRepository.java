package com.nhnacademy.springboot.department.repository;

import com.nhnacademy.springboot.department.entity.DepartmentMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface DepartmentMemberRepository extends CustomDepartmentMemberRepository,
        JpaRepository<DepartmentMember, DepartmentMember.Pk> {
    @Modifying
    @Transactional
    @Query(value = "SET FOREIGN_KEY_CHECKS = :option", nativeQuery = true)
    void setReferentialIntegrity(@Param("option") int option);

    @Transactional
    @Modifying
    @Query(value = "truncate department_members", nativeQuery = true)
    void truncate();
}

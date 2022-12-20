package com.nhnacademy.springboot.department.repository;

import com.nhnacademy.springboot.department.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface DepartmentRepository extends JpaRepository<Department, String> {
    @Transactional
    @Modifying
    @Query(value = "truncate departments", nativeQuery = true)
    void truncate();
}

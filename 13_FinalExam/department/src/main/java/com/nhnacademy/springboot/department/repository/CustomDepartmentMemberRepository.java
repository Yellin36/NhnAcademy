package com.nhnacademy.springboot.department.repository;

import com.nhnacademy.springboot.department.domain.DepartmentMemberDto;

import java.util.List;

public interface CustomDepartmentMemberRepository {
    List<DepartmentMemberDto> getByDepartmentId(String[] departmentId);
}

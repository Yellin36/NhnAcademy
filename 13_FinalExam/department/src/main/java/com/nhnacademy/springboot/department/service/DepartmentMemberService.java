package com.nhnacademy.springboot.department.service;

import com.nhnacademy.springboot.department.domain.DepartmentMemberDto;

import java.util.List;

public interface DepartmentMemberService {
    List<DepartmentMemberDto> getDepartmentMemberWithIds(String departmentIds);
}

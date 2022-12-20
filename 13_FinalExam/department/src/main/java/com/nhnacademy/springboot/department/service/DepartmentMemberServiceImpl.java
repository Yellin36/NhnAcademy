package com.nhnacademy.springboot.department.service;

import com.nhnacademy.springboot.department.domain.DepartmentMemberDto;
import com.nhnacademy.springboot.department.repository.DepartmentMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class DepartmentMemberServiceImpl implements DepartmentMemberService {
    private final DepartmentMemberRepository departmentMemberRepository;

    @Override
    @Transactional(readOnly = true)
    public List<DepartmentMemberDto> getDepartmentMemberWithIds(String departmentIds) {
        String[] departmentIdList = departmentIds.replace(" ", "")
                .split(",|\\.|/|-|\\+");


        return departmentMemberRepository.getByDepartmentId(departmentIdList);
    }
}

package com.nhnacademy.springboot.department.domain;

import com.nhnacademy.springboot.department.entity.Department;
import com.nhnacademy.springboot.department.entity.Member;
import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class DepartmentMemberDto {
    Department department;
    Member member;

    @QueryProjection
    public DepartmentMemberDto(Department department, Member member) {
        this.department = department;
        this.member = member;
    }
}

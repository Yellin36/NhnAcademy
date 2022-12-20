package com.nhnacademy.springboot.department.repository;

import com.nhnacademy.springboot.department.domain.DepartmentMemberDto;
import com.nhnacademy.springboot.department.domain.QDepartmentMemberDto;
import com.nhnacademy.springboot.department.entity.DepartmentMember;
import com.nhnacademy.springboot.department.entity.QDepartmentMember;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

public class CustomDepartmentMemberRepositoryImpl extends QuerydslRepositorySupport implements CustomDepartmentMemberRepository {
    public CustomDepartmentMemberRepositoryImpl() {
        super(DepartmentMember.class);
    }


    @Override
    public List<DepartmentMemberDto> getByDepartmentId(String[] departmentId) {
        QDepartmentMember departmentMember = QDepartmentMember.departmentMember;

        return from(departmentMember)
                .select(new QDepartmentMemberDto(
                        departmentMember.department,
                        departmentMember.member
                ))
                .where(departmentMember.pk.departmentId.in(departmentId))
                .orderBy(departmentMember.pk.departmentId.asc(), departmentMember.pk.memberId.asc())
                .fetch();
    }
}

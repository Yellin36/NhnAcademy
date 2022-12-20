package com.nhnacademy.springboot.department.service;

import com.nhnacademy.springboot.department.entity.Department;
import com.nhnacademy.springboot.department.entity.DepartmentMember;
import com.nhnacademy.springboot.department.entity.Member;
import com.nhnacademy.springboot.department.parser.ParsedData;
import com.nhnacademy.springboot.department.parser.Parser;
import com.nhnacademy.springboot.department.repository.DepartmentMemberRepository;
import com.nhnacademy.springboot.department.repository.DepartmentRepository;
import com.nhnacademy.springboot.department.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@Transactional
@RequiredArgsConstructor
public class DBSettingServiceImpl implements DBSettingService {
    private final DepartmentMemberRepository departmentMemberRepository;
    private final DepartmentRepository departmentRepository;
    private final MemberRepository membersRepository;

    private final Parser parser;

    @Override
    public void dbSetting(String fileName) {
        initializeDataBase();

        if (Objects.isNull(fileName)) return;

        List<ParsedData> parsedDataList = parser.parsing(fileName);

        for (ParsedData data : parsedDataList) {
            Long memberId = data.getMemberId();
            String departmentId = data.getDepartmentId();

            Member member = membersRepository.findById(memberId)
                    .orElseGet(() -> membersRepository.save(new Member(data.getMemberId(), data.getMemberName())));

            Department department = departmentRepository.findById(departmentId)
                    .orElseGet(() -> departmentRepository.save(new Department(data.getDepartmentId(), data.getDepartmentName())));

            DepartmentMember departmentMember = new DepartmentMember(
                    new DepartmentMember.Pk(departmentId, memberId),
                    department,
                    member
            );
            departmentMemberRepository.save(departmentMember);
        }
    }

    private void initializeDataBase() {
        departmentMemberRepository.setReferentialIntegrity(0);
        departmentMemberRepository.truncate();
        departmentRepository.truncate();
        membersRepository.truncate();
        departmentMemberRepository.setReferentialIntegrity(1);
    }
}

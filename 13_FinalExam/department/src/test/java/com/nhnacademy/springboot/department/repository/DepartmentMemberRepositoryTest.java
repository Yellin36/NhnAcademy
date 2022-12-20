package com.nhnacademy.springboot.department.repository;

import com.nhnacademy.springboot.department.domain.DepartmentMemberDto;
import com.nhnacademy.springboot.department.entity.Department;
import com.nhnacademy.springboot.department.entity.DepartmentMember;
import com.nhnacademy.springboot.department.entity.Member;
import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class DepartmentMemberRepositoryTest {
    @Autowired
    TestEntityManager entityManager;

    @Autowired
    DepartmentMemberRepository departmentMemberRepository;

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    MemberRepository memberRepository;


    @Test
    void test_setReferentialIntegrity() {

    }

    @Test
    @Order(1)
    void test_getByDepartmentId() {
        String departmentId = "L1001";
        Long memberId = 20202202L;
        Department department = new Department(departmentId, "백앤드 1팀");
        Member member = new Member(memberId, "김하나");

        DepartmentMember departmentMember = new DepartmentMember(
                new DepartmentMember.Pk(departmentId, memberId),
                department,
                member
        );
        departmentRepository.save(department);
        memberRepository.save(member);
        departmentMemberRepository.save(departmentMember);

        List<DepartmentMemberDto> actual = departmentMemberRepository.getByDepartmentId(Arrays.array(departmentId));

        assertThat(actual).hasSize(1);
        assertThat(actual.iterator().next().getDepartment()).isEqualTo(department);
        assertThat(actual.iterator().next().getMember()).isEqualTo(member);

    }

    @Test
    @Order(2)
    void test_truncate() {
        //when
        departmentMemberRepository.truncate();

        //then
        List<DepartmentMember> result = departmentMemberRepository.findAll();

        assertThat(result).hasSize(0);
    }
}
package com.nhnacademy.springboot.department.contorller;

import com.nhnacademy.springboot.department.domain.DepartmentMemberDto;
import com.nhnacademy.springboot.department.entity.Department;
import com.nhnacademy.springboot.department.entity.Member;
import com.nhnacademy.springboot.department.service.DepartmentMemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
class DepartmentMemberRestControllerTest {
    @Autowired
    MockMvc mvc;

    @MockBean
    private DepartmentMemberService departmentMemberService;

    @Test
    @DisplayName("departmentIds 파라미터가 없는경우")
    void getDepartmentMembers_failByNonParameter_thenReturnBadRequest() throws Exception {
        mvc.perform(get("/department-members"))
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("departmentIds 파라미터의 값이 없는경우")
    void getDepartmentMembers_failByNonParameterValue_thenReturnBadRequest() throws Exception {
        mvc.perform(get("/department-members")
                        .param("departmentIds", ""))
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("Accept 헤더가 없는 경우")
    void getDepartmentMembers_failByAcceptHeaderMissing_thenReturnBadRequest() throws Exception {
        String departmentId = "L1001";
        mvc.perform(get("/department-members")
                        .param("departmentIds", departmentId))
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("Accept 헤더의 값이 application/json 이 아닌 경우")
    void getDepartmentMembers_failByAcceptIsNotApplicationJson_thenReturnBadRequest() throws Exception {
        String departmentId = "L1001";

        mvc.perform(get("/department-members")
                        .param("departmentIds", departmentId)
                        .header("Accept", MediaType.APPLICATION_CBOR))
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("정상적인 요청이 들어온 경우")
    void getDepartmentMembers_success() throws Exception {
        String departmentId = "L1001";

        Department department = new Department(departmentId, "BackEnd1");
        Member member = new Member(20220101L, "mem1");
        Member member2 = new Member(20220102L, "mem2");

        given(departmentMemberService.getDepartmentMemberWithIds(departmentId))
                .willReturn(List.of(
                        new DepartmentMemberDto(department, member),
                        new DepartmentMemberDto(department, member2)));

        mvc.perform(get("/department-members")
                        .param("departmentIds", departmentId)
                        .header("Accept", MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpectAll(
                        jsonPath("$[0].department.id", equalTo(departmentId)),
                        jsonPath("$[1].department.id", equalTo(departmentId)));

    }
}
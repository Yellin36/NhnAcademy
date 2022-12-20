package com.nhnacademy.edu.springboot.account.adapter.in;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.nhnacademy.edu.springboot.account.domain.Account;
import com.nhnacademy.edu.springboot.account.domain.AccountRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.equalTo;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AccountRestControllerTest {
    @Autowired
    MockMvc mvc;

    @MockBean
    AccountRepository accountRepository;

    @Test
    @Order(1)
    void getAccounts() throws Exception {
        given(accountRepository.findAll()).willReturn(
                List.of(new Account(1L, "123-456", 1000),
                        new Account(2L, "234-567", 2000)));

        mvc.perform(get("/accounts"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].number", equalTo("123-456")));
    }

    @Test
    @Order(2)
    void getAccount() throws Exception {
        Long id = 1L;

        given(accountRepository.findById(id)).willReturn(
                Optional.of(new Account(id, "123-456", 1000)));

        mvc.perform(get("/accounts/{id}", id))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.number", equalTo("123-456")));
    }

    @Test
    @Order(3)
    void createAccount() throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        Account account = new Account(4L, "134-123", 3000);

        given(accountRepository.save(account)).willReturn(account);

        mvc.perform(post("/accounts")
                        .content(mapper.writeValueAsString(account))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", equalTo(4)));
    }

    @Test
    @Order(4)
    void deleteAccount() throws Exception {
        Long id = 4L;

        willDoNothing().given(accountRepository).deleteById(id);

        mvc.perform(delete("/accounts/{id}", id))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.result", equalTo("OK")));
    }
}
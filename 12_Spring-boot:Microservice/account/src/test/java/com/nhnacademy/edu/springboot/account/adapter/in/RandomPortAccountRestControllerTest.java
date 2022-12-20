package com.nhnacademy.edu.springboot.account.adapter.in;

import com.nhnacademy.edu.springboot.account.domain.Account;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class RandomPortAccountControllerTest {
    @Autowired
    TestRestTemplate restTemplate;

    @Test
    @Order(1)
    void testGetAccounts() throws Exception {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<Account> entity = new HttpEntity<>(headers);

        ResponseEntity<List<Account>> exchange = restTemplate.exchange(
                "/accounts",
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<List<Account>>() {}
        );
        assertThat(exchange.getBody())
                .contains(new Account(1L, "123-456", 1000));
    }

    @Test
    @Order(2)
    void testGetAccount() throws Exception {
        ResponseEntity<Account> response = restTemplate.getForEntity(
                "/accounts/{id}",
                Account.class,
                1L
        );
        assertThat(response.getBody()).isEqualTo(new Account(1L, "zbum", 1000));
    }
    @Test
    @Order(3)
    void testCreateAccount() throws Exception {
        Account account = new Account(10L, "hahaha", 39);


        ResponseEntity<Account> exchange = restTemplate.postForEntity(
                "/accounts",
                account,
                Account.class
        );

        assertThat(exchange.getBody()).isEqualTo(account);

    }
    @Test
    @Order(4)
    void testDeleteAccount() throws Exception {
        restTemplate.delete(
                "/accounts/{id}",
                10L
        );
    }

}
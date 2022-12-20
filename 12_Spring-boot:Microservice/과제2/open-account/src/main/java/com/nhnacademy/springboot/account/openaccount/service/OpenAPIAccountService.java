package com.nhnacademy.springboot.account.openaccount.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nhnacademy.springboot.account.openaccount.config.AccountProperties;
import com.nhnacademy.springboot.account.openaccount.domain.Account;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OpenAPIAccountService implements AccountService {
    private final AccountProperties accountProperties;
    private final RestTemplate restTemplate;
    private static final ParameterizedTypeReference<List<Account>> ACCOUNT_LIST_TYPE
            = new ParameterizedTypeReference<>() {};

    @Override
    public List<Account> getAccounts() {
        ResponseEntity<List<Account>> response = restTemplate.exchange(
                accountProperties.getUrl(),
                HttpMethod.GET,
                getHttpEntity(),    //or null
                ACCOUNT_LIST_TYPE
        );

        return response.getBody();
    }

    @Override
    public Account getAccount(Long id) {
        ResponseEntity<Account> response = restTemplate.exchange(
                accountProperties.getUrl() + "/" + id,
                HttpMethod.GET,
                getHttpEntity(),
                Account.class
        );
        return response.getBody();
    }

    @Override
    public Account createAccount(Account account) {
        ResponseEntity<Account> response = restTemplate.exchange(
                accountProperties.getUrl(),
                HttpMethod.POST,
                getHttpEntityWithAccount(account),
                Account.class
        );
        return response.getBody();
    }

    @Override
    public String deleteAccount(Long id) {
        return restTemplate.exchange(
                accountProperties.getUrl() + "/" + id,
                HttpMethod.DELETE,
                getHttpEntity(),
                String.class
        ).getBody();
    }

    private HttpEntity getHttpEntityWithAccount(Account account) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-type", "application/json");

        Map<String, Object> params = new HashMap<>();
        params.put("id", account.getId());
        params.put("balance", account.getBalance());
        params.put("number", account.getNumber());

        return new HttpEntity<>(params, headers);
    }

    private HttpEntity getHttpEntity() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-type", "application/json");

        return new HttpEntity<>(headers);
    }
}

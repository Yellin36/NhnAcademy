package com.nhnacademy.edu.springboot.account.domain;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class AccountRepositoryTest {

    @Autowired
    AccountRepository accountRepository;
    @Autowired
    TestEntityManager entityManager;

    @Test
    void findAll() {
        Account account = new Account(1L, "123-456", 1000);
        accountRepository.save(account);

        Optional<Account> actual = accountRepository.findById(1L);

        assertThat(actual).isPresent();
        assertThat(actual.get()).isEqualTo(account);
    }

    @Test
    void testFindByNumber() {
        String number = "123-456";
        Account account = new Account(11L, number, 1000);
        entityManager.persist(account);

        List<Account> actual = accountRepository.findByNumber(number);

        assertThat(actual).hasSize(2);
        assertThat(actual.get(1)).isEqualTo(account);
    }
}
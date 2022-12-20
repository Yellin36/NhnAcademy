package com.nhnacademy.springmvc.repository;

import com.nhnacademy.springmvc.domain.User;
import com.nhnacademy.springmvc.exception.AlreadyRegisteredUserException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class CustomerRepositoryTest {
    CustomerRepository customerRepository;

    @BeforeEach
    void setUp() {
        customerRepository = new CustomerRepository();
    }

    @Test
    void exists_false() {
        String id = "user@1";

        assertThat(customerRepository.exists(id)).isFalse();
    }

    @Test
    void exists_true() {
        String id = "user@1";

        customerRepository.registerUser(id, "1234", "kim");

        assertThat(customerRepository.exists(id)).isTrue();
    }

    @Test
    void getUser_null() {
        String id = "user@1";

        assertThat(customerRepository.getUser(id)).isNull();
    }

    @Test
    void getUser_success() {
        String id = "user@1";
        String password = "1234";
        String name = "kim";

        customerRepository.registerUser(id, password, name);

        User result = customerRepository.getUser(id);

        assertThat(result).isNotNull();
        assertThat(result.getId()).isEqualTo(id);
        assertThat(result.getPassword()).isEqualTo(password);
        assertThat(result.getName()).isEqualTo(name);
    }


    @Test
    void registerUser_failByAlreadyExistsUser_thenThrowAlreadyRegisteredUserException() {
        String id = "user@1";
        String password = "1234";
        String name = "kim";

        customerRepository.registerUser(id, password, name);

        assertThatThrownBy(() -> customerRepository.registerUser(id, password, name))
                .isInstanceOf(AlreadyRegisteredUserException.class);
    }

    @Test
    void registerUser_success() {
        String id = "user@1";
        String password = "1234";
        String name = "kim";

        User result = customerRepository.registerUser(id, password, name);

        assertThat(result).isNotNull();
        assertThat(result.getId()).isEqualTo(id);
        assertThat(result.getPassword()).isEqualTo(password);
        assertThat(result.getName()).isEqualTo(name);
    }

    @Test
    void matches_false() {
        String id = "user@1";
        String password = "1234";

        assertThat(customerRepository.matches(id, password)).isFalse();
    }

    @Test
    void matches_true() {
        String id = "user@1";
        String password = "1234";
        String name = "kim";

        customerRepository.registerUser(id, password, name);

        assertThat(customerRepository.matches(id, password)).isTrue();
    }
}
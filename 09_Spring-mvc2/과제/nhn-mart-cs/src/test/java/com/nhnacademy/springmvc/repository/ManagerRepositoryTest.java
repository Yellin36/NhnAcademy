package com.nhnacademy.springmvc.repository;

import com.nhnacademy.springmvc.domain.User;
import com.nhnacademy.springmvc.exception.AlreadyRegisteredUserException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ManagerRepositoryTest {
    ManagerRepository managerRepository;

    @BeforeEach
    void setUp() {
        managerRepository = new ManagerRepository();
    }

    @Test
    void exists_false() {
        String id = "admin@1";

        assertThat(managerRepository.exists(id)).isFalse();
    }

    @Test
    void exists_true() {
        String id = "admin@1";

        managerRepository.registerUser(id, "1234", "kim");

        assertThat(managerRepository.exists(id)).isTrue();
    }

    @Test
    void getUser_null() {
        String id = "admin@1";

        assertThat(managerRepository.getUser(id)).isNull();
    }

    @Test
    void getUser_success() {
        String id = "admin@1";
        String password = "1234";
        String name = "kim";

        managerRepository.registerUser(id, password, name);

        User result = managerRepository.getUser(id);

        assertThat(result).isNotNull();
        assertThat(result.getId()).isEqualTo(id);
        assertThat(result.getPassword()).isEqualTo(password);
        assertThat(result.getName()).isEqualTo(name);
    }


    @Test
    void registerUser_failByAlreadyExistsUser_thenThrowAlreadyRegisteredUserException() {
        String id = "admin@1";
        String password = "1234";
        String name = "kim";

        managerRepository.registerUser(id, password, name);

        assertThatThrownBy(() -> managerRepository.registerUser(id, password, name))
                .isInstanceOf(AlreadyRegisteredUserException.class);
    }

    @Test
    void registerUser_success() {
        String id = "admin@1";
        String password = "1234";
        String name = "kim";

        User result = managerRepository.registerUser(id, password, name);

        assertThat(result).isNotNull();
        assertThat(result.getId()).isEqualTo(id);
        assertThat(result.getPassword()).isEqualTo(password);
        assertThat(result.getName()).isEqualTo(name);
    }

    @Test
    void matches_false() {
        String id = "admin@1";
        String password = "1234";

        assertThat(managerRepository.matches(id, password)).isFalse();
    }

    @Test
    void matches_true() {
        String id = "admin@1";
        String password = "1234";
        String name = "kim";

        managerRepository.registerUser(id, password, name);

        assertThat(managerRepository.matches(id, password)).isTrue();
    }
}
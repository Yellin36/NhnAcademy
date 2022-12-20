package org.example.yerin.tdd.acount;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AccountServiceStubTest {
    private AccountService service;
    private AccountRepository repository;

    @BeforeEach
    void setUp() {
        repository = mock(AccountRepository.class);
        service = new AccountService(repository);
    }

    @Test
    void login() {
        String username = "jordan";
        String password = "P@s5w0rd";

        Account account = new Account(username, password);
        // TODO: findByUsername 구현
        when(repository.findByUsername(username)).thenReturn(account);

        // TODO: login 구현
        Account result = service.login(username, password);

        assertThat(result).isNotNull();
        assertThat(result.getId()).isNotNull().isPositive();
        assertThat(result.getUsername()).isEqualTo(username);
        assertThat(result.getPassword()).isEqualTo(password);
    }
    @Test
    void login_notFound_returnNull() {
        String username = "not.exists";
        String password = "P@s5w0rd";

        Account account = new Account(username, password);
        when(repository.findByUsername(username)).thenReturn(null);

        Account result = service.login(username, password);

        assertThat(result).isNull();
    }

    @Test
    void login_notMatchedPassword_throwLoginFailedException() {
        String username = "jordan";
        String password = "invalid.password";

        Account account = new Account(username, "valid.password");
        when(repository.findByUsername(username)).thenReturn(account);

        assertThatThrownBy(() -> service.login(username, password))
                .isInstanceOf(LoginFailedException.class)
                .hasMessageContainingAll("Login failed", username);
    }
}

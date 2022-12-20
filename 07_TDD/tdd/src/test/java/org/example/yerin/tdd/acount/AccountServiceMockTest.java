package org.example.yerin.tdd.acount;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

class AccountServiceMockTest {
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
        when(repository.findByUsername(username)).thenReturn(account);

        Account result = service.login(username, password);

        assertThat(result).isNotNull();
        assertThat(result.getId()).isNotNull().isPositive();
        assertThat(result.getUsername()).isEqualTo(username);
        assertThat(result.getPassword()).isEqualTo(password);

        verify(repository).findByUsername(username);    // !! verify(mock)
    }
    @Test
    void login_usernameIsNull_throwIllegalArgumentException() {
        String username = null;
        String password = "P@s5w0rd";

        Account account = new Account(username, password);
        when(repository.findByUsername(username)).thenReturn(account);

        assertThatIllegalArgumentException().isThrownBy(() -> service.login(username, password))
                .withMessageContaining("null");

        //호출이 안되는 것을 검증하는 것도 성능에 있어 좋기 때문
        verify(repository, never()).findByUsername(any());  // !! verify never
    }
    @Test
    @DisplayName("login_failed3times")
    void login_passwordIsWrong_forThreeTime() {
        String username = "yerin";
        String password = "1234";
        String wrong_password = "wrong_pwd";

        Account account = new Account(username, password);
        when(repository.findByUsername(username)).thenReturn(account);

        assertThatThrownBy(() -> service.login(username, wrong_password)).isInstanceOf(LoginFailedException.class);
        assertThatThrownBy(() -> service.login(username, wrong_password)).isInstanceOf(LoginFailedException.class);

        assertThatThrownBy(() -> service.login(username, wrong_password))
                .isInstanceOf(AccountLockedException.class)
                .withFailMessage("locked");
        verify(repository, times(3)).findByUsername(username);
    }
    @Test
    @DisplayName("login_failed2times_then_success_for3times_then")
    void login_passwordIsWrong_OnlyTwoTimes() {
        String username = "yerin";
        String password = "1234";
        String wrong_password = "wrong_pwd";

        Account account = new Account(username, password);
        when(repository.findByUsername(username)).thenReturn(account);

        for (int i = 0; i < 3; i++) {
            assertThatThrownBy(() -> service.login(username, wrong_password)).isInstanceOf(LoginFailedException.class);
            assertThatThrownBy(() -> service.login(username, wrong_password)).isInstanceOf(LoginFailedException.class);
            assertThat(service.login(username, password)).isEqualTo(account);
        }
    }
    @Test
    void login_AccountUnlock() {
        String username = "yerin";
        String password = "1234";
        String wrong_password = "wrong_pwd";

        Account account = new Account(username, password);
        when(repository.findByUsername(username)).thenReturn(account);

        for (int i = 1; i < 3; i++) {
            assertThatThrownBy(() -> service.login(username, wrong_password))
                    .as("Login Failed {0} Times.", i)
                    .isInstanceOf(LoginFailedException.class);
        }
        account.unLock();
        assertThatThrownBy(() -> service.login(username, wrong_password)).isInstanceOf(LoginFailedException.class);

    }
}

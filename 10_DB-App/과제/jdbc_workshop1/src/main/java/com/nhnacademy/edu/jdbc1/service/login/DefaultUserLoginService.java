package com.nhnacademy.edu.jdbc1.service.login;

import com.nhnacademy.edu.jdbc1.domain.User;
import com.nhnacademy.edu.jdbc1.repository.JdbcTemplateUserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Slf4j
@Service
public class DefaultUserLoginService implements UserLoginService {
    private final JdbcTemplateUserRepository userRepository;

    public DefaultUserLoginService(JdbcTemplateUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean login(String username, String password) {
        User user = userRepository.findByUserName(username);

        return Objects.nonNull(user) && user.getPassword().equals(password);
    }
}

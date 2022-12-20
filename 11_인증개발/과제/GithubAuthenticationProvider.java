package com.nhnacademy.office.auth;

import com.nhnacademy.office.service.GithubUserDetailsService;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collections;

public class GithubAuthenticationProvider implements AuthenticationProvider {
    private final GithubUserDetailsService githubAuthenticationService;
    private final PasswordEncoder passwordEncoder;

    public GithubAuthenticationProvider(GithubUserDetailsService githubAuthenticationService,
                                        PasswordEncoder passwordEncoder) {
        this.githubAuthenticationService = githubAuthenticationService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        try {
            String name = authentication.getName();
            String password = authentication.getCredentials().toString();

            User user = githubAuthenticationService.authenticateUser(name);

            final Authentication auth2 = new UsernamePasswordAuthenticationToken(
                    user,
                    passwordEncoder.encode(password),
                    Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER")));

            return auth2;

        } catch (BadCredentialsException e) {
            throw new BadCredentialsException("Authentication failed");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}

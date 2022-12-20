package com.nhnacademy.office.service;

import com.nhnacademy.office.entity.Resident;
import com.nhnacademy.office.repository.resident.ResidentRepository;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collections;

public class GithubUserDetailsService implements UserDetailsService {
    private final ResidentRepository repository;

    public GithubUserDetailsService(ResidentRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
    public User authenticateUser(String email){
        Resident resident = repository.findByEmail(email)
                .orElseThrow(() -> new BadCredentialsException("Invalid credentials"));

        return new User(
                resident.getId(),
                resident.getPassword(),
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"))
        );
    }
}

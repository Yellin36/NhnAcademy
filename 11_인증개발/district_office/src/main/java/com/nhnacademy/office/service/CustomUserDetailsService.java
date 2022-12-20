package com.nhnacademy.office.service;

import com.nhnacademy.office.entity.Resident;
import com.nhnacademy.office.exception.NotFoundException;
import com.nhnacademy.office.repository.resident.ResidentRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final ResidentRepository residentRepository;

    public CustomUserDetailsService(ResidentRepository residentRepository) {
        this.residentRepository = residentRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Resident resident = residentRepository.findById(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));

        return new User(
                resident.getId(),
                resident.getPassword(),
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER")));
    }
}

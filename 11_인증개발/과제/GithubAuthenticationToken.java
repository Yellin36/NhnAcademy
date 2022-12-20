package com.nhnacademy.office.auth;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.Collections;

public class GithubAuthenticationToken extends AbstractAuthenticationToken {

    private final Object principal;

    private Object credentials;

    public GithubAuthenticationToken(Object principal,
                                     Object credentials) {
        super(Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER")));
        this.principal = principal;
        this.credentials = credentials;
    }

    @Override
    public Object getCredentials() {
        return this.credentials;
    }

    @Override
    public Object getPrincipal() {
        return this.principal;
    }
}

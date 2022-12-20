package com.nhnacademy.office.service.github;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface GithubLoginService {
    String login(String code) throws JsonProcessingException;
}

package com.nhnacademy.edu.jdbc.repository;

import com.nhnacademy.edu.jdbc.domain.Registration;

import java.sql.Connection;
import java.util.List;

public interface RegistrationRepository {

    List<Registration> findAll(Connection connection);

}
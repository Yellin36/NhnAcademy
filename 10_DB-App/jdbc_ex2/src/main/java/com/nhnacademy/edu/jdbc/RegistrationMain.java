package com.nhnacademy.edu.jdbc;

import com.nhnacademy.edu.jdbc.domain.Registration;
import com.nhnacademy.edu.jdbc.repository.PsmtRegistrationRepository;
import com.nhnacademy.edu.jdbc.repository.RegistrationRepository;
import com.nhnacademy.edu.jdbc.utils.DBUtils;

import java.sql.Connection;
import java.sql.SQLException;

public class RegistrationMain {
    public static void main(String[] args) throws SQLException {
        DBUtils.loadDriver();
        try (Connection connection = DBUtils.getDataSource().getConnection()) {

            RegistrationRepository registrationRepository = new PsmtRegistrationRepository();
            registrationRepository.findAll(connection)
                    .stream()
                    .map(Registration::toFormattedString)
                    .forEach(System.out::println);

        }
    }
}

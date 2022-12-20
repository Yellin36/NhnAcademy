package com.nhnacademy.edu.jdbc.utils;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
    private static final DataSource DATASOURCE;
    private DBUtils() {}

    public static void loadDriver() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            // DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public static Connection getConnection() {
        String url = "jdbc:mysql://133.186.151.141:3306/nhn_academy_53";
        String user = "nhn_academy_53";
        String password = "mwp575m]KcVFT6tS";

        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static DataSource getDataSource() {
        return DATASOURCE;
    }

    // 장점 : 보안적인 안전함
    static {
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setUrl("jdbc:mysql://133.186.151.141:3306/nhn_academy_53");
        basicDataSource.setUsername("nhn_academy_53");
        basicDataSource.setPassword("mwp575m]KcVFT6tS");
        basicDataSource.setInitialSize(2);
        basicDataSource.setMaxTotal(2);
        basicDataSource.setMaxWaitMillis(1000);

        DATASOURCE = basicDataSource;
    }
}

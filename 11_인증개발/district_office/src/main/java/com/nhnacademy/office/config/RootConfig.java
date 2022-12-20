package com.nhnacademy.office.config;

import com.nhnacademy.office.Base;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

import javax.sql.DataSource;

@Controller
@ComponentScan(basePackageClasses = Base.class,
        excludeFilters = @ComponentScan.Filter(Controller.class))
public class RootConfig {
    @Bean
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(com.mysql.cj.jdbc.Driver.class.getName());
        dataSource.setUrl("jdbc:mysql://133.186.151.141:3306/nhn_academy_53");
        dataSource.setUsername("nhn_academy_53");
        dataSource.setPassword("mwp575m]KcVFT6tS");

        dataSource.setInitialSize(10);
        dataSource.setMaxTotal(10);
        dataSource.setMinIdle(10);
        dataSource.setMaxIdle(10);

        dataSource.setMaxWaitMillis(1000);

        dataSource.setTestOnBorrow(true);
        dataSource.setTestOnReturn(true);
        dataSource.setTestWhileIdle(true);

        return dataSource;
    }

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}

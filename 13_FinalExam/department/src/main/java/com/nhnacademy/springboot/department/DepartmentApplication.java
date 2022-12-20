package com.nhnacademy.springboot.department;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class DepartmentApplication {

    public static void main(String[] args) {
        SpringApplication.run(DepartmentApplication.class, args);
    }
    //java -Dinit.file.name=/Users/yerin/department.txt -jar target/application.jar
    //curl -X GET "http://localhost:8080/department-members?departmentIds=L1001" -H "Accept: application/json"
    //curl -X GET "http://localhost:8080/department-members?departmentIds=L1001,L1003" -H "Accept: application/json"
}

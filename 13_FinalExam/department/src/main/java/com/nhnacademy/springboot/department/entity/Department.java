package com.nhnacademy.springboot.department.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "departments")
public class Department {
    @Id
    @Column(name = "department_id")
    private String id;

    @Column(name = "department_name")
    private String name;
}

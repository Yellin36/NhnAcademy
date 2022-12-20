package com.nhnacademy.edu.springboot.student.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Student")
public class Student {
    @Id
    private Long id;
    private String name;
    private Integer score;
}

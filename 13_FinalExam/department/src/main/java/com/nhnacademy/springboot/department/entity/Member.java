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
@Table(name = "members")
public class Member {
    @Id
    @Column(name = "member_id")
    private Long id;

    @Column(name = "member_name")
    private String name;
}

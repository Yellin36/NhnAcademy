package com.nhnacademy.springboot.backaccount.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@ToString
@NoArgsConstructor
@Entity
@Table(name = "Account")
public class Account {
    @Id
    private Long id;
    private String number;
    private Integer balance;
}

package com.nhnacademy.springboot.account.openaccount.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "Account")
public class Account {
    @Id
    private Long id;
    private String number;
    private Integer balance;
}

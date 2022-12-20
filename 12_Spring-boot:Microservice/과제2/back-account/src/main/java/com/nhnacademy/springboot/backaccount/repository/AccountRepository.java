package com.nhnacademy.springboot.backaccount.repository;

import com.nhnacademy.springboot.backaccount.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {

}

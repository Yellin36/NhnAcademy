package com.nhnacademy.springboot.department.repository;

import com.nhnacademy.springboot.department.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    @Transactional
    @Modifying
    @Query(value = "truncate members", nativeQuery = true)
    void truncate();

}

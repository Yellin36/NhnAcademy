package com.nhnacademy.edu.jdbc1.service.subject;

import com.nhnacademy.edu.jdbc1.domain.Subject;

public interface SubjectRepository {
    Subject findById(int id);

    int updateNameById(int id, String name);

    int insert(String subject);

    int deleteById(int id);

}


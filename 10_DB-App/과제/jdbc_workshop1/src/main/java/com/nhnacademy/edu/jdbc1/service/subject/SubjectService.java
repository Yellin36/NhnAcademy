package com.nhnacademy.edu.jdbc1.service.subject;

import com.nhnacademy.edu.jdbc1.domain.Subject;

public interface SubjectService {
    Subject createSubject(String subjectName);

    Subject modifyNameById(int id, String name);

    void deleteSubject(int subjectId);
}

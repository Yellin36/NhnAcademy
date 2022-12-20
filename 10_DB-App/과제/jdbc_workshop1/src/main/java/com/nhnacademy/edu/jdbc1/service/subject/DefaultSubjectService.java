package com.nhnacademy.edu.jdbc1.service.subject;

import com.nhnacademy.edu.jdbc1.domain.Subject;
import org.springframework.stereotype.Service;

@Service
public class DefaultSubjectService implements SubjectService {
    private final SubjectRepository subjectRepository;

    public DefaultSubjectService(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    @Override
    public Subject createSubject(String subjectName) {
        int id = subjectRepository.insert(subjectName);

        Subject subject = subjectRepository.findById(id);
        return subject;
    }

    @Override
    public Subject modifyNameById(int id, String name) {
        subjectRepository.updateNameById(id, name);

        return subjectRepository.findById(id);
    }

    @Override
    public void deleteSubject(int id) {
        subjectRepository.deleteById(id);
    }
}

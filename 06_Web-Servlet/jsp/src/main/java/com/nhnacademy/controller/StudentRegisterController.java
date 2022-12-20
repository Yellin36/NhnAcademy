package com.nhnacademy.controller;

import com.nhnacademy.domain.Student;
import com.nhnacademy.domain.StudentRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StudentRegisterController implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        Student student = new Student(
                request.getParameter("id"),
                request.getParameter("name"),
                request.getParameter("gender"),
                Integer.parseInt(request.getParameter("age"))
        );
        StudentRepository studentRepository = (StudentRepository) request.getServletContext().getAttribute("studentRepository");
        studentRepository.addStudent(student);

        return "redirect:/student/view.do?id=" + student.getId();
    }
}

package com.nhnacademy.controller;

import com.nhnacademy.domain.Student;
import com.nhnacademy.domain.StudentRepository;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

public class StudentViewController implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        ServletContext servletContext = request.getServletContext();

        StudentRepository studentRepository =
                (StudentRepository) servletContext.getAttribute("studentRepository");

        String id = request.getParameter("id");

        Student student = studentRepository.getStudent(id);
        if(Objects.isNull(student)) { //없는 학번인 경우
//            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return "/404";
        }
        else {
            request.setAttribute("student", student);

            return "/studentView.jsp";
        }
    }
}

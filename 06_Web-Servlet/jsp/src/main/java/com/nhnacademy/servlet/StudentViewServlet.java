package com.nhnacademy.servlet;

import com.nhnacademy.domain.Student;
import com.nhnacademy.domain.StudentRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@WebServlet(name="studentViewServlet", urlPatterns = "/student/view")
public class StudentViewServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = req.getServletContext();

        StudentRepository studentRepository =
                (StudentRepository) servletContext.getAttribute("studentRepository");

        String id = req.getParameter("id");

        Student student = studentRepository.getStudent(id);
        if(Objects.isNull(student)) { //없는 학번인 경우
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
        else {
            req.setAttribute("student", student);
            req.setAttribute("view", "/studentView.jsp");
//            RequestDispatcher rd = req.getRequestDispatcher("/studentView.jsp");
//            rd.forward(req, resp);
        }

    }
}

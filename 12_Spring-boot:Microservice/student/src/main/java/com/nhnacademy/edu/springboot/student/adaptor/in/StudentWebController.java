package com.nhnacademy.edu.springboot.student.adaptor.in;

import com.nhnacademy.edu.springboot.student.domain.Student;
import com.nhnacademy.edu.springboot.student.domain.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/web")
public class StudentWebController {
    private final StudentService studentService;

    @GetMapping("/students/{id}")
    public String getStudent(@PathVariable("id")Long id,  Model model) {
        Student student = studentService.getStudent(id);
        model.addAttribute("student", student);

        return "student";
    }
}

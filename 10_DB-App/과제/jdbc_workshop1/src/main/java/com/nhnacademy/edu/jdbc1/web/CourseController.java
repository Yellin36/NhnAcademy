package com.nhnacademy.edu.jdbc1.web;

import com.nhnacademy.edu.jdbc1.domain.Course;
import com.nhnacademy.edu.jdbc1.domain.Subject;
import com.nhnacademy.edu.jdbc1.domain.Teacher;
import com.nhnacademy.edu.jdbc1.service.course.CourseService;
import com.nhnacademy.edu.jdbc1.service.subject.SubjectService;
import com.nhnacademy.edu.jdbc1.service.teacher.TeacherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Slf4j
@Controller
public class CourseController {
    private final CourseService courseCreationService;
    private final SubjectService subjectCreationService;
    private final TeacherService teacherCreationService;

    public CourseController(CourseService courseCreationService,
                            SubjectService subjectCreationService,
                            TeacherService teacherCreationService) {
        this.courseCreationService = courseCreationService;
        this.subjectCreationService = subjectCreationService;
        this.teacherCreationService = teacherCreationService;
    }

    @GetMapping("/")
    public String root() {
        return "index";
    }

    @GetMapping("/course")
    public String getCourse(Model model) throws SQLException {
        List<Course> courses = courseCreationService.getAllCourses();

        model.addAttribute("courses", courses);

        return "main";
    }

    @GetMapping("/course/delete/{courseId}")
    public String deleteCourse(@PathVariable("courseId") int courseId) throws SQLException {
        Course course = courseCreationService.getCourseById(courseId);
        int subjectId = course.getSubject().getId();
        int teacherId = course.getTeacher().getId();

        courseCreationService.deleteCourse(courseId);
        subjectCreationService.deleteSubject(subjectId);
        teacherCreationService.deleteTeacher(teacherId);

        return "redirect:/course";
    }

    @GetMapping("/course/register")
    public String showRegisterCourseForm() {
        return "register";
    }

    @PostMapping("/course/register")
    public String registerCourse(@RequestParam("subject") String subjectName,
                                 @RequestParam("teacher") String teacherName) {
        if (Objects.isNull(subjectName) || Objects.isNull(teacherName)) {
            return "redirect:/course";
        }
        Subject subject = subjectCreationService.createSubject(subjectName);
        Teacher teacher = teacherCreationService.createTeacher(teacherName);

        Course course = new Course(teacher, subject, new Date());

        courseCreationService.insert(course);

        return "redirect:/course";
    }

    @GetMapping("/course/modify/{courseId}")
    public ModelAndView showModifyCourseForm(@PathVariable("courseId") int courseId,
                                             Model model) {
        ModelAndView mav = new ModelAndView("main");
        List<Course> courses = courseCreationService.getAllCourses();

        mav.addObject("courses", courses);
        mav.addObject("courseId", courseId);

        return mav;
    }

    @PostMapping("/course/modify/{courseId}")
    public String modifyCourse(@PathVariable("courseId") int courseId,
                               @RequestParam("teacher") String teacherName,
                               @RequestParam("subject") String subjectName) {
        if (Objects.isNull(subjectName) || Objects.isNull(teacherName)) {
            return "redirect:/course";
        }
        Course course = courseCreationService.getCourseById(courseId);
        int subjectId = course.getSubject().getId();
        int teacherId = course.getTeacher().getId();

        Subject subject = subjectCreationService.modifyNameById(subjectId, subjectName);
        Teacher teacher = teacherCreationService.modifyNameById(teacherId, teacherName);

        courseCreationService.modify(courseId, teacher, subject);

        return "redirect:/course";
    }
}

package com.example.demo.controllers;

import com.example.demo.models.Student;
import com.example.demo.repositories.CoursesRepositoryImpl;
import com.example.demo.repositories.ICoursesRepository;
import com.example.demo.repositories.IStudentRepository;
import com.example.demo.repositories.StudentRepositoryImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CoursesController {

    private ICoursesRepository coursesRepository;

    // InMemoryStudentRepositoryImpl eller StudentRepositoryImpl
    public CoursesController() {
        coursesRepository = new CoursesRepositoryImpl();
    }

    @GetMapping("/courses/courses")
    public String index(Model model) {
        model.addAttribute("courses", coursesRepository.readAll());
        return "/courses/courses";
    }

    @GetMapping("/courses/create")
    public String getCreate(Courses courses) {
        return "/courses/create";
    }

    @PostMapping("/courses/create")
    public String postCreate(Courses courses) {
        coursesRepository.create(courses);
        return "redirect:/courses/courses";
    }

    @GetMapping("/courses/delete")
    public String getDelete(@RequestParam int idCourses, Model model) {
        model.addAttribute("deleteCourses", coursesRepository.read(idCourses));
        //Student deleteStudent = studentRepository.read(id);
        return "courses/delete";
    }

    @PostMapping("/courses/delete")
    public String postDelete(int idCourses) {
        coursesRepository.delete(idCourses);
        return "redirect:/courses/courses";
    }

    @GetMapping("/courses/detail")
    public String detail(@RequestParam int idCourses,Model model) {
        model.addAttribute("detailCourses", coursesRepository.read(idCourses));
        return "courses/detail";
    }

    @GetMapping("/courses/update")
    public String getUpdate(@RequestParam int idCourses, Model model){
        model.addAttribute("updateCourses", coursesRepository.read(idCourses));
        return "courses/update";
    }
    @PostMapping("/courses/update")
    public String postUpdate(Courses courses) {
        coursesRepository.update(courses);
        return "redirect:/courses/courses";
    }


    //Very simple prototype of GET-request with parameter
    //https://www.baeldung.com/spring-request-param
    //TODO Direct to detailed view of student
    @GetMapping("/courses/courses")
    @ResponseBody
    public String getCoursesByParameter(@RequestParam int idCourses) {
        Courses cou = coursesRepository.read(idCourses);
        return "ID: " + idCourses + " Name: " + cou.courseName + "";
    }
}

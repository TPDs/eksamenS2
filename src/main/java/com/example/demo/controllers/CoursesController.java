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

    @GetMapping("/courses")
    public String index(Model model) {
        model.addAttribute("courses", coursesRepository.readAll());
        return "/courses";
    }

    @GetMapping("/courses/create")
    public String getCreate(Courses courses) {
        return "/courses/create";
    }

    @PostMapping("/courses/create")
    public String postCreate(Courses courses) {
        coursesRepository.create(courses);
        return "redirect:/";
    }

    @GetMapping("/student/delete")
    public String getDelete(@RequestParam int id, Model model) {
        model.addAttribute("deleteStudent", studentRepository.read(id));
        //Student deleteStudent = studentRepository.read(id);
        return "student/delete";
    }

    @PostMapping("/student/delete")
    public String postDelete(int id) {
        System.out.println("Michal");
        studentRepository.delete(id);
        return "redirect:/";
    }

    @GetMapping("/student/detail")
    public String detail(@RequestParam int id,Model model) {
        model.addAttribute("detailStudent", studentRepository.read(id));
        return "student/detail";
    }

    @GetMapping("/student/update")
    public String getUpdate(@RequestParam int id, Model model){
        model.addAttribute("updateStudent", studentRepository.read(id));
        return "student/update";
    }
    @PostMapping("/student/update")
    public String postUpdate(Student student) {
        System.out.println(student.firstName);
        System.out.println("Helda");
        studentRepository.update(student);
        return "redirect:/";
    }


    //Very simple prototype of GET-request with parameter
    //https://www.baeldung.com/spring-request-param
    //TODO Direct to detailed view of student
    @GetMapping("/student")
    @ResponseBody
    public String getStudentByParameter(@RequestParam int id) {
        Student stu = studentRepository.read(id);
        return "ID: " + id + " Name: " + stu.firstName + "";
    }
}

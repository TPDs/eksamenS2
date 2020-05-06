package com.example.demo.controllers;

import com.example.demo.models.Student;
import com.example.demo.repositories.IStudentRepository;
import com.example.demo.repositories.StudentRepositoryImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController {


    private IStudentRepository studentRepository;

    // InMemoryStudentRepositoryImpl eller StudentRepositoryImpl
    public StudentController() {
        studentRepository = new StudentRepositoryImpl();
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("students", studentRepository.readAll());
        return "index";
    }

    @GetMapping("/topbanner")
    public String topBanner(Model model) {
        model.addAttribute("students", studentRepository.readAll());
        return "topbanner";
    }


    @PostMapping("/create")
    public String create(@ModelAttribute Student student){
        studentRepository.create(student);
        return "redirect:/";
    }


    @GetMapping("/student/create")
    public String create() {
        return "/student/create";
    }

    @GetMapping("/student/delete")
    public String delete() {
        return "student/delete";
    }

    @GetMapping("/student/detail")
    public String detail() {
        return "student/detail";
    }

    @GetMapping("/student/update")
    public String update(){
        return "student/update";
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
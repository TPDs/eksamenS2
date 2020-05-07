package com.example.demo.controllers;

import com.example.demo.models.Student;
import com.example.demo.repositories.IStudentRepository;
import com.example.demo.repositories.StudentRepositoryImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @GetMapping("/student/create")
    public String getCreate(Student student) {
        return "/student/create";
    }

    @PostMapping("/student/create")
    public String postCreate(Student student) {
        System.out.println(student.firstName);
        System.out.println("Helda");
        studentRepository.create(student);
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
        studentRepository.delete(id);
        return "redirect:/";
    }

    @GetMapping("/student/detail")
    public String detail(@RequestParam int id,Model model) {
        model.addAttribute("deleteStudent", studentRepository.read(id));
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
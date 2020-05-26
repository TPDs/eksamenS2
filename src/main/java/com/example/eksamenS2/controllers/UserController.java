package com.example.eksamenS2.controllers;

import com.example.eksamenS2.models.Users;
import com.example.eksamenS2.repositories.UsersRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class UserController {

    private UsersRepository UsersRepository;

    public UserController() {
        UsersRepository = new UsersRepository();
    }

    @GetMapping("/login")
    public String StaffLogin(Users users, Model model) {
        //model.addAttribute("staff",UsersRepository.read(users));
        //System.out.println(users.getFirstName() + " Password:" + users.getPassword());
        return "login";
    }

    @PostMapping("/login")
    public String Login(Users users, Model model) {
        model.addAttribute("staff", UsersRepository.read(users));
        return "index";
    }


}

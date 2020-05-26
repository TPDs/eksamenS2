package com.example.eksamenS2.controllers;

import com.example.eksamenS2.models.Customer;
import com.example.eksamenS2.models.Users;
import com.example.eksamenS2.repositories.UsersRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    private UsersRepository UsersRepository;

    public UserController() {
        UsersRepository = new UsersRepository();
    }

    @PostMapping("/login")
    public String postCreate(Users users) {
        UsersRepository.read(users);
        return "redirect:/";
    }

}

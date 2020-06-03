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
    public String Login() {

        return "/login";
    }

    @GetMapping("/index")
    public String index() {

        return "redirect:/";
    }

// MP , Denne bliver dog ikke kørt da Spring Boot security overtager Login
    @PostMapping("/login")
    public String Login(String username, String password, Model model) {
        Users users = new Users(username, password);
        model.addAttribute("staff", UsersRepository.read(users));
        System.out.println(users.getFirstName() + " Password:" + users.getPassword());
        return "/login";
    }
/*
    @PostMapping("/login")
    public String Login(Users users, Model model) {
        model.addAttribute("Staff", UsersRepository.read(users));
        String test = String.valueOf(UsersRepository.read(users).getRole());
        System.out.println(test);
        model.addAttribute("Role", test);
        return "redirect:/";
    }
*/

}

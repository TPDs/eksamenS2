package com.example.eksamenS2.controllers;


import com.example.eksamenS2.repositories.AccItemsRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccController {

    private AccItemsRepository accItemsRepository;

    public AccController(){accItemsRepository = new AccItemsRepository();}

    @GetMapping("/accessories/showAccessories")
    public String showAcc(Model model){
        model.addAttribute("accessories", accItemsRepository.readAll());
        return "/accessories/showAccessories";
    }

}

package com.example.eksamenS2.controllers;

import com.example.eksamenS2.repositories.TypeListRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TypeListController {

    private TypeListRepository typesRepository;
    public TypeListController(){
        typesRepository = new TypeListRepository();}


        @GetMapping("/motorhomes/chooseType")
    public String GetTypes(Model model){
        model.addAttribute("readAllTypes",typesRepository.readAllTypes());
        return "/motorhomes/chooseType";
        }

//        @GetMapping("/motorhomes/chooseType")
//    public String GetStatuses(Model model)

}

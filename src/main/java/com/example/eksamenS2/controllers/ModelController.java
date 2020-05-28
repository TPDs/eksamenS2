package com.example.eksamenS2.controllers;

import com.example.eksamenS2.models.Models;
import com.example.eksamenS2.repositories.ModelRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ModelController {

    private ModelRepository modelRepository;
    public ModelController(){modelRepository = new ModelRepository();}

    // denne kode snippet har jeg lavet for at prøve at få model udpring til at virke
    //oprette motorhomes med " vise modeller ved motorhome oprettelse"

//    @GetMapping("/models/addModels")
//    public String index(Model model) {
//        model.addAttribute("Models", modelRepository.readAll());
//        return "index";
//    }

    @GetMapping("/models/addModels")
    public String getModel(Models models){
        return "/models/addModels";
    }

    @PostMapping("/models/addModels")
    public String postModel(Models models) {
        modelRepository.create(models);
        return "redirect:/";
    }

        @GetMapping("/motorHome/addMotorhome")
            public String AddModelToHtmlList(Model model)  {
            model.addAttribute("Models", modelRepository.readAll());
                    return"/motorhomes/addMotorhome";
    }

}

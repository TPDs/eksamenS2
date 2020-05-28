package com.example.eksamenS2.controllers;

import com.example.eksamenS2.models.Models;
import com.example.eksamenS2.models.MotorHome;
import com.example.eksamenS2.repositories.ModelRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ModelController {

    private ModelRepository modelRepository;

    public ModelController() {
        modelRepository = new ModelRepository();
    }

    @GetMapping("/models/addModels")
    public String index(Model model) {
        model.addAttribute("Models", modelRepository.readAll());
        return "index";
    }


    @PostMapping("/models/addModels")
    public String postModel(Models models) {
        modelRepository.create(models);
        return "redirect:/";
    }

    @GetMapping("/motorhomes/addMotorhome")
    public String showModel(Model model, MotorHome motorHome) {
        model.addAttribute("Models", modelRepository.readAll());
        return "/motorhomes/addMotorhome";
    }

    @GetMapping("/models/detailModels")
    public String getDetailModel(@RequestParam String id, Model model){
        model.addAttribute("detailModel", modelRepository.read(id));
        return "/models/detailModels";
    }


}

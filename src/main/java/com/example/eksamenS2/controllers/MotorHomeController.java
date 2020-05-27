package com.example.eksamenS2.controllers;

import com.example.eksamenS2.models.MotorHome;
import com.example.eksamenS2.repositories.MotorHomeRepositoryImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MotorHomeController {

    private MotorHomeRepositoryImpl motorhomeRep;
    public MotorHomeController(){motorhomeRep = new MotorHomeRepositoryImpl();}

    @GetMapping("/motorhomes")
    public String GetMotorhome(MotorHome motorHome){
        return "/motorhomes/detailMotorhome";
    }

    @GetMapping ("/motorhomes/addMotorhome")
    public String addMotorhome(MotorHome motorHome){ return "/motorhomes/addMotorhome";}

    @PostMapping("/motorhomes/addMotorhome")
    public String postMotorhome(MotorHome motorHome){
        motorhomeRep.create(motorHome);
        return "redirect:/";
    }
}

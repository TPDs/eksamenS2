package com.example.eksamenS2.controllers;

import com.example.eksamenS2.models.MotorHome;
import com.example.eksamenS2.repositories.MotorHomeRepositoryImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MotorHomeController {

    private MotorHomeRepositoryImpl motorhomeRep;
    public MotorHomeController(){motorhomeRep = new MotorHomeRepositoryImpl();}

    @GetMapping("/motorhomes")
    public String GetMotorhome(MotorHome motorHome){
        return "/motorhomes/detailMotorhome";
    }


}

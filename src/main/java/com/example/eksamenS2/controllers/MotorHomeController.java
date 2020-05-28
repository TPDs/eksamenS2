package com.example.eksamenS2.controllers;

import com.example.eksamenS2.models.MotorHome;
import com.example.eksamenS2.repositories.MotorHomeRepositoryImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MotorHomeController {

    private MotorHomeRepositoryImpl motorhomeRep;
    public MotorHomeController(){motorhomeRep = new MotorHomeRepositoryImpl();}

    @GetMapping("/motorhomes/detailMotorhome")
    public String GetMotorhome(MotorHome motorHome){
        return "/motorhomes/detailMotorhome";
    }

    @PostMapping("/motorhomes/addMotorhome")
    public String postMotorhome(MotorHome motorHome){
        motorhomeRep.create(motorHome);
        return "redirect:/";
    }

    @GetMapping("/motorhomes/updateMotorhome")
    public String getUpdateMotorhome(@RequestParam int id, Model model){
        MotorHome motorhome = new MotorHome();
        model.addAttribute("updateMotorHome", motorhomeRep.read(id));
        return "/motorhomes/updateMotorhome";

    }

    @PostMapping("/motorhomes/updateMotorhome")
    public String postUpdateMotorhome(MotorHome motorHome){
        motorhomeRep.update(motorHome);
        return "redirect:/";
    }

// til models læsning i motorhome oprettelse
//    @GetMapping("/motorHome/addMotorhome")
//            public String showModel(Model model)  {
//            model.addAttribute("Models", motorhomeRep.readAll());
//                    return"/motorhomes/addMotorhome";
//    }

}

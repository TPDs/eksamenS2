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


    //Lavet af Christian
    @GetMapping("/motorhomes/detailMotorhome")
    public String getDetailMotorhome(@RequestParam int id, Model model, MotorHome motorHome){
        model.addAttribute("detailMotorhome", motorhomeRep.read(id));
        return "/motorhomes/detailMotorhome";
    }


    //Lavet af Christian
    @PostMapping("/motorhomes/detailMotorhome")
    public String updateMotorhomeStatus(MotorHome detailMotorhome){
        motorhomeRep.updateStatus(detailMotorhome);
        return "redirect:/";
    }


    @PostMapping("/motorhomes/addMotorhome")
    public String postMotorhome(MotorHome motorHome){
        motorhomeRep.create(motorHome);
        return "redirect:/";
    }


    //Lavet af Christian
    @GetMapping("/motorhomes/updateMotorhome")
    public String getUpdateMotorhome(@RequestParam int id, Model model){
        model.addAttribute("updateMotorHome", motorhomeRep.read(id));
        return "/motorhomes/updateMotorhome";

    }

    @PostMapping("/motorhomes/updateMotorhome")
    public String postUpdateMotorhome(MotorHome motorHome){
        motorhomeRep.update(motorHome);
        return "redirect:/";
    }


    //Lavet af Christian

    @GetMapping("/motorhomes/deleteMotorhome")
    public String getDeleteMotorhome(@RequestParam int id, Model model){
        model.addAttribute("deleteMotorhome", motorhomeRep.read(id));
        return "/motorhomes/deleteMotorhome";
    }


    //Lavet af Christian

    @PostMapping("/motorhomes/deleteMotorhome")
    public String postDeleteMotorhome(MotorHome motorhome){
        motorhomeRep.delete(motorhome);
        return "redirect:/";
    }




}

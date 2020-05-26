package com.example.eksamenS2.controllers;

import com.example.eksamenS2.models.Customer;
import com.example.eksamenS2.repositories.CustomerRepositoryImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {

private CustomerRepositoryImpl customerRep;
    public CustomerController(){customerRep = new CustomerRepositoryImpl();}

    @GetMapping("/customers/addCustomer")
    public String getCustomer(Customer customer){
        return "/customers/addCustomer";
    }

    @PostMapping("/customers/addCustomer")
    public String PostCustomer(Customer customer){
        customerRep.create(customer);
        return "redirect:/";
    }
}

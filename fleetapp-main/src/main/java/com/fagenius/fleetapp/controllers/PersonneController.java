package com.fagenius.fleetapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PersonneController {
    @GetMapping("/personnes")
    public String getPersonnes(){
        return "Person";
    }
}

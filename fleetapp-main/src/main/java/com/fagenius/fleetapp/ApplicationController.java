package com.fagenius.fleetapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApplicationController {
    // Ici, on definit la methode qui va par defaut nous rediriger vers la page index
    @GetMapping("/index")
    public String goHome(){
        return "index";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }
    @GetMapping("logout")
    public String logout(){
        return "login";
    }
    @GetMapping("/register")
    public String register(){
        return "register";
    }
}

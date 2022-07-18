package com.isi.tpspringboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Controlleur {
    // Ici, on definit la methode qui va par defaut nous rediriger vers la page index
    @GetMapping("/index")
    public String goHome(){
        return "index";
    }
}

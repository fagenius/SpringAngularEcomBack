package com.test.TestDevoir.contolers;

import com.test.TestDevoir.domaines.Pret;
import com.test.TestDevoir.metiers.Traitement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class Controleur {
    @Autowired
    private Traitement tr;

    @GetMapping("/")
    public String chargeFormulaire(Model modele)
    {
        Pret pret = new Pret();
        modele.addAttribute(	"pret", pret);
        return "entree";
    }

    @PostMapping(value = "/traite")
    public String process(@ModelAttribute("pret") Pret pret)
    {
        tr.calcule(pret);
        return "sortie";
    }
}

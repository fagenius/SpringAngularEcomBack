package com.isi.devoir.controler;
import com.isi.devoir.metier.Traitement;
import com.isi.devoir.model.Impot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Controleur {

    @Autowired
    private Traitement tr;

    @GetMapping("/")
    public String chargeFormulaire(Model modele)
    {
        Impot impot = new Impot();
        modele.addAttribute(	"impot", impot);
        return "entree";
    }

    @PostMapping(value = "/traite")
    public String process(@ModelAttribute("impot") Impot impot)
    {
        tr.calcule(impot);
        return "sortie";
    }
}

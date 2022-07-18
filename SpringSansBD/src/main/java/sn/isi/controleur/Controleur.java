package sn.isi.controleur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import sn.isi.domaine.Pret;
import sn.isi.metier.Traitement;
@Controller
public class Controleur
{
   @Autowired	
   private Traitement tr;
   
   @GetMapping("/")
   public String chargeFormulaire(Model modele)
   {
	   Pret pret = new Pret();
	   modele.addAttribute(	"pret", pret);
	   return "entree";
   }
   
   @PostMapping("/traite")
   public String process(@ModelAttribute("pret") Pret pret)
   {
	   tr.calcule(pret);
	   return "sortie";
   }
   
}

package sn.isi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import sn.isi.domaine.Categorie;
import sn.isi.domaine.Produit;
import sn.isi.repository.CategorieRepository;
import sn.isi.repository.ProduitRepository;

@SpringBootApplication
public class ProjetBdApplication implements CommandLineRunner
{
   @Autowired	
   private CategorieRepository repoc;
   @Autowired	
   private ProduitRepository repop;
	
   public static void main(String[] args) {
		SpringApplication.run(ProjetBdApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception
	{
	    sauver();			
	}
   public void sauver()
   {
	   Categorie c1 = new Categorie();
	   c1.setCodecateg("CO1");
	   c1.setNomcateg("mobiles");
	   
	   Categorie c2 = new Categorie();
	   c2.setCodecateg("CO2");
	   c2.setNomcateg("imprimantes");
	
	   repoc.save(c1);
	   repoc.save(c2);
	   
	   Produit p1 = new Produit();
	   p1.setNomprod("A5O Samsung");
	   p1.setPrix(180000);
	   
	   Produit p2 = new Produit();
	   p2.setNomprod("A2O Samsung");
	   p2.setPrix(76000);
	   
	   Produit p3 = new Produit();
	   p3.setNomprod("EPSON FX-1000");
	   p3.setPrix(200000);
	   
	   Produit p4 = new Produit();
	   p4.setNomprod("EPSON FX-2000");
	   p4.setPrix(400000);
	   
	   p1.setCategorie(c1);
	   p2.setCategorie(c1);
	   c1.ajouterProduit(p1);
	   c1.ajouterProduit(p2);
	   repop.save(p1);
	   repop.save(p2);
	   
	   p3.setCategorie(c2);
	   p4.setCategorie(c2);
	   c2.ajouterProduit(p3);
	   c2.ajouterProduit(p4);
	   repop.save(p3);
	   repop.save(p4);
   
   }
}

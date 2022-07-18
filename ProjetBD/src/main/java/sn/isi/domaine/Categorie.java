package sn.isi.domaine;
// classe entité esclave
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="categories")
public class Categorie implements Serializable 
{
   @Id
   @Column(length=25)
   private String codecateg;
   @NotEmpty(message="le nom de la catégorie ne peut être vide")
   @Column(length=75)
   private String nomcateg;
   @OneToMany(mappedBy="categorie",cascade=CascadeType.ALL,fetch=FetchType.EAGER)   
   private List<Produit> listeprod;
   
   public Categorie()
   {
	   listeprod =new ArrayList<Produit>();
   }

public String getCodecateg() {
	return codecateg;
}

public void setCodecateg(String codecateg) {
	this.codecateg = codecateg;
}

public String getNomcateg() {
	return nomcateg;
}

public void setNomcateg(String nomcateg) {
	this.nomcateg = nomcateg;
}

public List<Produit> getListeprod() {
	return listeprod;
}

public void setListeprod(List<Produit> listeprod) {
	this.listeprod = listeprod;
}

public void ajouterProduit(Produit produit)
{
	listeprod.add(produit);
}
}
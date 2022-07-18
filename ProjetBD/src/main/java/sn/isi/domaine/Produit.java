package sn.isi.domaine;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

// classe entité maître
@Entity
@Table(name="produits")
public class Produit implements Serializable
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idproduit;
	@NotEmpty(message="le nom du produit ne peut être vide")
	@Column(length=75)
	private String nomprod;
	@NotNull(message="le prix doit être différent de zéro")
	private Integer prix;
	@ManyToOne
	@JoinColumn(name="codecateg")
	private Categorie categorie;
	
	public Produit()
	{
		
	}

	public Integer getIdproduit() {
		return idproduit;
	}

	public void setIdproduit(Integer idproduit) {
		this.idproduit = idproduit;
	}

	public String getNomprod() {
		return nomprod;
	}

	public void setNomprod(String nomprod) {
		this.nomprod = nomprod;
	}

	public Integer getPrix() {
		return prix;
	}

	public void setPrix(Integer prix) {
		this.prix = prix;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

}

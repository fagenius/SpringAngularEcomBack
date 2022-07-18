package sn.isi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sn.isi.domaine.Produit;

public interface ProduitRepository extends JpaRepository<Produit,Integer>
{

}

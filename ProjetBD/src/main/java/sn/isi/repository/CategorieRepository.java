package sn.isi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sn.isi.domaine.Categorie;

public interface CategorieRepository extends JpaRepository<Categorie,String>
{
    public Categorie findByCodecateg(String codecateg);
}

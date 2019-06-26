package fr.oc.projet.microservicecategorie.dao;


import fr.oc.projet.microservicecategorie.model.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategorieDao extends JpaRepository<Categorie,Integer> {

    Categorie findById(int id);
}

package fr.oc.projet.microservicelivre.dao;

import fr.oc.projet.microservicelivre.model.Livre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivreDao extends JpaRepository<Livre,Integer> {

    Livre findById(int id);

    List<Livre> findLivresByTitreContaining(String titre);

    List<Livre> findLivresByAuteurContaining(String auteur);

    List<Livre> findLivresByIsbnContaining(String isbn);

    List<Livre> findLivresByTitreContainingAndAuteurContainingAndIsbnContaining(String titre,String auteur,String isbn );

    List<Livre> findLivresByAuteurContainingAndIsbnContaining(String auteur,String isbn);

    List<Livre> findLivresByTitreContainingAndIsbnContaining(String titre, String isbn );

    List<Livre> findLivresByTitreContainingAndAuteurContaining(String titre,String auteur);

}

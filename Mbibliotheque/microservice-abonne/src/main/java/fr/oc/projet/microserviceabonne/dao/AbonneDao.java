package fr.oc.projet.microserviceabonne.dao;

import fr.oc.projet.microserviceabonne.model.Abonne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AbonneDao extends JpaRepository<Abonne,Integer> {
    Abonne findById(int id);

    Abonne findByPseudo(String pseudo);

    Abonne findByEmail(String email);

}

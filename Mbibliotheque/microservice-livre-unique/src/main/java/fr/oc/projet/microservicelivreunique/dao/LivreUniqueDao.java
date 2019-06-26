package fr.oc.projet.microservicelivreunique.dao;

import fr.oc.projet.microservicelivreunique.model.LivreUnique;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivreUniqueDao extends JpaRepository<LivreUnique,Integer> {
    Integer countLivreUniqueByLivreIdAndBibliothequeId(int livreId, int bibliothequeId);

    Integer countLivreUniqueByLivreId(int livreId);
}

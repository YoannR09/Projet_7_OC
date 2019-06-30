package fr.oc.projet.microservicelivreunique.dao;

import fr.oc.projet.microservicelivreunique.model.LivreUnique;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivreUniqueDao extends JpaRepository<LivreUnique,Integer> {
    LivreUnique findById(int id);

    Integer countLivreUniqueByLivreIdAndBibliothequeIdAndDisponibleIsTrue(int livreId, int bibliothequeId);

    Integer countLivreUniqueByLivreIdAndDisponibleIsTrue(int livreId);


}

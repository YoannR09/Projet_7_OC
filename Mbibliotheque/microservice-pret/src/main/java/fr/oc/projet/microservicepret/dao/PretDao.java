package fr.oc.projet.microservicepret.dao;

import fr.oc.projet.microservicepret.model.Pret;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PretDao extends JpaRepository<Pret,Integer> {

    List<Pret> findPretByAbonneId(int abonneId);

    Pret findById(int id);
}

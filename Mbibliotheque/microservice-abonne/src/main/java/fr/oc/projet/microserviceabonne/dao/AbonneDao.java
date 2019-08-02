package fr.oc.projet.microserviceabonne.dao;

import fr.oc.projet.microserviceabonne.model.Abonne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AbonneDao extends JpaRepository<Abonne,Integer> {
    Abonne findById(int id);

    List<Abonne> findByPseudo(String pseudo);

    List<Abonne> findByEmail(String email);

    List<Abonne> findByNom(String nom);

    List<Abonne> findByPrenom(String prenom);

    List<Abonne> findByPseudoContainingAndEmailContainingAndNomContainingAndPrenomContaining(String pseudo,String email,String nom,String prenom);

    List<Abonne> findByPseudoContainingAndEmailContainingAndNomContaining(String pseudo,String email,String nom);

    List<Abonne> findByPseudoContainingAndEmailContainingAndPrenomContaining(String pseudo,String email,String prenom);

    List<Abonne> findByPseudoContainingAndNomContainingAndPrenomContaining(String pseudo,String nom,String prenom);

    List<Abonne> findByEmailContainingAndNomContainingAndPrenomContaining(String email,String nom,String prenom);

    List<Abonne> findByPseudoContainingAndEmailContaining(String pseudo,String email);

    List<Abonne> findByNomContainingAndPrenomContaining(String nom, String prenom);

    List<Abonne> findByPseudoContainingAndPrenomContaining(String pseudo,String prenom);

    List<Abonne> findByEmailContainingAndNomContaining(String email,String nom);

    List<Abonne> findByEmailContainingAndPrenomContaining(String email,String prenom);

    List<Abonne> findByPseudoContainingAndNomContaining(String pseudo,String nom);

    List<Abonne> findAll();

}

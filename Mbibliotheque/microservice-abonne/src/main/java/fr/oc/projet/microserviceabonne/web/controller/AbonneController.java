package fr.oc.projet.microserviceabonne.web.controller;

import fr.oc.projet.microserviceabonne.dao.AbonneDao;
import fr.oc.projet.microserviceabonne.model.Abonne;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AbonneController {

    @Autowired
    private AbonneDao abonneDao;

    private static final Logger logger = LogManager.getLogger();

    /**
     * Méthode pour récupèrer un abonné via son id
     * @param id
     * @return
     */
    @GetMapping(value = "/Abonne/{id}")
    public Abonne getAbonne(@PathVariable int id){
        try {
        return abonneDao.findById(id);
        }catch (Exception e){
            logger.warn("Methode getAbonne() erreur : "+e);
            return null;
        }
    }

    /**
     * Méthode pour récupèrer une liste d'abonnés via un pseudo
     * @param pseudo
     * @return
     */
    @GetMapping(value = "/Abonne/Pseudo/{pseudo}")
    public Abonne getAbonnePseudo(@PathVariable String pseudo){
        try {
            return abonneDao.findByPseudo(pseudo);
        }catch (Exception e){
            logger.error("Methode getAbonnePseudo() erreur : "+e);
            return null;
        }

    }

    /**
     * Méthode pour récupèrer une liste d'abonnés via un email
     * @param email
     * @return
     */
    @GetMapping(value = "/Abonne/Email/{email}")
    public Abonne getAbonneEmail(@PathVariable String email){
        try {
            return abonneDao.findByEmail(email);
        }catch (Exception e){
            logger.error("Methode getAbonneEmail() erreur : "+e);
            return null;
        }
    }

    /**
     * Méthode pou récuprer une liste d'abonnés via un pseudo
     * @param pseudo
     * @return
     */
    @GetMapping(value = "/Abonne/ListPseudo/{pseudo}")
    public List<Abonne> getListByPseudo(@PathVariable String pseudo){
        try {
            return abonneDao.getListByPseudo(pseudo);
        }catch (Exception e){
            logger.error("Methode getListByPseudo() erreur : "+e);
            return null;
        }
    }

    /**
     * Méthode pour récupèrer une liste d'abonnés via un email
     * @param email
     * @return
     */
    @GetMapping(value = "/Abonne/ListEmail/{email}")
    List<Abonne> getListByEmail(@PathVariable String email){
        try {
            return abonneDao.getListByEmail(email);
        }catch (Exception e){
            logger.error("Methode getListByEmail() erreur : "+e);
            return null;
        }
    }

    /**
     * Méthode pour récupèrer une liste d'abonnés via un nom
     * @param nom
     * @return
     */
    @GetMapping(value = "/Abonne/Nom/{nom}")
    public List<Abonne> findByNom(@PathVariable String nom){
        try {
            return abonneDao.findByNom(nom);
        }catch (Exception e){
            logger.error("Methode getAbonneNom() erreur : "+e);
            return null;
        }
    }

    /**
     * Méthode pour récupèrer une liste d'abonnés via son prénom
     * @param prenom
     * @return
     */
    @GetMapping(value = "/Abonne/Prenom/{prenom}")
    public List<Abonne> findByPrenom(@PathVariable String prenom){
        try {
            return abonneDao.findByPrenom(prenom);
        }catch (Exception e){
            logger.error("Methode getAbonnePrenom() erreur : "+e);
            return null;
        }
    }

    /**
     * Méthode pour récupèrer une liste d'abonnés via un pseudo, email, nom et prénom
     * @param pseudo
     * @param email
     * @param nom
     * @param prenom
     * @return
     */
    @GetMapping(value = "/Abonne/PseudoEmailNomPrenom/{pseudo},{email},{nom},{prenom}")
    public List<Abonne> findByPseudoContainingAndEmailContainingAndNomContainingAndPrenomContaining(@PathVariable String pseudo,@PathVariable String email,@PathVariable String nom,@PathVariable String prenom){
        try {
            return abonneDao.findByPseudoContainingAndEmailContainingAndNomContainingAndPrenomContaining(pseudo,email,nom,prenom);
        }catch (Exception e){
            logger.error("Methode findByPseudoContainingAndEmailContainingAndNomContainingAndPrenomContaining() erreur : "+e);
            return null;
        }
    }

    /**
     * Méthode pour récupèrer une liste d'abonnés via un pseudo, email et nom
     * @param pseudo
     * @param email
     * @param nom
     * @return
     */
    @GetMapping(value = "/Abonne/PseudoEmailNom/{pseudo},{email},{nom}")
    public List<Abonne> findByPseudoContainingAndEmailContainingAndNomContaining(@PathVariable String pseudo,@PathVariable String email,@PathVariable String nom){
        try {
            return abonneDao.findByPseudoContainingAndEmailContainingAndNomContaining(pseudo,email,nom);
        }catch (Exception e){
            logger.error("Methode findByPseudoContainingAndEmailContainingAndNomContaining erreur : "+e);
            return null;
        }
    }

    /**
     * Méthode pour récupèrer une liste d'abonnés via un pseudo, email et prenom
     * @param pseudo
     * @param email
     * @param prenom
     * @return
     */
    @GetMapping(value = "/Abonne/PseudoEmailPrenom/{pseudo},{email},{prenom}")
    public List<Abonne> findByPseudoContainingAndEmailContainingAndPrenomContaining(@PathVariable String pseudo,@PathVariable String email,@PathVariable String prenom){
        try {
            return abonneDao.findByPseudoContainingAndEmailContainingAndPrenomContaining(pseudo,email,prenom);
        }catch (Exception e){
            logger.error("Methode findByPseudoContainingAndEmailContainingAndPrenomContaining() erreur : "+e);
            return null;
        }
    }

    /**
     * Méthode pour récupèrer une liste d'abonnés via un pseudo, nom et prenom
     * @param pseudo
     * @param nom
     * @param prenom
     * @return
     */
    @GetMapping(value = "/Abonne/PseudoNomPrenom/{pseudo},{nom},{prenom}")
    public List<Abonne> findByPseudoContainingAndNomContainingAndPrenomContaining(@PathVariable String pseudo,@PathVariable String nom,@PathVariable String prenom){
        try {
            return abonneDao.findByPseudoContainingAndNomContainingAndPrenomContaining(pseudo,nom,prenom);
        }catch (Exception e){
            logger.error("Methode findByPseudoContainingAndNomContainingAndPrenomContaining() erreur : "+e);
            return null;
        }
    }

    /**
     * Méthode pour récupèrer une liste d'abonné via un email, nom et prenom
     * @param email
     * @param nom
     * @param prenom
     * @return
     */
    @GetMapping(value = "/Abonne/EmailNomPrenom/{email},{nom},{prenom}")
    public List<Abonne> findByEmailContainingAndNomContainingAndPrenomContaining(@PathVariable String email,@PathVariable String nom,@PathVariable String prenom){
        try {
            return abonneDao.findByEmailContainingAndNomContainingAndPrenomContaining(email,nom,prenom);
        }catch (Exception e){
            logger.error("Methode findByEmailContainingAndNomContainingAndPrenomContaining() erreur : "+e);
            return null;
        }
    }

    /**
     * Méthode pour récupèrer une liste d'abonnés via un pseudo et email
     * @param pseudo
     * @param email
     * @return
     */
    @GetMapping(value = "/Abonne/PseudoEmail/{pseudo},{email}")
    public List<Abonne> findByPseudoContainingAndEmailContaining(@PathVariable String pseudo,@PathVariable String email){
        try {
            return abonneDao.findByPseudoContainingAndEmailContaining(pseudo,email);
        }catch (Exception e){
            logger.error("Methode findByPseudoContainingAndEmailContaining() erreur : "+e);
            return null;
        }
    }

    /**
     * Méthode pour récupèrer une liste d'abonnés via un nom et prenom
     * @param nom
     * @param prenom
     * @return
     */
    @GetMapping(value = "/Abonne/NomPrenom/{nom},{prenom}")
    public List<Abonne> findByNomContainingAndPrenomContaining(@PathVariable String nom,@PathVariable String prenom){
        try {
            return abonneDao.findByNomContainingAndPrenomContaining(nom,prenom);
        }catch (Exception e){
            logger.error("Methode findByPseudoContainingAndEmailContaining() erreur : "+e);
            return null;
        }
    }

    /**
     * Méthode pour récupèrer une liste d'abonnés via un pseudo et prenom
     * @param pseudo
     * @param prenom
     * @return
     */
    @GetMapping(value = "/Abonne/PseudoPrenom/{pseudo},{prenom}")
    public List<Abonne> findByPseudoContainingAndPrenomContaining(@PathVariable String pseudo,@PathVariable String prenom){
        try {
            return abonneDao.findByPseudoContainingAndPrenomContaining(pseudo,prenom);
        }catch (Exception e){
            logger.error("Methode findByPseudoContainingAndPrenomContaining() erreur : "+e);
            return null;
        }
    }

    /**
     * Méthode pour récupèrer une liste d'abonnés via un email et nom
     * @param email
     * @param nom
     * @return
     */
    @GetMapping(value = "/Abonne/EmailNom/{email},{nom}")
    public List<Abonne> findByEmailContainingAndNomContaining(@PathVariable String email,@PathVariable String nom){
        try {
            return abonneDao.findByEmailContainingAndNomContaining(email,nom);
        }catch (Exception e){
            logger.error("Methode findByEmailContainingAndNomContaining() erreur : "+e);
            return null;
        }
    }

    /**
     * Méthode pour récupèrer une liste d'abonnés via un email et prenom
     * @param email
     * @param prenom
     * @return
     */
    @GetMapping(value = "/Abonne/EmailPrenom/{email},{prenom}")
    public List<Abonne> findByEmailContainingAndPrenomContaining(@PathVariable String email,@PathVariable String prenom){
        try {
            return abonneDao.findByEmailContainingAndPrenomContaining(email,prenom);
        }catch (Exception e){
            logger.error("Methode findByEmailContainingAndPrenomContaining() erreur : "+e);
            return null;
        }
    }

    /**
     * Méthode pour récupèrer une liste d'abonnés via un pseudo et nom
     * @param pseudo
     * @param nom
     * @return
     */
    @GetMapping(value = "/Abonne/PseudoNom/{pseudo},{nom}")
    public List<Abonne> findByPseudoContainingAndNomContaining(@PathVariable String pseudo,@PathVariable String nom){
        try {
            return abonneDao.findByPseudoContainingAndNomContaining(pseudo,nom);
        }catch (Exception e){
            logger.error("Methode findByPseudoContainingAndNomContaining() erreur : "+e);
            return null;
        }
    }

    /**
     * Méthode pour ajouter un abonné à la base de données.
     * @param abonne
     */
    @PostMapping(value = "/Abonne")
    public void addAbonne(@RequestBody Abonne abonne) {
        try {
            abonneDao.save(abonne);
        }catch (Exception e){
            logger.error("Methode addAbonne() erreur : "+e);
        }
    }

    /**
     * Méthode pour mettre à jour un abonné.
     * @param abonne
     */
    @PutMapping(value = "/Abonne")
    public void updateAbonne(@RequestBody Abonne abonne) {
        try {
            abonneDao.save(abonne);
        }catch (Exception e){
            logger.error("Methode updateAbonne() erreur : "+e);
        }
    }

    /**
     * Méthode pour récupèrer la liste des abonnées.
     */
    @GetMapping(value = "/Abonne")
    public List<Abonne> findALL(){
        try {
           return abonneDao.findAll();
        }catch (Exception e){
            logger.error("Methode updateAbonne() erreur : "+e);
            return null;
        }
    }
}

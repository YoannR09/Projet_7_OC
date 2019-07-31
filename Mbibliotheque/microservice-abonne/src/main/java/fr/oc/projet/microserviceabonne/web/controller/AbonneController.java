package fr.oc.projet.microserviceabonne.web.controller;

import fr.oc.projet.microserviceabonne.dao.AbonneDao;
import fr.oc.projet.microserviceabonne.model.Abonne;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
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
     * Méthode pour récupèrer un abonné via son pseudo
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
     * Méthode pour récupèrer un abonné via son email
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

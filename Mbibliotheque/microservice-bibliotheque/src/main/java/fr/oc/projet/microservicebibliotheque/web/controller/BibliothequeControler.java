package fr.oc.projet.microservicebibliotheque.web.controller;

import fr.oc.projet.microservicebibliotheque.dao.BibliothequeDao;
import fr.oc.projet.microservicebibliotheque.model.Bibliotheque;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BibliothequeControler {

    private static final Logger logger = LogManager.getLogger();

    @Autowired
    private BibliothequeDao bibliothequeDao;

    /**
     * Méthode pour récupèrer une bibliothèque via id
     * @param id
     * @return
     */
    @GetMapping(value = "/Bibliotheque/{id}")
    public Bibliotheque getBibliotheque(@PathVariable int id) {
        try {
            return bibliothequeDao.findById(id);
        }catch (Exception e){
            logger.error("Methode getAdresse() erreur : "+e);
            return null;
        }
    }

    /**
     * Méthode pour récupèrer la liste de toutes les bibliothèques
     * @return
     */
    @GetMapping(value = "/Bibliotheque")
    public List<Bibliotheque> findAll(){
        try {
            return bibliothequeDao.findAll();
        }catch (Exception e){
            logger.error("Methode getAdresse() erreur : "+e);
            return null;
        }
    }
}

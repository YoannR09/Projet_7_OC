package fr.oc.projet.microservicelivreunique.web.controller;

import fr.oc.projet.microservicelivreunique.dao.LivreUniqueDao;
import fr.oc.projet.microservicelivreunique.model.LivreUnique;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LivreUniqueController {

    private static final Logger logger = LogManager.getLogger();

    @Autowired
    private LivreUniqueDao livreUniqueDao;

    /**
     * Méthode pour récupèrer un livre unique via un id
     * @param id
     * @return
     */
    @GetMapping(value = "/LivreUnique/{id}")
    public LivreUnique findById(@PathVariable int id){
        try {
            return livreUniqueDao.findById(id);
        }catch (Exception e){
            logger.error("Methode getCategorie() erreur : "+e);
            return null;
        }
    }

    /**
     * Méthode pour récupèrer un livre unique via l'id d'un livre et l'id d'une bibliothèque
     * @param livreId
     * @param bibliothequeId
     * @return
     */
    @GetMapping(value = "/CountLivreUniqueBibliotheque/{livreId},{bibliothequeId}")
    public Integer countLivreUniqueBibliotheque(@PathVariable int livreId, @PathVariable int bibliothequeId){
        try {
            return livreUniqueDao.countLivreUniqueByLivreIdAndBibliothequeIdAndDisponibleIsTrue(livreId,bibliothequeId);
        }catch (Exception e){
            logger.error("Methode getCategorie() erreur : "+e);
            return null;
        }
    }

    /**
     * Méthode pour compter le nombre de livre unique disponible via l'id d'un livre
     * @param livreId
     * @return
     */
    @GetMapping(value = "/CountLivreUnique/{livreId}")
    public Integer countLivreUnique(@PathVariable int livreId){
        try {
            return livreUniqueDao.countLivreUniqueByLivreIdAndDisponibleIsTrue(livreId);
        }catch (Exception e){
            logger.error("Methode getCategorie() erreur : "+e);
            return null;
        }
    }
}

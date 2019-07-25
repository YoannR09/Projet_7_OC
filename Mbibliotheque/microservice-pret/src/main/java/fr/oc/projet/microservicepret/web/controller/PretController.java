package fr.oc.projet.microservicepret.web.controller;

import fr.oc.projet.microservicepret.dao.PretDao;
import fr.oc.projet.microservicepret.model.Pret;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PretController {

    private static final Logger logger = LogManager.getLogger();

    @Autowired
    private PretDao pretDao;

    /**
     * Récupère un prêt via un id
     * @param id
     * @return
     */
    @GetMapping(value = "/Pret/{id}")
    public Pret getPret(@PathVariable int id){
        try {
            return pretDao.findById(id);
        }catch (Exception e){
            logger.error("Methode getCategorie() erreur : "+e);
            return null;
        }
    }

    /**
     * Récupère une liste de prêts via l'id d'un abonné
     * @param abonneId
     * @return
     */
    @GetMapping(value = "/Pret/Abonne/{abonneId}")
    public List<Pret> getListPretAbonne(@PathVariable int abonneId){
        try {
            return pretDao.findPretByAbonneId(abonneId);
        }catch (Exception e){
            logger.error("Methode getCategorie() erreur : "+e);
            return null;
        }
    }

    /**
     * Met à jour un prêt
     * Méthode utilisé pour la prolongation d'un prêt
     * @param pret
     */
    @PutMapping(value = "/Pret")
    public void updatePret(@RequestBody Pret pret) {
        try {
            pretDao.save(pret);
        }catch (Exception e){
            logger.error("Methode getCategorie() erreur : "+e);
        }
    }
}

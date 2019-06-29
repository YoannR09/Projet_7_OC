package fr.oc.projet.microservicelivreunique.web.controller;

import fr.oc.projet.microservicelivreunique.dao.LivreUniqueDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LivreUniqueController {

    @Autowired
    private LivreUniqueDao livreUniqueDao;

    @GetMapping(value = "/CountLivreUniqueBibliotheque/{livreId},{bibliothequeId}")
    public Integer countLivreUniqueBibliotheque(@PathVariable int livreId, @PathVariable int bibliothequeId){
       return livreUniqueDao.countLivreUniqueByLivreIdAndBibliothequeIdAndDisponibleIsTrue(livreId,bibliothequeId);
    }

    @GetMapping(value = "/CountLivreUnique/{livreId}")
    public Integer countLivreUnique(@PathVariable int livreId){
        return livreUniqueDao.countLivreUniqueByLivreIdAndDisponibleIsTrue(livreId);
    }
}

package fr.oc.projet.microservicelivre.web.controller;

import fr.oc.projet.microservicelivre.dao.LivreDao;
import fr.oc.projet.microservicelivre.model.Livre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LivreController {

    @Autowired
    private LivreDao livreDao;

    @GetMapping(value = "/Livre/{id}")
    public Livre getLivre(@PathVariable int id){
        return livreDao.findById(id);
    }


    @GetMapping(value = "/Livre/TitreAuteurISBN/{titre},{auteur},{isbn}")
    public List<Livre> findLivresByTitreAndAuteurAndIsbn(@PathVariable String titre,@PathVariable String auteur,@PathVariable String isbn ){
        return livreDao.findLivresByTitreContainingAndAuteurContainingAndIsbnContaining(titre,auteur,isbn);
    }

    @GetMapping(value = "/Livre/AuteurISBN/{auteur},{isbn}")
    public List<Livre> findLivresByAuteurContainingAndIsbnContaining(@PathVariable String auteur, @PathVariable String isbn){
        return livreDao.findLivresByAuteurContainingAndIsbnContaining(auteur,isbn);
    }

    @GetMapping(value = "/Livre/TitreISBN/{titre},{isbn}")
    public List<Livre> findLivresByTitreContainingAndIsbnContaining(@PathVariable String titre,@PathVariable String isbn ){
        return livreDao.findLivresByTitreContainingAndIsbnContaining(titre,isbn);
    }

    @GetMapping(value = "/Livre/TitreAuteurISBN/{titre},{auteur}")
    public List<Livre> findLivresByTitreContainingAndAuteurContaining(@PathVariable String titre,@PathVariable String auteur){
        return livreDao.findLivresByTitreContainingAndAuteurContaining(titre,auteur);
    }


    @GetMapping(value = "/Livre/Titre/{titre}")
    public List<Livre> findLivresByTitreContaining(@PathVariable String titre){
        return livreDao.findLivresByTitreContaining(titre);
    }

    @GetMapping(value = "/Livre/Auteur/{auteur}")
    public List<Livre> findLivresByAuteurContaining(@PathVariable String auteur){
        return livreDao.findLivresByAuteurContaining(auteur);
    }

    @GetMapping(value = "/Livre/ISBN/{isbn}")
    public List<Livre> findLivresByIsbnContaining(@PathVariable String isbn){
        return livreDao.findLivresByIsbnContaining(isbn);
    }
}

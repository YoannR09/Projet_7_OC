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

    @GetMapping(value = "/Livre/Categorie/{categorieId}")
    public List<Livre> findLivreByCategorieId(@PathVariable int categorieId){
        return livreDao.findLivreByCategorieId(categorieId);
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

    @GetMapping(value = "/Livre/TitreAuteurISBNCategorie/{titre},{auteur},{isbn},{categorieId}")
    public List<Livre> findLivresByTitreAndAuteurAndIsbnAndCategorieId(@PathVariable String titre,@PathVariable String auteur,@PathVariable String isbn,@PathVariable int categorieId){
        return livreDao.findLivresByTitreContainingAndAuteurContainingAndIsbnContainingAndCategorieId(titre,auteur,isbn,categorieId);
    }

    @GetMapping(value = "/Livre/AuteurISBNCategorie/{auteur},{isbn},{categorieId}")
    public List<Livre> findLivresByAuteurContainingAndIsbnContainingAndCategorieId(@PathVariable String auteur, @PathVariable String isbn,@PathVariable int categorieId){
        return livreDao.findLivresByAuteurContainingAndIsbnContainingAndCategorieId(auteur,isbn,categorieId);
    }

    @GetMapping(value = "/Livre/TitreISBNCategorie/{titre},{isbn},{categorieId}")
    public List<Livre> findLivresByTitreContainingAndIsbnContainingAndCategorieId(@PathVariable String titre,@PathVariable String isbn,@PathVariable int categorieId ){
        return livreDao.findLivresByTitreContainingAndIsbnContainingAndCategorieId(titre,isbn,categorieId);
    }

    @GetMapping(value = "/Livre/TitreAuteurISBNCategorie/{titre},{auteur},{categorieId}")
    public List<Livre> findLivresByTitreContainingAndAuteurContainingAndCategorieId(@PathVariable String titre,@PathVariable String auteur,@PathVariable int categorieId){
        return livreDao.findLivresByTitreContainingAndAuteurContainingAndCategorieId(titre,auteur,categorieId);
    }


    @GetMapping(value = "/Livre/TitreCategorie/{titre},{categorieId}")
    public List<Livre> findLivresByTitreContainingAndCategorieId(@PathVariable String titre,@PathVariable int categorieId){
        return livreDao.findLivresByTitreContainingAndCategorieId(titre,categorieId);
    }

    @GetMapping(value = "/Livre/AuteurCategorie/{auteur},{categorieId}")
    public List<Livre> findLivresByAuteurContainingAndCategorieId(@PathVariable String auteur,@PathVariable int categorieId){
        return livreDao.findLivresByAuteurContainingAndCategorieId(auteur,categorieId);
    }

    @GetMapping(value = "/Livre/ISBNCategorie/{isbn},{categorieId}")
    public List<Livre> findLivresByIsbnContainingAndCategorieId(@PathVariable String isbn,@PathVariable int categorieId){
        return livreDao.findLivresByIsbnContainingAndCategorieId(isbn,categorieId);
    }
}

package fr.oc.projet.microservicecategorie.web.controller;

import fr.oc.projet.microservicecategorie.dao.CategorieDao;
import fr.oc.projet.microservicecategorie.model.Categorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategorieController {

    @Autowired
    private CategorieDao categorieDao;

    @GetMapping(value = "/Categorie/{id}")
    public Categorie getCategorie(@PathVariable int id){
        return categorieDao.findById(id);
    }
}

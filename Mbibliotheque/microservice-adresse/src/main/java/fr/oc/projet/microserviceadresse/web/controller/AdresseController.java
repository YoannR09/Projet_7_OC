package fr.oc.projet.microserviceadresse.web.controller;

import fr.oc.projet.microserviceadresse.dao.AdresseDao;
import fr.oc.projet.microserviceadresse.model.Adresse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdresseController {

    @Autowired
    private AdresseDao adresseDao;

    @GetMapping(value = "/Adresse/{id}")
    public Adresse getAdresse(@PathVariable int id){
        return adresseDao.findById(id);
    }
}

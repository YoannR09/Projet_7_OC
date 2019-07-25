package fr.oc.projet.microserviceadresse.web.controller;

import fr.oc.projet.microserviceadresse.dao.AdresseDao;
import fr.oc.projet.microserviceadresse.model.Adresse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
public class AdresseController {

    private static final Logger logger = LogManager.getLogger();

    @Autowired
    private AdresseDao adresseDao;

    /**
     * Méthode pour récupèrer une adresse via un id
     * @param id
     * @return
     */
    @GetMapping(value = "/Adresse/{id}")
    public Adresse getAdresse(@PathVariable int id){
        try {
            return adresseDao.findById(id);
        }catch (Exception e){
            logger.error("Methode getAdresse() erreur : "+e);
            return null;
        }
    }

    /**
     * Méthode pour récupèrer une adresse via tout les critères
     * @param codePostal
     * @param numero
     * @param rue
     * @param pays
     * @param ville
     * @return
     */
    @GetMapping(value = "/Adresse/All/{codePostal},{numero},{rue},{pays},{ville}")
    public Adresse getAdresseAll(@PathVariable String codePostal,@PathVariable String numero,@PathVariable String rue,@PathVariable String pays,@PathVariable String ville){
        try {
            return adresseDao.findByCodePostalAndNumeroAndRueAndPaysAndVille(codePostal,numero,rue,pays,ville);
        }catch (Exception e){
            logger.error("Methode getAdresseAll() erreur : "+e);
            return null;
        }
    }

    /**
     * Méthode pour ajouter une adresse à la base de données.
     * @param adresse
     */
    @PostMapping(value = "/Adresse")
    public void addAdresse(@RequestBody Adresse adresse) {
        try {
            adresseDao.save(adresse);
        }catch (Exception e){
            logger.error("Methode addAdresse() erreur : "+e);
        }

    }

    /**
     * Méthode pour mettre à jour une adresse
     * @param adresse
     */
    @PutMapping(value = "/Adresse")
    public void updateAdresse(@RequestBody Adresse adresse){
        try {
            adresseDao.save(adresse);
        }catch (Exception e){
            logger.error("Methode updateAdresse() erreur : "+e);
        }
    }
}

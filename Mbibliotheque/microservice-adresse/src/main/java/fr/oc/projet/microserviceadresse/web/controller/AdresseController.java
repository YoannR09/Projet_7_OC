package fr.oc.projet.microserviceadresse.web.controller;

import fr.oc.projet.microserviceadresse.dao.AdresseDao;
import fr.oc.projet.microserviceadresse.model.Adresse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
public class AdresseController {

    @Autowired
    private AdresseDao adresseDao;

    @GetMapping(value = "/Adresse/{id}")
    public Adresse getAdresse(@PathVariable int id){
        return adresseDao.findById(id);
    }

    @GetMapping(value = "/Adresse/All/{codePostal},{numero},{rue},{pays},{ville}")
    public Adresse getAdresseAll(@PathVariable String codePostal,@PathVariable String numero,@PathVariable String rue,@PathVariable String pays,@PathVariable String ville){
        return adresseDao.findByCodePostalAndNumeroAndRueAndPaysAndVille(codePostal,numero,rue,pays,ville);
    }

    @PostMapping(value = "/Adresse")
    public void addAdresse(@RequestBody Adresse adresse) {
      adresseDao.save(adresse);
    }

    @PutMapping(value = "/Adresse")
    public void updateAdresse(@RequestBody Adresse adresse){
        adresseDao.save(adresse);
    }



}

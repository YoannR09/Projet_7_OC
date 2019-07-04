package fr.oc.projet.microservicebibliotheque.web.controller;

import fr.oc.projet.microservicebibliotheque.dao.BibliothequeDao;
import fr.oc.projet.microservicebibliotheque.model.Bibliotheque;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BibliothequeControler {

    @Autowired
    private BibliothequeDao bibliothequeDao;

    @GetMapping(value = "/Bibliotheque/{id}")
    public Bibliotheque getBibliotheque(@PathVariable int id){
        return bibliothequeDao.findById(id);
    }

    @GetMapping(value = "/Bibliotheque")
    public List<Bibliotheque> findAll(){
        return bibliothequeDao.findAll();
    }
}

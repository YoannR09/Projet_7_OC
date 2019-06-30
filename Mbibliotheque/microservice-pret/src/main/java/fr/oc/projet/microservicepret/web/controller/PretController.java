package fr.oc.projet.microservicepret.web.controller;

import fr.oc.projet.microservicepret.dao.PretDao;
import fr.oc.projet.microservicepret.model.Pret;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PretController {

    @Autowired
    private PretDao pretDao;

    @GetMapping(value = "/Pret/Abonne/{abonneId}")
    public List<Pret> getListPretAbonne(@PathVariable int abonneId){
        return pretDao.findPretByAbonneId(abonneId);
    }
}

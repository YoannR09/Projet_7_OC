package fr.oc.projet.microserviceabonne.web.controller;

import fr.oc.projet.microserviceabonne.dao.AbonneDao;
import fr.oc.projet.microserviceabonne.model.Abonne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AbonneController {

    @Autowired
    private AbonneDao abonneDao;

    @GetMapping(value = "/Abonne/{id}")
    public Abonne getAbonne(@PathVariable int id){
        return abonneDao.findById(id);
    }

    @GetMapping(value = "/Abonne/Pseudo/{pseudo}")
    public Abonne getAbonnePseudo(@PathVariable String pseudo){
        return abonneDao.findByPseudo(pseudo);
    }

    @GetMapping(value = "/Abonne/Email/{email}")
    public Abonne getAbonneEmail(@PathVariable String email){
        return abonneDao.findByEmail(email);
    }


}

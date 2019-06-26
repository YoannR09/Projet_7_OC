package fr.oc.projet.microserviceillustration.web.controller;

import fr.oc.projet.microserviceillustration.dao.IllustrationDao;
import fr.oc.projet.microserviceillustration.model.Illustration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IllustrationController {

    @Autowired
    private IllustrationDao illustrationDao;

    @GetMapping(value = "/Illustration/{id}")
    public Illustration getIllustration(@PathVariable int id){
        return illustrationDao.findById(id);
    }
}

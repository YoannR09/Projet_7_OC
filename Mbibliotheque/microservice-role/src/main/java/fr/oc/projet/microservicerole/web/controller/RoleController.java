package fr.oc.projet.microservicerole.web.controller;

import fr.oc.projet.microservicerole.dao.RoleDao;
import fr.oc.projet.microservicerole.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleController {

    @Autowired
    private RoleDao roleDao;

    @GetMapping(value = "/Role/{id}")
    public Role getRole(@PathVariable int id){
        return roleDao.findById(id);
    }
}

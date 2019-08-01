package fr.oc.projet.microserviceemploye.controler;

import fr.oc.projet.microserviceemploye.dao.EmployeDao;
import fr.oc.projet.microserviceemploye.model.Employe;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class EmployeControler {

    @Autowired
    private EmployeDao employeDao;

    private static final Logger logger = LogManager.getLogger();

    /**
     * Méthode pour récupèrer un employé via un id
     * @param id
     * @return
     */
    @GetMapping(value = "/Employe/{id}")
    public Employe findById(@PathVariable int id){
        try{
            return employeDao.findById(id);
        }catch (Exception e){
            logger.error(e);
            return null;
        }
    }

    /**
     * Méthode pour récupèrer un employé via une adresse électronnique
     * @param email
     * @return
     */
    @GetMapping(value = "/Employe/{email}")
    public Employe findByEmail(@PathVariable String email){
        try{
            return employeDao.findByEmail(email);
        }catch (Exception e){
            logger.error(e);
            return null;
        }
    }
}


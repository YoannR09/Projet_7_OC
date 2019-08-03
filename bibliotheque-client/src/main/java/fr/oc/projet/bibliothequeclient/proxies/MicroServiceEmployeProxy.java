package fr.oc.projet.bibliothequeclient.proxies;

import fr.oc.projet.bibliothequeclient.beans.Employe;
import fr.oc.projet.bibliothequeclient.beans.LivreUnique;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * Classe pour récupèrer les données du MicroServiceEmploye
 */
@FeignClient(value = "microservice-employe", url = "localhost:9087")
public interface MicroServiceEmployeProxy {

    /**
     * Méthode pour récupèrer un employé via un id
     * @param id
     * @return
     */
    @GetMapping(value = "/Employe/Id/{id}")
    Employe findById(@PathVariable int id);

    /**
     * Méthode pour récupèrer un employé via une adresse électronnique
     * @param email
     * @return
     */
    @GetMapping(value = "/Employe/Email/{email}")
    Employe findByEmail(@PathVariable("email") String email);
}

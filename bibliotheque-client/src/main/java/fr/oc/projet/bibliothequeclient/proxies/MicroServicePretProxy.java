package fr.oc.projet.bibliothequeclient.proxies;

import fr.oc.projet.bibliothequeclient.beans.Pret;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


/**
 * Classe pour récupèrer les données du MicroServicePret
 */
@FeignClient(value = "microservice-pret",url = "localhost:9099")
public interface MicroServicePretProxy {

    @GetMapping(value = "/Pret/{id}")
    Pret getPret(@PathVariable int id);


    @GetMapping(value = "/Pret/Abonne/{abonneId}")
    List<Pret> getListPretAbonne(@PathVariable("abonneId") int abonneId);

    @PutMapping(value = "/Pret")
    void updatePret(@RequestBody Pret pret);

}

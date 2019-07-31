package fr.oc.projet.bibliothequeclient.proxies;

import fr.oc.projet.bibliothequeclient.beans.Bibliotheque;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


/**
 * Classe pour récupèrer les données du MicroServiceBibliotheque
 */
@FeignClient(value = "microservice-bibliotheque", url = "localhost:9096")
public interface MicroServiceBibliothequeProxy {

    @GetMapping(value = "/Bibliotheque/{id}")
    Bibliotheque getBibliotheque(@PathVariable("id") int id);

    @GetMapping(value = "/Bibliotheque")
    List<Bibliotheque> findAll();


}

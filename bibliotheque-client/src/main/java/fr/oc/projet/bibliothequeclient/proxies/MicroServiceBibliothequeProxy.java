package fr.oc.projet.bibliothequeclient.proxies;

import fr.oc.projet.bibliothequeclient.beans.Bibliotheque;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "microservice-bibliotheque", url = "localhost:9096")
public interface MicroServiceBibliothequeProxy {

    @GetMapping(value = "/Bibliotheque/{id}")
    Bibliotheque getBibliotheque(@PathVariable("id") int id);

}

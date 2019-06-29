package fr.oc.projet.bibliothequeclient.proxies;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "microservice-livre-unique", url = "localhost:9098")
public interface MicroServiceLivreUniqueProxy {

    @GetMapping(value = "/CountLivreUniqueBibliotheque/{livreId},{bibliothequeId}")
    Integer countLivreUniqueBibliothequeDisponible(@PathVariable("livreId") int livreId, @PathVariable("bibliothequeId") int bibliothequeId);


    @GetMapping(value = "/CountLivreUnique/{livreId}")
    Integer countLivreUniqueDisponible(@PathVariable("livreId") int livreId);
}

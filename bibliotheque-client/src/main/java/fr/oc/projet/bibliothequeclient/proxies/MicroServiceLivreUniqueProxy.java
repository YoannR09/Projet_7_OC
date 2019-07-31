package fr.oc.projet.bibliothequeclient.proxies;

import fr.oc.projet.bibliothequeclient.beans.LivreUnique;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


/**
 * Classe pour récupèrer les données du MicroServiceLivreUnique
 */
@FeignClient(name = "microservice-livre-unique", url = "localhost:9098")
public interface MicroServiceLivreUniqueProxy {

    @GetMapping(value = "/LivreUnique/{id}")
    LivreUnique findById(@PathVariable int id);

    @GetMapping(value = "/CountLivreUniqueBibliotheque/{livreId},{bibliothequeId}")
    Integer countLivreUniqueBibliothequeDisponible(@PathVariable("livreId") int livreId, @PathVariable("bibliothequeId") int bibliothequeId);


    @GetMapping(value = "/CountLivreUnique/{livreId}")
    Integer countLivreUniqueDisponible(@PathVariable("livreId") int livreId);
}

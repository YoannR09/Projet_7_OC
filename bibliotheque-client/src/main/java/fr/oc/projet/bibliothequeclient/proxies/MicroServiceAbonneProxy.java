package fr.oc.projet.bibliothequeclient.proxies;

import fr.oc.projet.bibliothequeclient.beans.Abonne;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "microservice-abonne", url = "localhost:9097")
public interface MicroServiceAbonneProxy {

    @GetMapping(value = "/Abonne/{id}")
    Abonne getAbonne(@PathVariable("id") int id);

    @GetMapping(value = "/Abonne/Pseudo/{pseudo}")
    Abonne getAbonnePseudo(@PathVariable("pseudo") String pseudo);


    @GetMapping(value = "/Abonne/Email/{email}")
    Abonne getAbonneEmail(@PathVariable("email") String email);
}

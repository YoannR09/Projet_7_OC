package fr.oc.projet.bibliothequeclient.proxies;

import fr.oc.projet.bibliothequeclient.beans.Adresse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "microservice-adresse", url = "localhost:9095")
public interface MicroServiceAdresseProxy {

    @GetMapping(value = "/Adresse/{id}")
    Adresse getAdresse(@PathVariable int id);

    @PostMapping(value = "/Adresse")
    void addAdresse(@RequestBody Adresse adresse);

    @PutMapping(value = "/Adresse")
    void updateAdresse(@RequestBody Adresse adresse);

    @GetMapping(value = "/Adresse/All/{codePostal},{numero},{rue},{pays},{ville}")
    Adresse getAdresseAll(@PathVariable("codePostal") String codePostal,@PathVariable("numero") String numero,@PathVariable("rue") String rue,@PathVariable("pays") String pays,@PathVariable("ville") String ville);

}

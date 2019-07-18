package fr.oc.projet.bibliothequeclient.proxies;

import fr.oc.projet.bibliothequeclient.beans.Categorie;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value = "microservice-categorie", url = "localhost:9090")
public interface MicroServiceCategorieProxy {

    @GetMapping(value = "/Categorie/{id}")
    Categorie getCategorie(@PathVariable("id") int id);

    @GetMapping(value = "/Categorie/Nom/{nom}")
    Categorie findByNom(@PathVariable("nom") String nom);

    @GetMapping(value = "/Categorie")
    List<Categorie> getListCategorie();
}

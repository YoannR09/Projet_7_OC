package fr.oc.projet.bibliothequeclient.proxies;

import fr.oc.projet.bibliothequeclient.beans.Pret;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value = "microservice-pret",url = "localhost:9099")
public interface MicroServicePretProxy {

    @GetMapping(value = "/Pret/Abonne/{abonneId}")
    List<Pret> getListPretAbonne(@PathVariable("abonneId") int abonneId);
}

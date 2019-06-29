package fr.oc.projet.bibliothequeclient.proxies;

import fr.oc.projet.bibliothequeclient.beans.Illustration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "microservice-illustration", url = "localhost:9093")
public interface MicroServiceIllustrationProxy {

    @GetMapping(value = "/Illustration/{id}")
    Illustration getIllustration(@PathVariable("id") int id);
}

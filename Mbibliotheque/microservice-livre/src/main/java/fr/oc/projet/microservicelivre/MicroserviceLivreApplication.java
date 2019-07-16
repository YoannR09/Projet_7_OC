package fr.oc.projet.microservicelivre;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MicroserviceLivreApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceLivreApplication.class, args);
	}

}

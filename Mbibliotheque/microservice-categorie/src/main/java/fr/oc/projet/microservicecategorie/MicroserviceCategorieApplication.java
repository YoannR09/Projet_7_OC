package fr.oc.projet.microservicecategorie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableDiscoveryClient
public class MicroserviceCategorieApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceCategorieApplication.class, args);
	}

}

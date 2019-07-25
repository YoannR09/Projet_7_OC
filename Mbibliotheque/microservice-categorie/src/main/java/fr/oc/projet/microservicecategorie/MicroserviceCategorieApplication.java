package fr.oc.projet.microservicecategorie;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableDiscoveryClient
public class MicroserviceCategorieApplication {

	private static final Logger logger = LogManager.getLogger();

	public static void main(String[] args) {

		logger.info("test");

		logger.error("test");

		SpringApplication.run(MicroserviceCategorieApplication.class, args);
	}

}

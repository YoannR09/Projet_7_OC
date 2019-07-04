package fr.oc.projet.batch;

import fr.oc.projet.business.contract.ManagerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BibliothequeServeurBatchApplication {

	public static void main(String[] args) {

		SpringApplication.run(BibliothequeServeurBatchApplication.class, args);
	}
}

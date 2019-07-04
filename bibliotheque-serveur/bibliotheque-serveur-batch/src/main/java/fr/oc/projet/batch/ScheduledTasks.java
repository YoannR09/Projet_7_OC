package fr.oc.projet.batch;

import fr.oc.projet.business.contract.ManagerFactory;
import fr.oc.projet.model.beans.bibliotheque.LivreUnique;
import fr.oc.projet.model.beans.utilisateur.Abonne;
import fr.oc.projet.model.beans.utilisateur.Pret;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Named
public class ScheduledTasks {


    @Scheduled(fixedRate = 86400000)
    public void run() {

        ApplicationContext vApplicationContext
                = new ClassPathXmlApplicationContext("classpath:/bootstrapContext.xml");

        ManagerFactory managerFactory = vApplicationContext.getBean("managerFactoryImpl", ManagerFactory.class);


        List<Abonne> vList = managerFactory.getAbonneManager().getListAbonne();
        for(Abonne abonne:vList){
            List<Pret> listPret = managerFactory.getPretManager().getListPretAbonne(abonne.getId());
            List<LivreUnique> listLivreUnique = new ArrayList<>();
            for(Pret pret:listPret){
                if(pret.getDateRestitution().compareTo(new Date()) > 0){
                    listLivreUnique.add(pret.getLivreUnique());
                }
            }
            if(listLivreUnique.size() != 0){
                List<String> listLivreNonRestitue = new ArrayList<>();
                for (LivreUnique livreUnique:listLivreUnique){
                    listLivreNonRestitue.add("Titre du livre : "+livreUnique.getLivre().getTitre() + " dans la bibliothèque : "+livreUnique.getBibliotheque().getNom()+ ". \n");
                }
                String objet = "Emprunt de livre à notre bibliothèque";
                String contenu = "Madame, Monsieur, suite à l'emprunt de livre que vous avez effectué chez nous, nous vous serions reconnaissant de nous retourner les produits concernés dans les plus brefs délais. \n \n " +
                        " Date d'emprunt dépassé sur les produits suivant : \n"
                        + listLivreNonRestitue+
                        " \n Merci de votre compréhension. Cordialement, l'équipe de la Bibliothèque";

            }
        }
    }
}

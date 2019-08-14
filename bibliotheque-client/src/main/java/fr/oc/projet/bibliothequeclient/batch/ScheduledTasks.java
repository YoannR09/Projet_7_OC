package fr.oc.projet.bibliothequeclient.batch;

import fr.oc.projet.bibliothequeclient.beans.*;
import fr.oc.projet.bibliothequeclient.proxies.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimerTask;


/**
 * Classe qui est lancé en répétition.
 * Consulte les abonnés qui n'ont pas rendu leurs livre.
 */
@EnableBatchProcessing
public class ScheduledTasks extends TimerTask {

    final Logger logger = LogManager.getLogger();

    @Autowired
    MicroServiceAbonneProxy microServiceAbonneProxy;
    @Autowired
    MicroServicePretProxy microServicePretProxy;
    @Autowired
    MicroServiceLivreProxy microServiceLivreProxy;
    @Autowired
    MicroServiceBibliothequeProxy microServiceBibliothequeProxy;
    @Autowired
    MicroServiceLivreUniqueProxy microServiceLivreUniqueProxy;

    /**
     * Méthode pour rechercher les abonnées qui n'ont pas rendu leurs livre
     * On consulte la liste d'abonné piur en faire une boucle
     * On récupère la liste des prêts actif pour les abonnés pour en faire une boucle
     * On récupère une liste de livre unique non rendu à la bonne date
     * pour les ajouter au contenu du mail.
     */
    @Override
    public void run() {

        List<Abonne> vList = microServiceAbonneProxy.findALL();
        for(Abonne abonne:vList){
            List<Pret> listPret = microServicePretProxy.findAll();
            List<LivreUnique> listLivreUnique = new ArrayList<>();
            for(Pret pret:listPret){
                pret.setLivreUnique(microServiceLivreUniqueProxy.findById(pret.getLivreUniqueId()));
                if(pret.getDateRestitution().compareTo(new Date()) < 0){
                    listLivreUnique.add(pret.getLivreUnique());
                }
            }
            if(listLivreUnique.size() != 0){
                List<String> listLivreNonRestitue = new ArrayList<>();
                for (LivreUnique livreUnique:listLivreUnique){
                    Livre livre = microServiceLivreProxy.getLivre(livreUnique.getLivreId());
                    Bibliotheque bibliotheque = microServiceBibliothequeProxy.getBibliotheque(livreUnique.getBibliothequeId());
                    listLivreNonRestitue.add("Titre du livre : "+livre.getTitre() + ", ISBN-13 : "+livre.getIsbn()+" , dans la bibliothèque : "+bibliotheque.getNom()+ ". \n");
                }
                String objet = "Prêt de livre dans notre bibliothèque";
                String contenu = "Madame, Monsieur, suite à l'emprunt de livre que vous avez effectué chez nous, nous vous serions reconnaissant de nous retourner les produits concernés dans les plus brefs délais. \n \n " +
                        " Date d'emprunt dépassé sur les livres suivant : \n"
                        + listLivreNonRestitue+
                        " \n Merci de votre compréhension. Cordialement, l'équipe de la Bibliothèque";

                EnvoyerMail envoyerMail = new EnvoyerMail();
                try {
                    envoyerMail.sendMessage(objet,contenu,abonne,logger);
                } catch (Exception e) {
                    logger.error(e);
                    e.printStackTrace();
                }
            }
        }
    }
}
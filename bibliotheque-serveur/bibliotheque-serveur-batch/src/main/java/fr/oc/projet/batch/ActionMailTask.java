package fr.oc.projet.batch;

import fr.oc.projet.business.contract.ManagerFactory;
import fr.oc.projet.model.beans.bibliotheque.LivreUnique;
import fr.oc.projet.model.beans.utilisateur.Abonne;
import fr.oc.projet.model.beans.utilisateur.Pret;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimerTask;

public class ActionMailTask extends TimerTask {

    @Inject
    ManagerFactory managerFactory;

    @Inject
    EnvoyerMail envoyerMail;


    @Override
    public void run() {

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
                envoyerMail.sendMessage(objet,contenu,abonne);
            }
        }
    }
}


package fr.oc.projet.webapp.action;

import com.opensymphony.xwork2.ActionSupport;
import fr.oc.projet.business.contract.ManagerFactory;
import fr.oc.projet.model.beans.bibliotheque.LivreUnique;
import fr.oc.projet.model.beans.utilisateur.Pret;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;
import java.util.List;

/**
 * Classe qui gère la restitution d'un prêt en cours
 */
public class RestituerAction extends ActionSupport {

    private         Pret        pret;
    private         int         pretId;
    private         int         bibliothequeId;
    private         int         livreUniqueId;
    private         List<Pret>  pretList;
    private         String      bibliotheque;
    private         String      numeroInterne;
    private         String      isbn;

    private static final Logger logger = LogManager.getLogger();

    @Inject
    ManagerFactory managerFactory;

    /**
     * Méthode pour rechercher des prêt en cours
     * en fonction du texte entré dans le formulaire.
     * @return
     */
    public String doRechercheRestituerPret(){
        if(!bibliotheque.equals("Toutes les bibliothèques")) {
            bibliothequeId = managerFactory.getBibliothequeManager().getBibliothequeNom(bibliotheque).getId();
            if (!isbn.equals("") && !numeroInterne.equals("")){
                pretList = managerFactory.getPretManager().getListPretLivreISBNNumInterneBibliotheque(isbn,numeroInterne,bibliothequeId);
            }else if (!isbn.equals("") && numeroInterne.equals("")){
                pretList = managerFactory.getPretManager().getListPretLivreISBNBibliotheque(isbn,bibliothequeId);
            }else if(isbn.equals("") && !numeroInterne.equals("")){
                pretList = managerFactory.getPretManager().getListPretLivreNumInterneBibliotheque(numeroInterne,bibliothequeId);
            }
        }else {
            if (!isbn.equals("") && !numeroInterne.equals("")){
                pretList = managerFactory.getPretManager().getListPretLivreISBNNumInterne(isbn,numeroInterne);
            }else if (!isbn.equals("") && numeroInterne.equals("")){
                pretList = managerFactory.getPretManager().getListPretLivreISBN(isbn);
            }else if(isbn.equals("") && !numeroInterne.equals("")){
                pretList = managerFactory.getPretManager().getListPretLivreNumInterne(numeroInterne);
            }
        }
        return ActionSupport.SUCCESS;
    }

    /**
     * Méthode qui gère la réstition d'un prêt en cours.
     * @return
     */
    public String doRestitutionPret(){

        pret = managerFactory.getPretManager().getPret(pretId);
        LivreUnique livreUnique = pret.getLivreUnique();
        livreUnique.setDisponible(true);
        managerFactory.getLivreUniqueManager().updateDispo(livreUnique);
        managerFactory.getPretManager().deletePret(pretId);

        this.addActionMessage("Livre restitué, ce livre est maintenant disponible pour un nouveau prêt.");
        logger.info("Livre restitué à l'inventaire");

        return ActionSupport.SUCCESS;
    }


    public Pret getPret() {
        return pret;
    }

    public void setPret(Pret pret) {
        this.pret = pret;
    }

    public int getPretId() {
        return pretId;
    }

    public void setPretId(int pretId) {
        this.pretId = pretId;
    }

    public int getBibliothequeId() {
        return bibliothequeId;
    }

    public void setBibliothequeId(int bibliothequeId) {
        this.bibliothequeId = bibliothequeId;
    }

    public List<Pret> getPretList() {
        return pretList;
    }

    public void setPretList(List<Pret> pretList) {
        this.pretList = pretList;
    }

    public String getBibliotheque() {
        return bibliotheque;
    }

    public void setBibliotheque(String bibliotheque) {
        this.bibliotheque = bibliotheque;
    }

    public String getNumeroInterne() {
        return numeroInterne;
    }

    public void setNumeroInterne(String numeroInterne) {
        this.numeroInterne = numeroInterne;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getLivreUniqueId() {
        return livreUniqueId;
    }

    public void setLivreUniqueId(int livreUniqueId) {
        this.livreUniqueId = livreUniqueId;
    }


}

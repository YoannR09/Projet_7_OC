package fr.oc.projet.webapp.action;

import com.opensymphony.xwork2.ActionSupport;
import fr.oc.projet.business.contract.ManagerFactory;
import fr.oc.projet.model.beans.utilisateur.Pret;

import javax.inject.Inject;
import java.util.List;

public class RestituerAction extends ActionSupport {

    @Inject
    ManagerFactory managerFactory;

    private         Pret        pret;
    private         int         pretId;
    private         int         bibliothequeId;
    private         int         livreUniqueId;
    private         List<Pret>  pretList;
    private         String      bibliotheque;
    private         String      numeroInterne;
    private         String      isbn;



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

    public String doRestitutionPret(){

        managerFactory.getPretManager().deletePret(pretId);

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

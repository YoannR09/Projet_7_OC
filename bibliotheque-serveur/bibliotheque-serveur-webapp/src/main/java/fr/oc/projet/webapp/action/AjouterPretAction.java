package fr.oc.projet.webapp.action;

import com.opensymphony.xwork2.ActionSupport;
import fr.oc.projet.business.contract.ManagerFactory;
import fr.oc.projet.model.beans.bibliotheque.Livre;
import fr.oc.projet.model.beans.bibliotheque.LivreUnique;

import javax.inject.Inject;
import java.util.List;

public class AjouterPretAction extends ActionSupport {

    private String isbn;
    private String auteur;
    private String titre;
    private String bibliotheque;
    private Integer bibliothequeId;
    private Integer livreId;
    private Livre livre;
    private List<LivreUnique> livreUniqueList;

    @Inject
    ManagerFactory managerFactory;


    public String doListLivre() {
            if (bibliotheque.equals("Toutes les bibliothèques")) {
                if (!isbn.equals("") && !auteur.equals("") && !titre.equals("")) {  // Recherche via isbn titre et auteur
                    livreUniqueList = managerFactory.getLivreUniqueManager().getListLivreUniqueTitreAuteurISBN(titre, auteur, isbn);
                } else if (!isbn.equals("") && !auteur.equals("") && titre.equals("")) {  // Recherche via isbn et editeur
                    livreUniqueList = managerFactory.getLivreUniqueManager().getListLivreUniqueAuteurISBN(auteur, isbn);
                } else if (!auteur.equals("") && !titre.equals("") && isbn.equals("")) {  // Recherche via titre et editeur
                    livreUniqueList = managerFactory.getLivreUniqueManager().getListLivreUniqueTitreAuteur(titre, auteur);
                } else if (!isbn.equals("") && !titre.equals("") && auteur.equals("")) { // Recherche via titre et isbn
                    livreUniqueList = managerFactory.getLivreUniqueManager().getListLivreUniqueTitreISBN(titre, isbn);
                } else if (!isbn.equals("") && titre.equals("") && auteur.equals("")) {  // Recherche via isbn
                    livreUniqueList = managerFactory.getLivreUniqueManager().getListLivreUniqueISBN(isbn);
                } else if (!auteur.equals("") && titre.equals("") && isbn.equals("")) { // Recherche via auteur
                    livreUniqueList = managerFactory.getLivreUniqueManager().getListLivreUniqueAuteur(auteur);
                } else if (!titre.equals("") && auteur.equals("") && isbn.equals("")) { // Recherche via titre
                    livreUniqueList = managerFactory.getLivreUniqueManager().getListLivreUniqueTitre(titre);
                }
            } else {
                bibliothequeId = managerFactory.getBibliothequeManager().getBibliothequeNom(bibliotheque).getId();
                if (!isbn.equals("") && !auteur.equals("") && !titre.equals("")) {   // Recherche via isbn titre et auteur
                    livreUniqueList = managerFactory.getLivreUniqueManager().getListLivreUniqueTitreAuteurISBNBibliotheque(titre, auteur, isbn, bibliothequeId);
                } else if (!isbn.equals("") && !auteur.equals("") && titre.equals("")) {  // Recherche via isbn et editeur
                    livreUniqueList = managerFactory.getLivreUniqueManager().getListLivreUniqueAuteurISBNBibliotheque(auteur, isbn, bibliothequeId);
                } else if (!auteur.equals("") && !titre.equals("") && isbn.equals("")) {  // Recherche via titre et editeur
                    livreUniqueList = managerFactory.getLivreUniqueManager().getListLivreUniqueTitreAuteurBibliotheque(titre, auteur, bibliothequeId);
                } else if (!isbn.equals("") && !titre.equals("") && auteur.equals("")) { // Recherche via titre et isbn
                    livreUniqueList = managerFactory.getLivreUniqueManager().getListLivreUniqueTitreISBNBibliotheque(titre, isbn, bibliothequeId);
                } else if (!isbn.equals("") && titre.equals("") && auteur.equals("")) {  // Recherche via isbn
                    livreUniqueList = managerFactory.getLivreUniqueManager().getListLivreUniqueISBNBibliotheque(isbn, bibliothequeId);
                } else if (!auteur.equals("") && titre.equals("") && isbn.equals("")) { // Recherche via auteur
                    livreUniqueList = managerFactory.getLivreUniqueManager().getListLivreUniqueAuteurBibliotheque(auteur, bibliothequeId);
                } else if (!titre.equals("") && auteur.equals("") && isbn.equals("")) { // Recherche via titre
                    livreUniqueList = managerFactory.getLivreUniqueManager().getListLivreUniqueTitreBibliotheque(titre, bibliothequeId);
                }
            }
            return ActionSupport.SUCCESS;
        }

        public String doSelectionAbonne(){
        
        }


    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getBibliotheque() {
        return bibliotheque;
    }

    public void setBibliotheque(String bibliotheque) {
        this.bibliotheque = bibliotheque;
    }

    public Integer getBibliothequeId() {
        return bibliothequeId;
    }

    public void setBibliothequeId(Integer bibliothequeId) {
        this.bibliothequeId = bibliothequeId;
    }

    public Livre getLivre() {
        return livre;
    }

    public void setLivre(Livre livre) {
        this.livre = livre;
    }

    public List<LivreUnique> getLivreUniqueList() {
        return livreUniqueList;
    }

    public void setLivreUniqueList(List<LivreUnique> livreUniqueList) {
        this.livreUniqueList = livreUniqueList;
    }

    public Integer getLivreId() {
        return livreId;
    }

    public void setLivreId(Integer livreId) {
        this.livreId = livreId;
    }
}


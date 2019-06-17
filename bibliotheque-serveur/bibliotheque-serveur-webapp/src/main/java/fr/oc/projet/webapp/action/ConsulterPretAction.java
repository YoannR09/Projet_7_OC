package fr.oc.projet.webapp.action;

import com.opensymphony.xwork2.ActionSupport;
import fr.oc.projet.business.contract.ManagerFactory;
import fr.oc.projet.model.beans.bibliotheque.Livre;
import fr.oc.projet.model.beans.utilisateur.Abonne;
import fr.oc.projet.model.beans.utilisateur.Pret;

import javax.inject.Inject;
import java.util.List;

/**
 * Classe qui gère la page pour consulter les prêts des abonnées.
 */
public class ConsulterPretAction extends ActionSupport {

    private         String          isbn;
    private         String          auteur;
    private         String          titre;
    private         String          email;
    private         String          pseudo;
    private         String          nom;
    private         String          prenom;
    private         String          bibliotheque;
    private         List<Pret>      pretList;
    private         Abonne          abonne;
    private         Livre           livre;

    @Inject
    private ManagerFactory managerFactory;

    /**
     * Méthode pour la recherche de prêts en cours
     * On peut rechercher via abonnées ou par livres
     * @return
     */
    public String doListPretRecherche(){

        if(!isbn.equals("") || !auteur.equals("") || !titre.equals("")){
            if(!isbn.equals("") &&  !auteur.equals("") &&  !titre.equals("")){  // Recherche via livre avec chaques input
                livre = managerFactory.getLivreManager().getLivreTitreAuteurISBN(titre,auteur,isbn);
            }else if (!isbn.equals("") &&  !auteur.equals("")  && titre.equals("")){  // Recherche via livre avec les inputs isbn et editeur


            }else if (!auteur.equals("") &&  !titre.equals("") && isbn.equals("")){  // Recherche via livre avec les inputs titre et editeur


            }else if(!isbn.equals("") &&  !titre.equals("") && auteur.equals("")){ // Recherche via livre avec les inputs titre et isbn


            }else if (!isbn.equals("") && titre.equals("") && auteur.equals("")){  // Recherche via isbn seulement


            } else if (!auteur.equals("") && titre.equals("") && isbn.equals("")){ // Recherche via auteur seulement


            }else if (!titre.equals("") && auteur.equals("") && isbn.equals("")){ // Recherche via titre seulement


            }
            pretList = managerFactory.getPretManager().getListPretLivre(livre.getId());
        }
        if(!pseudo.equals("") || !email.equals("") || !nom.equals("") || !prenom.equals("")){

        }

        return ActionSupport.SUCCESS;
    }

    public String doConsulterPret(){


        return  ActionSupport.SUCCESS;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getBibliotheque() {
        return bibliotheque;
    }

    public void setBibliotheque(String bibliotheque) {
        this.bibliotheque = bibliotheque;
    }

    public List<Pret> getPretList() {
        return pretList;
    }

    public void setPretList(List<Pret> pretList) {
        this.pretList = pretList;
    }

    public Abonne getAbonne() {
        return abonne;
    }

    public void setAbonne(Abonne abonne) {
        this.abonne = abonne;
    }

    public Livre getLivre() {
        return livre;
    }

    public void setLivre(Livre livre) {
        this.livre = livre;
    }
}

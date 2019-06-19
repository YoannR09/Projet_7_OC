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
            if(!isbn.equals("") &&  !auteur.equals("") &&  !titre.equals("")){  // Recherche via isbn titre et auteur
                livre = managerFactory.getLivreManager().getLivreTitreAuteurISBN(titre,auteur,isbn);
            }else if (!isbn.equals("") &&  !auteur.equals("")  && titre.equals("")){  // Recherche via isbn et editeur
                livre = managerFactory.getLivreManager().getLivreAuteurISBN(auteur,isbn);
            }else if (!auteur.equals("") &&  !titre.equals("") && isbn.equals("")){  // Recherche via titre et editeur
                livre = managerFactory.getLivreManager().getLivreTitreAuteur(titre,auteur);
            }else if(!isbn.equals("") &&  !titre.equals("") && auteur.equals("")){ // Recherche via titre et isbn
                livre = managerFactory.getLivreManager().getLivreTitreISBN(titre,isbn);
            }else if (!isbn.equals("") && titre.equals("") && auteur.equals("")){  // Recherche via isbn
                livre = managerFactory.getLivreManager().getLivreISBN(isbn);
            } else if (!auteur.equals("") && titre.equals("") && isbn.equals("")){ // Recherche via auteur
                livre = managerFactory.getLivreManager().getLivreAuteur(auteur);
            }else if (!titre.equals("") && auteur.equals("") && isbn.equals("")){ // Recherche via titre
                livre = managerFactory.getLivreManager().getLivreTitre(titre);
            }
            if(livre != null) {
                pretList = managerFactory.getPretManager().getListPretLivre(livre.getId());
            }
        }
        if(!pseudo.equals("") || !email.equals("") || !nom.equals("") || !prenom.equals("")){
            if(!pseudo.equals("") && !email.equals("") && !nom.equals("") && !prenom.equals("")){ // Recherche via pseudo email nom et prenom
                abonne = managerFactory.getAbonneManager().getAbonnePseudoEmailNomPrenom(pseudo,email,nom,prenom);
            }else if (!pseudo.equals("") && !email.equals("") && !nom.equals("") && prenom.equals("")){ // Recherche via pseudo email et nom
                abonne = managerFactory.getAbonneManager().getAbonnePseudoEmailNom(pseudo,email,nom);
            }else if (!pseudo.equals("") && !email.equals("") && !prenom.equals("") && nom.equals("")){ // Recherche via pseudo email et prenom
                abonne = managerFactory.getAbonneManager().getAbonnePseudoEmailPrenom(pseudo,email,prenom);
            }else if (!pseudo.equals("") && !nom.equals("") && !prenom.equals("") && email.equals("")){ // Recherche via pseudo nom et prenom
                abonne = managerFactory.getAbonneManager().getAbonnePseudoNomPrenom(pseudo,nom,prenom);
            }else if (pseudo.equals("") && !email.equals("") && !nom.equals("") && !prenom.equals("")){ // Recherche via email nom et prenom
                abonne = managerFactory.getAbonneManager().getAbonneEmailNomPrenom(email,nom,prenom);
            }else if (!pseudo.equals("") && !email.equals("") && prenom.equals("") && nom.equals("") ){ // Recherche via pseudo et email
                abonne = managerFactory.getAbonneManager().getAbonnePseudoEmail(pseudo,email);
            }else if (!nom.equals("") && !prenom.equals("") && pseudo.equals("") && email.equals("")){  // Recherche via nom et prenom
                abonne = managerFactory.getAbonneManager().getAbonneNomPrenom(nom,prenom);
            }else if (!pseudo.equals("") && !prenom.equals("") && email.equals("") && nom.equals("")){  // Recherche via pseudo et prenom
                abonne = managerFactory.getAbonneManager().getAbonnePseudoPrenom(pseudo,prenom);
            }else if(!email.equals("") && !nom.equals("") && pseudo.equals("") && prenom.equals("")){   // Recherche via email et nom
                abonne = managerFactory.getAbonneManager().getAbonneEmailNom(email,nom);
            }else if(!email.equals("") && !prenom.equals("") && nom.equals("") && pseudo.equals("")){   // Recherche via email et prenom
                abonne = managerFactory.getAbonneManager().getAbonneEmailPrenom(email,prenom);
            }else if(!pseudo.equals("") && !nom.equals("") && email.equals("") && prenom.equals("")){   // Recherche via pseudo et nom
                abonne = managerFactory.getAbonneManager().getAbonnePseudoNom(pseudo,nom);
            }else if(!pseudo.equals("") && nom.equals("") && email.equals("") && prenom.equals("")){    // Recherche via pseudo
                abonne = managerFactory.getAbonneManager().getAbonnePseudo(pseudo);
            }else if(!email.equals("") && nom.equals("") && pseudo.equals("") && prenom.equals("")){    // Recherche via email
                abonne = managerFactory.getAbonneManager().getAbonneEmail(email);
            }else if (!nom.equals("") && pseudo.equals("") && prenom.equals("") && email.equals("")){   // Recherche via nom
                abonne = managerFactory.getAbonneManager().getAbonneNom(nom);
            }else if (!prenom.equals("") && pseudo.equals("") && nom.equals("") && email.equals("")){   // Recherche via prenom
                abonne = managerFactory.getAbonneManager().getAbonnePrenom(prenom);
            }
            if(abonne!= null) {
                pretList = managerFactory.getPretManager().getListPretAbonne(abonne.getId());
            }
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

package fr.oc.projet.webapp.action;

import com.opensymphony.xwork2.ActionSupport;
import fr.oc.projet.business.contract.ManagerFactory;
import fr.oc.projet.model.beans.bibliotheque.Livre;
import fr.oc.projet.model.beans.bibliotheque.LivreUnique;
import fr.oc.projet.model.beans.utilisateur.Abonne;
import fr.oc.projet.model.beans.utilisateur.Pret;

import javax.inject.Inject;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class AjouterPretAction extends ActionSupport {

    private         String              isbn;
    private         String              auteur;
    private         String              titre;
    private         String              bibliotheque;
    private         String              email;
    private         String              pseudo;
    private         String              nom;
    private         String              prenom;
    private         Integer             bibliothequeId;
    private         Integer             livreUniqueId;
    private         Integer             abonneId;
    private         Integer             countResultat;
    private         Livre               livre;
    private         Abonne              abonne;
    private         List<LivreUnique>   livreUniqueList;

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
            countResultat = livreUniqueList.size();
            return ActionSupport.SUCCESS;
        }

        public String doSelectionAbonne(){


        return ActionSupport.SUCCESS;
        }

        public String doAbonne(){

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

        return ActionSupport.SUCCESS;
        }

        public String doAjouterPret(){

        Pret pret = new Pret();

        pret.setDateEmprunt(new Date());
        Calendar cal = Calendar.getInstance();
        cal.setTime(pret.getDateEmprunt());
        cal.add(Calendar.DATE,28);
        pret.setDateRestitution(cal.getTime());
        pret.setProlongation(false);
        pret.setLivreUniqueId(livreUniqueId);
        pret.setAbonneId(abonneId);

        LivreUnique livreUnique = managerFactory.getLivreUniqueManager().getLivreUnique(livreUniqueId);
        livreUnique.setDisponible(false);
        managerFactory.getLivreUniqueManager().updateDispo(livreUnique);
        managerFactory.getPretManager().addPret(pret);

        this.addActionMessage("Nouveau prêt ajouté pour l'abonné : "+
                managerFactory.getAbonneManager().getAbonne(pret.getAbonneId()).getNom()
                +"  "+managerFactory.getAbonneManager().getAbonne(pret.getAbonneId()).getPrenom());

        return ActionSupport.SUCCESS;
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

    public Integer getLivreUniqueId() {
        return livreUniqueId;
    }

    public void setLivreUniqueId(Integer livreUniqueId) {
        this.livreUniqueId = livreUniqueId;
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

    public Abonne getAbonne() {
        return abonne;
    }

    public void setAbonne(Abonne abonne) {
        this.abonne = abonne;
    }

    public Integer getAbonneId() {
        return abonneId;
    }

    public void setAbonneId(Integer abonneId) {
        this.abonneId = abonneId;
    }

    public Integer getCountResultat() {
        return countResultat;
    }

    public void setCountResultat(Integer countResultat) {
        this.countResultat = countResultat;
    }
}


package fr.oc.projet.model.beans.utilisateur;

import fr.oc.projet.model.beans.bibliotheque.Livre;

import java.util.Date;

public class Reservation {

    private         Integer         id;
    private         Date            dateDeDebut;
    private         Date            dateDeFin;
    private         Boolean         prolonge;
    private         Livre           livre;
    private         Compte          compte;

    public Reservation() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateDeDebut() {
        return dateDeDebut;
    }

    public void setDateDeDebut(Date dateDeDebut) {
        this.dateDeDebut = dateDeDebut;
    }

    public Date getDateDeFin() {
        return dateDeFin;
    }

    public void setDateDeFin(Date dateDeFin) {
        this.dateDeFin = dateDeFin;
    }

    public Boolean getProlonge() {
        return prolonge;
    }

    public void setProlonge(Boolean prolonge) {
        this.prolonge = prolonge;
    }

    public Livre getLivre() {
        return livre;
    }

    public void setLivre(Livre livre) {
        this.livre = livre;
    }

    public Compte getCompte() {
        return compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }
}

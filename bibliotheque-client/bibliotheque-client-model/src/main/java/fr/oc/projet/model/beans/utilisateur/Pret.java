package fr.oc.projet.model.beans.utilisateur;

import fr.oc.projet.model.beans.bibliotheque.Livre;

import java.util.Date;

public class Pret {

    private         Integer         id;
    private         Date            dateEmprunt;
    private         Date            dateResiliationPrevue;
    private         Boolean         prolonge;
    private         Livre           livre;
    private         Compte          compte;

    public Pret() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateEmprunt() {
        return dateEmprunt;
    }

    public void setDateEmprunt(Date dateEmprunt) {
        this.dateEmprunt = dateEmprunt;
    }

    public Date getDateResiliationPrevue() {
        return dateResiliationPrevue;
    }

    public void setDateResiliationPrevue(Date dateResiliationPrevue) {
        this.dateResiliationPrevue = dateResiliationPrevue;
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

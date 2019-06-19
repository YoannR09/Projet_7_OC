package fr.oc.projet.model.beans.utilisateur;

import fr.oc.projet.model.beans.bibliotheque.Livre;
import fr.oc.projet.model.beans.bibliotheque.LivreUnique;

import java.util.Date;

public class Pret {

    private         Integer         id;
    private         Date            dateEmprunt;
    private         Date            dateRestitution;
    private         Boolean         prolonge;
    private         LivreUnique     livreUnique;
    private         Abonne          abonne;

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

    public Date getDateRestitution() {
        return dateRestitution;
    }

    public void setDateRestitution(Date dateRestitution) {
        this.dateRestitution = dateRestitution;
    }

    public Boolean getProlonge() {
        return prolonge;
    }

    public void setProlonge(Boolean prolonge) {
        this.prolonge = prolonge;
    }

    public LivreUnique getLivreUnique() {
        return livreUnique;
    }

    public void setLivreUnique(LivreUnique livreUnique) {
        this.livreUnique = livreUnique;
    }

    public Abonne getAbonne() {
        return abonne;
    }

    public void setAbonne(Abonne abonne) {
        this.abonne = abonne;
    }

}

package fr.oc.projet.business.contract.manager.utilisateur;

import fr.oc.projet.model.beans.utilisateur.Abonne;

public interface AbonneManager {
    Abonne getAbonne(Integer pId);

    Abonne getAbonnePseudo(String pseudo);

    void addAbonne(Abonne abonne);

    void updateMpd(Abonne abonne);

    void updateMail(Abonne abonne);
}

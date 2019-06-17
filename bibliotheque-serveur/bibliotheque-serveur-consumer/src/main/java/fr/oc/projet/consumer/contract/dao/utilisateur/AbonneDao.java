package fr.oc.projet.consumer.contract.dao.utilisateur;

import fr.oc.projet.model.beans.utilisateur.Abonne;

public interface AbonneDao {

    Abonne getAbonne(Integer pId);

    Abonne getAbonnePseudo(String pseudo);

    void addAbonne(Abonne abonne);

    void updateMpd(Abonne abonne);

    void updateMail(Abonne abonne);
}

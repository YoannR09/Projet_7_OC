package fr.oc.projet.consumer.contract.dao.utilisateur;

import fr.oc.projet.model.beans.utilisateur.Compte;

public interface CompteDao {

    Compte getCompte(Integer pId);

    Compte getComptePseudo(String pseudo);

    void addCompte(Compte compte);

    void updateMpd(Compte compte);

    void updateMail(Compte compte);
}

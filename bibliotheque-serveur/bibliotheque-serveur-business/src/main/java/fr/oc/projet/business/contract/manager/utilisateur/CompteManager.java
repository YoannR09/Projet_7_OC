package fr.oc.projet.business.contract.manager.utilisateur;

import fr.oc.projet.model.beans.utilisateur.Compte;

public interface CompteManager {
    Compte getCompte(Integer pId);

    Compte getComptePseudo(String pseudo);

    void addCompte(Compte compte);

    void updateMpd(Compte compte);

    void updateMail(Compte compte);
}

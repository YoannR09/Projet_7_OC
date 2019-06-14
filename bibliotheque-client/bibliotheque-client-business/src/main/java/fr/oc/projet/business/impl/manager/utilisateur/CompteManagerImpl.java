package fr.oc.projet.business.impl.manager.utilisateur;

import fr.oc.projet.business.contract.manager.utilisateur.CompteManager;
import fr.oc.projet.business.impl.manager.AbstractManagerImpl;
import fr.oc.projet.model.beans.utilisateur.Compte;

import javax.inject.Named;

@Named
public class CompteManagerImpl extends AbstractManagerImpl implements CompteManager {

    @Override
    public Compte getCompte(Integer pId) {
        return getDaoFactory().getCompteDao().getCompte(pId);
    }

    @Override
    public Compte getComptePseudo(String pseudo) {
        return getDaoFactory().getCompteDao().getComptePseudo(pseudo);
    }

    @Override
    public void addCompte(Compte compte) {
        getDaoFactory().getCompteDao().addCompte(compte);
    }

    @Override
    public void updateMpd(Compte compte) {
        getDaoFactory().getCompteDao().updateMpd(compte);
    }

    @Override
    public void updateMail(Compte compte) {
        getDaoFactory().getCompteDao().updateMail(compte);
    }
}

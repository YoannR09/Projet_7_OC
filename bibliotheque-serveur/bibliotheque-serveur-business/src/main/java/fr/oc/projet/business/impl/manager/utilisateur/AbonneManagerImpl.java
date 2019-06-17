package fr.oc.projet.business.impl.manager.utilisateur;

import fr.oc.projet.business.contract.manager.utilisateur.AbonneManager;
import fr.oc.projet.business.impl.manager.AbstractManagerImpl;
import fr.oc.projet.model.beans.utilisateur.Abonne;

import javax.inject.Named;

@Named
public class AbonneManagerImpl extends AbstractManagerImpl implements AbonneManager {

    @Override
    public Abonne getAbonne(Integer pId) {
        return getDaoFactory().getAbonneDao().getAbonne(pId);
    }

    @Override
    public Abonne getAbonnePseudo(String pseudo) {
        return getDaoFactory().getAbonneDao().getAbonnePseudo(pseudo);
    }

    @Override
    public void addAbonne(Abonne abonne) {
        getDaoFactory().getAbonneDao().addAbonne(abonne);
    }

    @Override
    public void updateMpd(Abonne abonne) {
        getDaoFactory().getAbonneDao().updateMpd(abonne);
    }

    @Override
    public void updateMail(Abonne abonne) {
        getDaoFactory().getAbonneDao().updateMail(abonne);
    }
}

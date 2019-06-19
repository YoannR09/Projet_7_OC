package fr.oc.projet.business.impl.manager.utilisateur;

import fr.oc.projet.business.contract.manager.utilisateur.PretManager;
import fr.oc.projet.business.impl.manager.AbstractManagerImpl;
import fr.oc.projet.model.beans.utilisateur.Pret;

import javax.inject.Named;
import java.util.List;

@Named
public class PretManagerImpl extends AbstractManagerImpl implements PretManager {


    @Override
    public Pret getPret(Integer pId) {
        return getDaoFactory().getPretDao().getPret(pId);
    }

    @Override
    public List<Pret> getListPret() {
        return getDaoFactory().getPretDao().getListPret();
    }

    @Override
    public List<Pret> getListPretLivre(Integer livreId) {
        return getDaoFactory().getPretDao().getListPretLivre(livreId);
    }

    @Override
    public List<Pret> getListPretAbonne(Integer abonneId) {
        return getDaoFactory().getPretDao().getListPretAbonne(abonneId);
    }

    @Override
    public void updateProlongation(Pret pret) {
        getDaoFactory().getPretDao().updateProlongation(pret);
    }

    @Override
    public void updateDateRestitution(Pret pret) {
        getDaoFactory().getPretDao().updateDateRestitution(pret);
    }
}

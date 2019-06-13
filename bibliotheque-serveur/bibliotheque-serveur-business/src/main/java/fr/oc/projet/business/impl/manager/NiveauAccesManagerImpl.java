package fr.oc.projet.business.impl.manager;

import fr.oc.projet.business.contract.manager.NiveauAccesManager;
import fr.oc.projet.business.impl.manager.AbstractManagerImpl;
import fr.oc.projet.model.beans.utilisateur.NiveauAcces;

import javax.inject.Named;
import java.util.List;

@Named
public class NiveauAccesManagerImpl extends AbstractManagerImpl implements NiveauAccesManager {
    @Override
    public NiveauAcces getNiveauAcces(Integer pId) {
        return getDaoFactory().getNiveauAccesDao().getNiveauAcces(pId);
    }

    @Override
    public List<NiveauAcces> getListNiveauAcces() {
        return getDaoFactory().getNiveauAccesDao().getListNiveauAcces();
    }
}

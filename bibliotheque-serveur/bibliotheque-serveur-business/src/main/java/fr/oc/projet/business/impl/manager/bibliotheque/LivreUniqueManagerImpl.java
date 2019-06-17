package fr.oc.projet.business.impl.manager.bibliotheque;

import fr.oc.projet.business.contract.manager.bibliotheque.LivreUniqueManager;
import fr.oc.projet.business.impl.manager.AbstractManagerImpl;
import fr.oc.projet.model.beans.bibliotheque.LivreUnique;

import javax.inject.Named;
import java.util.List;

@Named
public class LivreUniqueManagerImpl extends AbstractManagerImpl implements LivreUniqueManager {

    @Override
    public LivreUnique getLivreUnique(Integer pId) {
        return getDaoFactory().getLivreUniqueDao().getLivreUnique(pId);
    }

    @Override
    public List<LivreUnique> getListLivreUnique() {
        return getDaoFactory().getLivreUniqueDao().getListLivreUnique();
    }
}

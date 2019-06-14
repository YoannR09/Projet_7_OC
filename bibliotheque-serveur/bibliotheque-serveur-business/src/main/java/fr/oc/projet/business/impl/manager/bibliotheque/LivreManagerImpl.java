package fr.oc.projet.business.impl.manager.bibliotheque;

import fr.oc.projet.business.contract.manager.bibliotheque.LivreManager;
import fr.oc.projet.business.impl.manager.AbstractManagerImpl;
import fr.oc.projet.model.beans.bibliotheque.Livre;

import javax.inject.Named;
import java.util.List;

@Named
public class LivreManagerImpl extends AbstractManagerImpl implements LivreManager {
    @Override
    public Livre getLivre(Integer pId) {
        return getDaoFactory().getLivreDao().getLivre(pId);
    }

    @Override
    public List<Livre> getListLivre() {
        return getDaoFactory().getLivreDao().getListLivre();
    }
}

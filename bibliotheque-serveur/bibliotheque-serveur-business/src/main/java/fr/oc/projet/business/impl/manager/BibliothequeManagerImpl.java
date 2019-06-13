package fr.oc.projet.business.impl.manager;

import fr.oc.projet.business.contract.manager.BibliothequeManager;
import fr.oc.projet.model.beans.bibliotheque.Bibliotheque;

import javax.inject.Named;
import java.util.List;

@Named
public class BibliothequeManagerImpl extends AbstractManagerImpl implements BibliothequeManager {


    @Override
    public Bibliotheque getBibliotheque(Integer pId) {
        return getDaoFactory().getBibliotheque().getBibliotheque(pId);
    }

    @Override
    public List<Bibliotheque> getListBibliotheque() {
        return getDaoFactory().getBibliotheque().getListBibliotheque();
    }
}

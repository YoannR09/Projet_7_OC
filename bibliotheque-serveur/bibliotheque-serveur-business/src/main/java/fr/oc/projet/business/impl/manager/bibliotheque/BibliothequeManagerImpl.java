package fr.oc.projet.business.impl.manager.bibliotheque;

import fr.oc.projet.business.impl.manager.AbstractManagerImpl;
import fr.oc.projet.consumer.contract.dao.bibliotheque.BibliothequeDao;
import fr.oc.projet.model.beans.bibliotheque.Bibliotheque;

import javax.inject.Named;
import java.util.List;

@Named
public class BibliothequeManagerImpl extends AbstractManagerImpl implements BibliothequeDao {


    @Override
    public Bibliotheque getBibliotheque(Integer pId) {
        return getDaoFactory().getBibliotheque().getBibliotheque(pId);
    }

    @Override
    public List<Bibliotheque> getListBibliotheque() {
        return getDaoFactory().getBibliotheque().getListBibliotheque();
    }
}

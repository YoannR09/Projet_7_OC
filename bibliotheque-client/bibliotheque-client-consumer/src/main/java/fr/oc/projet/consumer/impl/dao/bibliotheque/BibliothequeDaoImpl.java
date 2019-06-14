package fr.oc.projet.consumer.impl.dao.bibliotheque;

import fr.oc.projet.consumer.contract.dao.bibliotheque.BibliothequeDao;
import fr.oc.projet.consumer.impl.dao.AbstractDaoImpl;
import fr.oc.projet.model.beans.bibliotheque.Bibliotheque;

import javax.inject.Named;
import java.util.List;

@Named
public class BibliothequeDaoImpl extends AbstractDaoImpl implements BibliothequeDao {



    @Override
    public Bibliotheque getBibliotheque(Integer pId) {
        return null;
    }

    @Override
    public List<Bibliotheque> getListBibliotheque() {
      return null;
    }
}

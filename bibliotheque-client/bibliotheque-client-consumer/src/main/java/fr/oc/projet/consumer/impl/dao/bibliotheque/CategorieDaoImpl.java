package fr.oc.projet.consumer.impl.dao.bibliotheque;

import fr.oc.projet.consumer.contract.dao.bibliotheque.CategorieDao;
import fr.oc.projet.consumer.impl.dao.AbstractDaoImpl;
import fr.oc.projet.model.beans.bibliotheque.Categorie;

import javax.inject.Named;
import java.util.List;

@Named
public class CategorieDaoImpl extends AbstractDaoImpl implements CategorieDao {


    @Override
    public Categorie getCategorie(Integer pId) {
        return null;
    }

    @Override
    public List<Categorie> getListCategorie() {
        return null;
    }
}

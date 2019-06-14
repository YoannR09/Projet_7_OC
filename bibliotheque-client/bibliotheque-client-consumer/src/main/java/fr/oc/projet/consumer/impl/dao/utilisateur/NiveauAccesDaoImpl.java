package fr.oc.projet.consumer.impl.dao.utilisateur;

import fr.oc.projet.consumer.contract.dao.utilisateur.NiveauAccesDao;
import fr.oc.projet.consumer.impl.dao.AbstractDaoImpl;
import fr.oc.projet.model.beans.utilisateur.NiveauAcces;

import javax.inject.Named;
import java.util.List;

@Named
public class NiveauAccesDaoImpl extends AbstractDaoImpl implements NiveauAccesDao {



    @Override
    public NiveauAcces getNiveauAcces(Integer pId) {
        return null;
    }

    @Override
    public List<NiveauAcces> getListNiveauAcces() {
        return null;
    }
}

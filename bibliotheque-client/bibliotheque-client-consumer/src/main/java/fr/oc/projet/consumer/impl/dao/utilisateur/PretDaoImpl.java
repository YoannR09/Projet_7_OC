package fr.oc.projet.consumer.impl.dao.utilisateur;

import fr.oc.projet.consumer.contract.dao.utilisateur.PretDao;
import fr.oc.projet.consumer.impl.dao.AbstractDaoImpl;
import fr.oc.projet.model.beans.utilisateur.Pret;

import javax.inject.Named;
import java.util.List;

@Named
public class PretDaoImpl extends AbstractDaoImpl implements PretDao {


    @Override
    public Pret getPret(Integer pId) {
        return null;
    }

    @Override
    public List<Pret> getListPret() {
        return null;
    }
}

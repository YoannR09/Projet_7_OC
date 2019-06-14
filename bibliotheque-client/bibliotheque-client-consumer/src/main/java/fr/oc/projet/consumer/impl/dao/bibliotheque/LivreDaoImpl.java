package fr.oc.projet.consumer.impl.dao.bibliotheque;

import fr.oc.projet.consumer.contract.dao.bibliotheque.LivreDao;
import fr.oc.projet.consumer.impl.dao.AbstractDaoImpl;
import fr.oc.projet.model.beans.bibliotheque.Livre;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.inject.Named;
import java.util.List;

@Named
public class LivreDaoImpl extends AbstractDaoImpl implements LivreDao {


    @Override
    public Livre getLivre(Integer pId) {
       return null;
    }

    @Override
    public List<Livre> getListLivre() {
        return null;
    }
}

package fr.oc.projet.consumer.impl.dao.bibliotheque;

import fr.oc.projet.consumer.contract.dao.bibliotheque.LivreDao;
import fr.oc.projet.consumer.impl.dao.AbstractDaoImpl;
import fr.oc.projet.consumer.rowmapper.bibliotheque.LivreRM;
import fr.oc.projet.model.beans.bibliotheque.Livre;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class LivreDaoImpl extends AbstractDaoImpl implements LivreDao {

    @Inject
    LivreRM livreRM;

    @Override
    public Livre getLivre(Integer pId) {
        String vSQL = "SELECT * FROM livre WHERE id ="+pId;
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        Livre livre = vJdbcTemplate.queryForObject(vSQL,livreRM);
        return livre;
    }

    @Override
    public List<Livre> getListLivre() {
        String vSQL = "SELECT * FROM livre ";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<Livre> vList = vJdbcTemplate.query(vSQL,livreRM);
        return vList;
    }
}

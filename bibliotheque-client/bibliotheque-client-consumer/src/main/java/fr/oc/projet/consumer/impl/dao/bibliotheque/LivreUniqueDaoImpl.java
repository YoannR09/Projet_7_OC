package fr.oc.projet.consumer.impl.dao.bibliotheque;

import fr.oc.projet.consumer.contract.dao.bibliotheque.LivreUniqueDao;
import fr.oc.projet.consumer.impl.dao.AbstractDaoImpl;
import fr.oc.projet.consumer.rowmapper.bibliotheque.LivreUniqueRM;
import fr.oc.projet.model.beans.bibliotheque.LivreUnique;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class LivreUniqueDaoImpl extends AbstractDaoImpl implements LivreUniqueDao {

    @Inject
    LivreUniqueRM livreUniqueRM;

    @Override
    public LivreUnique getLivreUnique(Integer pId) {
        String vSQL = "SELECT * FROM livre_unique WHERE id ="+pId;
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        LivreUnique livreUnique = vJdbcTemplate.queryForObject(vSQL,livreUniqueRM);
        return livreUnique;
    }

    @Override
    public List<LivreUnique> getListLivreUnique() {
        String vSQL = "SELECT * FROM livre_unique ";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<LivreUnique> vList = vJdbcTemplate.query(vSQL,livreUniqueRM);
        return vList;
    }
}

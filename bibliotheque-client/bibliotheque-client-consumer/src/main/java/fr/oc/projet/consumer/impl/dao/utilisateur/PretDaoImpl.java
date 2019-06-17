package fr.oc.projet.consumer.impl.dao.utilisateur;

import fr.oc.projet.consumer.contract.dao.utilisateur.PretDao;
import fr.oc.projet.consumer.impl.dao.AbstractDaoImpl;
import fr.oc.projet.consumer.rowmapper.utilisateur.PretRM;
import fr.oc.projet.model.beans.utilisateur.Pret;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class PretDaoImpl extends AbstractDaoImpl implements PretDao {

    @Inject
    private PretRM pretRM;

    @Override
    public Pret getPret(Integer pId) {
        String vSQL = "SELECT * FROM reservation WHERE id ="+pId;
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        Pret reservation = vJdbcTemplate.queryForObject(vSQL,pretRM);
        return reservation;
    }

    @Override
    public List<Pret> getListPret() {
        String vSQL = "SELECT * FROM reservation ";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<Pret> vList = vJdbcTemplate.query(vSQL,pretRM);
        return vList;
    }
}

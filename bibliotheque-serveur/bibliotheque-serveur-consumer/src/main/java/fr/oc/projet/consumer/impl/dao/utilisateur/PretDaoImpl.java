package fr.oc.projet.consumer.impl.dao.utilisateur;

import fr.oc.projet.consumer.contract.dao.utilisateur.PretDao;
import fr.oc.projet.consumer.impl.dao.AbstractDaoImpl;
import fr.oc.projet.consumer.rowmapper.utilisateur.PretRM;
import fr.oc.projet.model.beans.utilisateur.Pret;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameterValue;

import javax.inject.Inject;
import javax.inject.Named;
import java.sql.Types;
import java.util.List;

@Named
public class PretDaoImpl extends AbstractDaoImpl implements PretDao {

    @Inject
    private PretRM pretRM;

    @Override
    public Pret getPret(Integer pId) {
        String vSQL = "SELECT * FROM pret WHERE id ="+pId;
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        Pret reservation = vJdbcTemplate.queryForObject(vSQL,pretRM);
        return reservation;
    }

    @Override
    public List<Pret> getListPret() {
        String vSQL = "SELECT * FROM pret ";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<Pret> vList = vJdbcTemplate.query(vSQL,pretRM);
        return vList;
    }

    @Override
    public List<Pret> getListPretLivre(Integer livreId) {
        String vSQL = "SELECT * FROM pret,livre_unique WHERE livre_unique.id = "+livreId;
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<Pret> vList = vJdbcTemplate.query(vSQL,pretRM);
        return vList;
    }

    @Override
    public List<Pret> getListPretAbonne(Integer abonneId) {
        String vSQL = "SELECT * FROM pret WHERE abonne_id = "+abonneId;
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<Pret> vList = vJdbcTemplate.query(vSQL,pretRM);
        return vList;
    }

    @Override
    public void updateProlongation(Pret pret) {

        String vSQL = "UPDATE pret SET prolonge = ? WHERE id = ?";
        Object[] vParams = {
                new SqlParameterValue(Types.BOOLEAN, pret.getProlonge()),
                new SqlParameterValue(Types.INTEGER, pret.getId()),
        };
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        vJdbcTemplate.update(vSQL, vParams);
    }

    @Override
    public void updateDateRestitution(Pret pret) {

        String vSQL = "UPDATE pret SET date_restitution = ? WHERE id = ?";
        Object[] vParams = {
                new SqlParameterValue(Types.DATE, pret.getDateRestitution()),
                new SqlParameterValue(Types.INTEGER, pret.getId()),
        };
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        vJdbcTemplate.update(vSQL, vParams);
    }

}

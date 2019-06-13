package fr.oc.projet.consumer.impl.dao.utilisateur;

import fr.oc.projet.consumer.contract.dao.utilisateur.NiveauAccesDao;
import fr.oc.projet.consumer.impl.dao.AbstractDaoImpl;
import fr.oc.projet.consumer.rowmapper.utilisateur.NiveauAccesRM;
import fr.oc.projet.model.beans.utilisateur.NiveauAcces;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class NiveauAccesDaoImpl extends AbstractDaoImpl implements NiveauAccesDao {

    @Inject
    NiveauAccesRM niveauAccesRM;

    @Override
    public NiveauAcces getNiveauAcces(Integer pId) {
        String vSQL = "SELECT * FROM niveau_acces WHERE id ="+pId;
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        NiveauAcces niveauAcces = vJdbcTemplate.queryForObject(vSQL,niveauAccesRM);
        return niveauAcces;
    }

    @Override
    public List<NiveauAcces> getListNiveauAcces() {
        return null;
    }
}

package fr.oc.projet.consumer.impl.dao.utilisateur;

import fr.oc.projet.consumer.contract.dao.utilisateur.AbonneDao;
import fr.oc.projet.consumer.impl.dao.AbstractDaoImpl;
import fr.oc.projet.consumer.rowmapper.utilisateur.AbonneRM;
import fr.oc.projet.model.beans.utilisateur.Abonne;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameterValue;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.inject.Inject;
import javax.inject.Named;
import java.sql.Types;


/**
 * Class qui gère les données des comptes.
 * On peut récupérer un compte via pseudo/id,
 * Récupérer la liste des comptes dans la base de données,
 * Ajouter un compte dans la base de données.
 */
@Named
public class AbonneDaoImpl extends AbstractDaoImpl implements AbonneDao {

    @Inject
    private AbonneRM abonneRM;


    @Override
    public Abonne getAbonne(Integer pId) {
        String vSQL = "SELECT * FROM abonne WHERE id ="+pId;
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        Abonne abonne = vJdbcTemplate.queryForObject(vSQL, abonneRM);
        return abonne;
    }

    @Override
    public Abonne getAbonnePseudo(String pseudo) {
        String vSQL = "SELECT * FROM abonne WHERE pseudo = '"+pseudo+"'";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        Abonne abonne = vJdbcTemplate.queryForObject(vSQL, abonneRM);
        return abonne;
    }

    @Override
    public void addAbonne(Abonne abonne) {
        String vSQL = "INSERT INTO compte (nom, prenom, mot_de_passe, email, numero_de_telephone, niveau_acces_id)" +
                " VALUES (:nom, :prenom, :motDePasse, :email, :numero, :niveau)";
        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        BeanPropertySqlParameterSource vParams = new BeanPropertySqlParameterSource(abonne);
        vParams.registerSqlType("nom", Types.VARCHAR);
        vParams.registerSqlType("prenom", Types.VARCHAR);
        vParams.registerSqlType("motDePasse", Types.VARCHAR);
        vParams.registerSqlType("email", Types.VARCHAR);
        vParams.registerSqlType("numero", Types.VARCHAR);
        vParams.registerSqlType("niveau", Types.INTEGER);
        vJdbcTemplate.update(vSQL, vParams);
    }

    @Override
    public void updateMpd(Abonne abonne) {
        String vSQL = "UPDATE abonne SET mot_de_passe = ? WHERE id = ?";
        Object[] vParams = {
                new SqlParameterValue(Types.VARCHAR, abonne.getMotDePasse()),
                new SqlParameterValue(Types.INTEGER, abonne.getId()),
        };
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        vJdbcTemplate.update(vSQL, vParams);
    }

    @Override
    public void updateMail(Abonne abonne) {
        String vSQL = "UPDATE abonne SET email = ? WHERE id = ?";
        Object[] vParams = {
                new SqlParameterValue(Types.VARCHAR, abonne.getEmail()),
                new SqlParameterValue(Types.INTEGER, abonne.getId()),
        };
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        vJdbcTemplate.update(vSQL, vParams);
    }
}

package fr.oc.projet.consumer.impl.dao.utilisateur;

import fr.oc.projet.consumer.contract.dao.utilisateur.CompteDao;
import fr.oc.projet.consumer.impl.dao.AbstractDaoImpl;
import fr.oc.projet.consumer.rowmapper.utilisateur.CompteRM;
import fr.oc.projet.model.beans.utilisateur.Compte;
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
public class CompteDaoImpl extends AbstractDaoImpl implements CompteDao {

    @Inject
    private CompteRM compteRM;


    @Override
    public Compte getCompte(Integer pId) {
        String vSQL = "SELECT * FROM compte WHERE id ="+pId;
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        Compte compte = vJdbcTemplate.queryForObject(vSQL,compteRM);
        return compte;
    }

    @Override
    public Compte getComptePseudo(String pseudo) {
        String vSQL = "SELECT * FROM compte WHERE pseudo = '"+pseudo+"'";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        Compte compte = vJdbcTemplate.queryForObject(vSQL,compteRM);
        return compte;
    }

    @Override
    public void addCompte(Compte compte) {
        String vSQL = "INSERT INTO compte (nom, prenom, mot_de_passe, email, numero_de_telephone, niveau_acces_id)" +
                " VALUES (:nom, :prenom, :motDePasse, :email, :numero, :niveau)";
        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        BeanPropertySqlParameterSource vParams = new BeanPropertySqlParameterSource(compte);
        vParams.registerSqlType("nom", Types.VARCHAR);
        vParams.registerSqlType("prenom", Types.VARCHAR);
        vParams.registerSqlType("motDePasse", Types.VARCHAR);
        vParams.registerSqlType("email", Types.VARCHAR);
        vParams.registerSqlType("numero", Types.VARCHAR);
        vParams.registerSqlType("niveau", Types.INTEGER);
        vJdbcTemplate.update(vSQL, vParams);
    }

    @Override
    public void updateMpd(Compte compte) {
        String vSQL = "UPDATE compte SET mot_de_passe = ? WHERE id = ?";
        Object[] vParams = {
                new SqlParameterValue(Types.VARCHAR, compte.getMotDePasse()),
                new SqlParameterValue(Types.INTEGER, compte.getId()),
        };
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        vJdbcTemplate.update(vSQL, vParams);
    }

    @Override
    public void updateMail(Compte compte) {
        String vSQL = "UPDATE compte SET email = ? WHERE id = ?";
        Object[] vParams = {
                new SqlParameterValue(Types.VARCHAR, compte.getEmail()),
                new SqlParameterValue(Types.INTEGER, compte.getId()),
        };
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        vJdbcTemplate.update(vSQL, vParams);
    }
}

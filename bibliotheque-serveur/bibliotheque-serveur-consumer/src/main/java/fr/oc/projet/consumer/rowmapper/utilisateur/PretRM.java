package fr.oc.projet.consumer.rowmapper.utilisateur;

import fr.oc.projet.consumer.contract.dao.bibliotheque.LivreDao;
import fr.oc.projet.consumer.contract.dao.utilisateur.CompteDao;
import fr.oc.projet.model.beans.utilisateur.Pret;
import org.springframework.jdbc.core.RowMapper;

import javax.inject.Inject;
import javax.inject.Named;
import java.sql.ResultSet;
import java.sql.SQLException;

@Named
public class PretRM implements RowMapper<Pret> {

    @Inject
    private CompteDao compteDao;
    @Inject
    private LivreDao livreDao;

    @Override
    public Pret mapRow(ResultSet resultSet, int i) throws SQLException {
        Pret pret = new Pret();
        pret.setId(resultSet.getInt("id"));
        pret.setDateEmprunt(resultSet.getDate("date_de_debut"));
        pret.setDateResiliationPrevue(resultSet.getDate("date_de_fin"));
        pret.setProlonge(resultSet.getBoolean("prolonge"));
        pret.setCompte(compteDao.getCompte(resultSet.getInt("compte_id")));
        pret.setLivre(livreDao.getLivre(resultSet.getInt("livre_id")));
        return pret;
    }
}

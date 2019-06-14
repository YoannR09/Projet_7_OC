package fr.oc.projet.consumer.rowmapper.utilisateur;

import com.sun.org.apache.regexp.internal.RE;
import fr.oc.projet.consumer.contract.dao.bibliotheque.BibliothequeDao;
import fr.oc.projet.consumer.contract.dao.utilisateur.NiveauAccesDao;
import fr.oc.projet.model.beans.utilisateur.Compte;
import org.springframework.jdbc.core.RowMapper;

import javax.inject.Inject;
import javax.inject.Named;
import java.sql.ResultSet;
import java.sql.SQLException;

@Named
public class CompteRM implements RowMapper<Compte> {

    @Inject
    private NiveauAccesDao niveauAccesDao;
    @Inject
    private BibliothequeDao bibliothequeDao;

    @Override
    public Compte mapRow(ResultSet resultSet, int i) throws SQLException {
        Compte compte = new Compte();
        compte.setId(resultSet.getInt("id"));
        compte.setPseudo(resultSet.getString("pseudo"));
        compte.setNom(resultSet.getString("nom"));
        compte.setPrenom(resultSet.getString("prenom"));
        compte.setEmail(resultSet.getString("email"));
        compte.setMotDePasse(resultSet.getString("mot_de_passe"));
        compte.setNumero(resultSet.getString("numero"));
        compte.setAdresse(resultSet.getString("adresse"));
        compte.setNiveauAcces(niveauAccesDao.getNiveauAcces(resultSet.getInt("niveau_acces_id")));
        compte.setBibliotheque(bibliothequeDao.getBibliotheque(resultSet.getInt("bibliotheque_id")));
        return compte;
    }
}

package fr.oc.projet.consumer.rowmapper.utilisateur;

import fr.oc.projet.consumer.contract.dao.bibliotheque.LivreDao;
import fr.oc.projet.consumer.contract.dao.utilisateur.CompteDao;
import fr.oc.projet.model.beans.utilisateur.Reservation;
import org.springframework.jdbc.core.RowMapper;

import javax.inject.Inject;
import javax.inject.Named;
import java.sql.ResultSet;
import java.sql.SQLException;

@Named
public class ReservationRM implements RowMapper<Reservation> {

    @Inject
    private CompteDao compteDao;
    @Inject
    private LivreDao livreDao;

    @Override
    public Reservation mapRow(ResultSet resultSet, int i) throws SQLException {
        Reservation reservation = new Reservation();
        reservation.setId(resultSet.getInt("id"));
        reservation.setDateDeDebut(resultSet.getDate("date_de_debut"));
        reservation.setDateDeFin(resultSet.getDate("date_de_fin"));
        reservation.setProlonge(resultSet.getBoolean("prolonge"));
        reservation.setCompte(compteDao.getCompte(resultSet.getInt("compte_id")));
        reservation.setLivre(livreDao.getLivre(resultSet.getInt("livre_id")));
        return reservation;
    }
}

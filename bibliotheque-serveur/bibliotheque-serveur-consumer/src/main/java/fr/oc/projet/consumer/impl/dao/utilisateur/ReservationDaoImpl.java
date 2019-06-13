package fr.oc.projet.consumer.impl.dao.utilisateur;

import fr.oc.projet.consumer.contract.dao.utilisateur.ReservationDao;
import fr.oc.projet.consumer.impl.dao.AbstractDaoImpl;
import fr.oc.projet.consumer.rowmapper.utilisateur.ReservationRM;
import fr.oc.projet.model.beans.utilisateur.Reservation;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class ReservationDaoImpl extends AbstractDaoImpl implements ReservationDao {

    @Inject
    private ReservationRM reservationRM;

    @Override
    public Reservation getReservation(Integer pId) {
        String vSQL = "SELECT * FROM reservation WHERE id ="+pId;
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        Reservation reservation = vJdbcTemplate.queryForObject(vSQL,reservationRM);
        return reservation;
    }

    @Override
    public List<Reservation> getListReservation() {
        String vSQL = "SELECT * FROM reservation ";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<Reservation> vList = vJdbcTemplate.query(vSQL,reservationRM);
        return vList;
    }
}

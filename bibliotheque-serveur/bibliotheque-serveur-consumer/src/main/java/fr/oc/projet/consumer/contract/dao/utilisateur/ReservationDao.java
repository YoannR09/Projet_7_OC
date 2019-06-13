package fr.oc.projet.consumer.contract.dao.utilisateur;

import fr.oc.projet.model.beans.utilisateur.Reservation;

import java.util.List;

public interface ReservationDao {

    Reservation getReservation(Integer pId);

    List<Reservation> getListReservation();

}

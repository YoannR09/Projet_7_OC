package fr.oc.projet.business.contract.manager.utilisateur;

import fr.oc.projet.model.beans.utilisateur.Reservation;

import java.util.List;

public interface ReservationManager {

    Reservation getReservation(Integer pId);

    List<Reservation> getListReservation();
}

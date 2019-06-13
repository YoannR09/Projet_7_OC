package fr.oc.projet.business.impl.manager;

import fr.oc.projet.business.contract.manager.ReservationManager;
import fr.oc.projet.business.impl.manager.AbstractManagerImpl;
import fr.oc.projet.model.beans.utilisateur.Reservation;

import javax.inject.Named;
import java.util.List;

@Named
public class ReservationManagerImpl extends AbstractManagerImpl implements ReservationManager {
    @Override
    public Reservation getReservation(Integer pId) {
        return getDaoFactory().getReservationDao().getReservation(pId);
    }

    @Override
    public List<Reservation> getListReservation() {
        return getDaoFactory().getReservationDao().getListReservation();
    }
}

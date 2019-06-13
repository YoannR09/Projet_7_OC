package fr.oc.projet.business.contract;

import fr.oc.projet.business.contract.manager.*;
import fr.oc.projet.business.contract.manager.CompteManager;
import fr.oc.projet.business.contract.manager.NiveauAccesManager;
import fr.oc.projet.business.contract.manager.ReservationManager;

public interface ManagerFactory {

    NiveauAccesManager getNiveauAccesManager();

    CompteManager getCompteManager();

    BibliothequeManager getBibliothequeManager();

    CategorieManager getCategorieManager();

    ImageManager getImageManager();

    LivreManager getLivreManager();

    ReservationManager getReservationManager();

    StockManager getStockManager();
}


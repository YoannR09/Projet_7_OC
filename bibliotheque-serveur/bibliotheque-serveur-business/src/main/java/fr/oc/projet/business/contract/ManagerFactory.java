package fr.oc.projet.business.contract;

import fr.oc.projet.business.contract.manager.bibliotheque.*;
import fr.oc.projet.business.contract.manager.utilisateur.CompteManager;
import fr.oc.projet.business.contract.manager.utilisateur.NiveauAccesManager;
import fr.oc.projet.business.contract.manager.utilisateur.ReservationManager;

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


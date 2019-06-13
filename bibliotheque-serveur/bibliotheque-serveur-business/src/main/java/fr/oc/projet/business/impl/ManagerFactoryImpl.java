package fr.oc.projet.business.impl;

import fr.oc.projet.business.contract.ManagerFactory;
import fr.oc.projet.business.contract.manager.bibliotheque.*;
import fr.oc.projet.business.contract.manager.utilisateur.CompteManager;
import fr.oc.projet.business.contract.manager.utilisateur.NiveauAccesManager;
import fr.oc.projet.business.contract.manager.utilisateur.ReservationManager;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class ManagerFactoryImpl implements ManagerFactory {

    @Inject
    private NiveauAccesManager niveauAccesManager;
    @Inject
    private CompteManager compteManager;
    @Inject
    private BibliothequeManager bibliothequeManager;
    @Inject
    private CategorieManager categorieManager;
    @Inject
    private ImageManager imageManager;
    @Inject
    private LivreManager livreManager;
    @Inject
    private ReservationManager reservationManager;
    @Inject
    private StockManager stockManager;

    @Override
    public NiveauAccesManager getNiveauAccesManager() {
        return this.niveauAccesManager;
    }

    @Override
    public CompteManager getCompteManager() {
        return this.compteManager;
    }

    @Override
    public BibliothequeManager getBibliothequeManager() {
        return this.bibliothequeManager;
    }

    @Override
    public CategorieManager getCategorieManager() {
        return this.categorieManager;
    }

    @Override
    public ImageManager getImageManager() {
        return this.imageManager;
    }

    @Override
    public LivreManager getLivreManager() {
        return this.livreManager;
    }

    @Override
    public ReservationManager getReservationManager() {
        return this.reservationManager;
    }

    @Override
    public StockManager getStockManager() {
        return this.stockManager;
    }
}

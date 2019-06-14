package fr.oc.projet.consumer.impl;

import fr.oc.projet.consumer.contract.DAOFactory;
import fr.oc.projet.consumer.contract.dao.bibliotheque.*;
import fr.oc.projet.consumer.contract.dao.utilisateur.CompteDao;
import fr.oc.projet.consumer.contract.dao.utilisateur.NiveauAccesDao;
import fr.oc.projet.consumer.contract.dao.utilisateur.PretDao;

import javax.inject.Inject;
import javax.inject.Named;

@Named("daoFactoryImpl")
public class DAOFactoryImpl implements DAOFactory {

    @Inject
    private NiveauAccesDao niveauAccesDao;
    @Inject
    private CompteDao compteDao;
    @Inject
    private BibliothequeDao bibliothequeDao;
    @Inject
    private CategorieDao categorieDao;
    @Inject
    private ImageDao imageDao;
    @Inject
    private LivreDao livreDao;
    @Inject
    private PretDao pretDao;
    @Inject
    private StockDao stockDao;



    @Override
    public NiveauAccesDao getNiveauAccesDao() {
        return this.niveauAccesDao;
    }

    @Override
    public CompteDao getCompteDao() {
        return this.compteDao;
    }

    @Override
    public BibliothequeDao getBibliotheque() {
        return bibliothequeDao;
    }

    @Override
    public CategorieDao getCategorieDao() {
        return this.categorieDao;
    }

    @Override
    public ImageDao getImageDao() {
        return this.imageDao;
    }

    @Override
    public LivreDao getLivreDao() {
        return this.livreDao;
    }

    @Override
    public PretDao getPretDao() {
        return this.pretDao;
    }

    @Override
    public StockDao getStockDao() {
        return this.stockDao;
    }
}

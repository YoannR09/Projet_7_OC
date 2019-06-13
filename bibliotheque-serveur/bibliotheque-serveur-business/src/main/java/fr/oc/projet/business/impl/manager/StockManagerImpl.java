package fr.oc.projet.business.impl.manager;

import fr.oc.projet.business.contract.manager.StockManager;
import fr.oc.projet.business.impl.manager.AbstractManagerImpl;
import fr.oc.projet.model.beans.bibliotheque.Stock;

import javax.inject.Named;
import java.util.List;

@Named
public class StockManagerImpl extends AbstractManagerImpl implements StockManager {

    @Override
    public Stock getStock(Integer pId) {
        return getDaoFactory().getStockDao().getStock(pId);
    }

    @Override
    public List<Stock> getListStock() {
        return getDaoFactory().getStockDao().getListStock();
    }
}

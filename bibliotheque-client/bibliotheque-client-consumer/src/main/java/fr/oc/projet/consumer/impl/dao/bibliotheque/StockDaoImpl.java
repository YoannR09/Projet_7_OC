package fr.oc.projet.consumer.impl.dao.bibliotheque;

import fr.oc.projet.consumer.contract.dao.bibliotheque.StockDao;
import fr.oc.projet.consumer.impl.dao.AbstractDaoImpl;
import fr.oc.projet.model.beans.bibliotheque.Stock;

import javax.inject.Named;
import java.util.List;

@Named
public class StockDaoImpl extends AbstractDaoImpl implements StockDao {

    @Override
    public Stock getStock(Integer pId) {
        return null;
    }

    @Override
    public List<Stock> getListStock() {
        return null;
    }
}

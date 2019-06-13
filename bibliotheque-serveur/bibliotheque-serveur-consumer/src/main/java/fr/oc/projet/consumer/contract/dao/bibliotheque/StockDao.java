package fr.oc.projet.consumer.contract.dao.bibliotheque;

import fr.oc.projet.model.beans.bibliotheque.Stock;

import java.util.List;

public interface StockDao {

    Stock getStock(Integer pId);

    List<Stock> getListStock();

}

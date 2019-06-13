package fr.oc.projet.consumer.rowmapper.bibliotheque;

import fr.oc.projet.consumer.contract.dao.bibliotheque.BibliothequeDao;
import fr.oc.projet.consumer.contract.dao.bibliotheque.LivreDao;
import fr.oc.projet.model.beans.bibliotheque.Stock;
import org.springframework.jdbc.core.RowMapper;

import javax.inject.Inject;
import javax.inject.Named;
import java.sql.ResultSet;
import java.sql.SQLException;

@Named
public class StockRM implements RowMapper<Stock> {

    @Inject
    LivreDao livreDao;
    @Inject
    BibliothequeDao bibliothequeDao;

    @Override
    public Stock mapRow(ResultSet resultSet, int i) throws SQLException {
        Stock stock = new Stock();
        stock.setId(resultSet.getInt("id"));
        stock.setQuantite(resultSet.getInt("quantite"));
        stock.setLivre(livreDao.getLivre(resultSet.getInt("livre_id")));
        stock.setBibliotheque(bibliothequeDao.getBibliotheque(resultSet.getInt("bibliotheque_id")));
        return stock;
    }
}

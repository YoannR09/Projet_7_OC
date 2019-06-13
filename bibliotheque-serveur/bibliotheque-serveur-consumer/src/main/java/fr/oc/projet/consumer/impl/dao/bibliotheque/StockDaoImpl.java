package fr.oc.projet.consumer.impl.dao.bibliotheque;

import fr.oc.projet.consumer.contract.dao.bibliotheque.StockDao;
import fr.oc.projet.consumer.impl.dao.AbstractDaoImpl;
import fr.oc.projet.consumer.rowmapper.bibliotheque.StockRM;
import fr.oc.projet.model.beans.bibliotheque.Stock;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class StockDaoImpl extends AbstractDaoImpl implements StockDao {

    @Inject
    StockRM stockRM;

    @Override
    public Stock getStock(Integer pId) {
        String vSQL = "SELECT * FROM stock WHERE id ="+pId;
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        Stock stock = vJdbcTemplate.queryForObject(vSQL,stockRM);
        return stock;
    }

    @Override
    public List<Stock> getListStock() {
        String vSQL = "SELECT * FROM stock ";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<Stock> vList = vJdbcTemplate.query(vSQL,stockRM);
        return vList;
    }
}

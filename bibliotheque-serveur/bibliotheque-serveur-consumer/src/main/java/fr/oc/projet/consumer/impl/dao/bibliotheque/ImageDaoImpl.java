package fr.oc.projet.consumer.impl.dao.bibliotheque;

import fr.oc.projet.consumer.contract.dao.bibliotheque.ImageDao;
import fr.oc.projet.consumer.impl.dao.AbstractDaoImpl;
import fr.oc.projet.consumer.rowmapper.bibliotheque.ImageRM;
import fr.oc.projet.model.beans.bibliotheque.Image;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class ImageDaoImpl extends AbstractDaoImpl implements ImageDao {

    @Inject
    ImageRM imageRM;

    @Override
    public Image getImage(Integer pId) {
        String vSQL = "SELECT * FROM image WHERE id ="+pId;
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        Image image = vJdbcTemplate.queryForObject(vSQL,imageRM);
        return image;
    }

    @Override
    public List<Image> getListImage() {
        String vSQL = "SELECT * FROM image ";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<Image> vList = vJdbcTemplate.query(vSQL,imageRM);
        return vList;
    }
}

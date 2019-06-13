package fr.oc.projet.consumer.rowmapper.bibliotheque;

import fr.oc.projet.model.beans.bibliotheque.Image;
import org.springframework.jdbc.core.RowMapper;

import javax.inject.Named;
import java.sql.ResultSet;
import java.sql.SQLException;

@Named
public class ImageRM implements RowMapper<Image> {

    @Override
    public Image mapRow(ResultSet resultSet, int i) throws SQLException {
        Image image = new Image();
        image.setId(resultSet.getInt("id"));
        image.setUrl(resultSet.getString("url"));
        image.setDescription(resultSet.getString("description"));
        return image;
    }
}

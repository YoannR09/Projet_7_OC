package fr.oc.projet.consumer.rowmapper.bibliotheque;

import fr.oc.projet.consumer.contract.dao.bibliotheque.CategorieDao;
import fr.oc.projet.consumer.contract.dao.bibliotheque.ImageDao;
import fr.oc.projet.model.beans.bibliotheque.Livre;
import org.springframework.jdbc.core.RowMapper;

import javax.inject.Inject;
import javax.inject.Named;
import java.sql.ResultSet;
import java.sql.SQLException;

@Named
public class LivreRM implements RowMapper<Livre> {

    @Inject
    CategorieDao categorieDao;
    @Inject
    ImageDao imageDao;

    @Override
    public Livre mapRow(ResultSet resultSet, int i) throws SQLException {
        Livre livre = new Livre();
        livre.setId(resultSet.getInt("id"));
        livre.setAuteur(resultSet.getString("auteur"));
        livre.setEditeur(resultSet.getString("editeur"));
        livre.setResume(resultSet.getString("resume"));
        livre.setDateDeCreation(resultSet.getDate("date_de_creation"));
        livre.setIsbn(resultSet.getString("isbn"));
        livre.setNom(resultSet.getString("nom"));
        livre.setLangue(resultSet.getString("langue"));
        livre.setImage(imageDao.getImage(resultSet.getInt("image_id")));
        livre.setCategorie(categorieDao.getCategorie(resultSet.getInt("categorie_id")));
        return livre;
    }
}

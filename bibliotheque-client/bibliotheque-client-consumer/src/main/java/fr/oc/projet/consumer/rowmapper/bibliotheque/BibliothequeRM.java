package fr.oc.projet.consumer.rowmapper.bibliotheque;

import fr.oc.projet.model.beans.bibliotheque.Bibliotheque;
import org.springframework.jdbc.core.RowMapper;

import javax.inject.Named;
import java.sql.ResultSet;
import java.sql.SQLException;

@Named
public class BibliothequeRM implements RowMapper<Bibliotheque> {

    @Override
    public Bibliotheque mapRow(ResultSet resultSet, int i) throws SQLException {
        Bibliotheque bibliotheque = new Bibliotheque();
        bibliotheque.setId(resultSet.getInt("id"));
        bibliotheque.setNom(resultSet.getString("nom"));
        bibliotheque.setAdresse(resultSet.getString("adresse"));
        bibliotheque.setNumeroSiret(resultSet.getString("numero_siret"));
        return bibliotheque;
    }
}

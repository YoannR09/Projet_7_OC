package fr.oc.projet.consumer.impl.dao.bibliotheque;

import fr.oc.projet.consumer.contract.dao.bibliotheque.LivreUniqueDao;
import fr.oc.projet.consumer.impl.dao.AbstractDaoImpl;
import fr.oc.projet.consumer.rowmapper.bibliotheque.LivreUniqueRM;
import fr.oc.projet.model.beans.bibliotheque.Livre;
import fr.oc.projet.model.beans.bibliotheque.LivreUnique;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class LivreUniqueDaoImpl extends AbstractDaoImpl implements LivreUniqueDao {

    @Inject
    LivreUniqueRM livreUniqueRM;

    @Override
    public LivreUnique getLivreUnique(Integer pId) {
        String vSQL = "SELECT * FROM livre_unique WHERE id ="+pId;
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        LivreUnique livreUnique = vJdbcTemplate.queryForObject(vSQL,livreUniqueRM);
        return livreUnique;
    }

    @Override
    public List<LivreUnique> getListLivreUniqueTitreAuteurISBN(String titre, String auteur, String isbn) {
        String vSQL = "SELECT * FROM livre_unique,livre WHERE livre.nom LIKE "+"'"+titre+"'" +
                " AND auteur LIKE "+"'"+auteur+"'" +
                " AND isbn LIKE "+"'"+isbn+"'" +
                " AND livre.id = livre_unique.livre_id" ;
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<LivreUnique> vList = vJdbcTemplate.query(vSQL, livreUniqueRM);
        return vList;
    }

    @Override
    public List<LivreUnique> getListLivreUniqueTitreAuteur(String titre, String auteur) {
        String vSQL = "SELECT * FROM livre_unique,livre WHERE livre.nom LIKE "+"'"+titre+"'" +
                " AND auteur LIKE "+"'"+auteur+"'" +
                " AND livre.id = livre_unique.livre_id" ;
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<LivreUnique> vList = vJdbcTemplate.query(vSQL, livreUniqueRM);
        return vList;
    }

    @Override
    public List<LivreUnique> getListLivreUniqueAuteurISBN(String auteur, String isbn) {
        String vSQL = "SELECT * FROM livre_unique,livre WHERE "+
                " auteur LIKE "+"'"+auteur+"'" +
                " AND isbn LIKE "+"'"+isbn+"'" +
                " AND livre.id = livre_unique.livre_id" ;
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<LivreUnique> vList = vJdbcTemplate.query(vSQL, livreUniqueRM);
        return vList;
    }

    @Override
    public List<LivreUnique> getListLivreUniqueTitreISBN(String titre, String isbn) {
        String vSQL = "SELECT * FROM livre_unique,livre WHERE livre.nom LIKE "+"'"+titre+"'" +
                " AND isbn LIKE "+"'"+isbn+"'" +
                " AND livre.id = livre_unique.livre_id" ;
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<LivreUnique> vList = vJdbcTemplate.query(vSQL, livreUniqueRM);
        return vList;
    }

    @Override
    public List<LivreUnique> getListLivreUniqueTitre(String titre) {
        String vSQL = "SELECT * FROM livre_unique,livre WHERE livre.nom LIKE "+"'"+titre+"'" +
                " AND livre.id = livre_unique.livre_id" ;
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<LivreUnique> vList = vJdbcTemplate.query(vSQL, livreUniqueRM);
        return vList;
    }

    @Override
    public List<LivreUnique> getListLivreUniqueAuteur(String auteur) {
        String vSQL = "SELECT * FROM livre_unique,livre WHERE " +
                " auteur LIKE "+"'"+auteur+"'" +
                " AND livre.id = livre_unique.livre_id" ;
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<LivreUnique> vList = vJdbcTemplate.query(vSQL, livreUniqueRM);
        return vList;
    }

    @Override
    public List<LivreUnique> getListLivreUniqueISBN(String isbn) {
        String vSQL = "SELECT * FROM livre_unique,livre WHERE "+
                " isbn LIKE "+"'"+isbn+"'" +
                " AND livre.id = livre_unique.livre_id" ;
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<LivreUnique> vList = vJdbcTemplate.query(vSQL, livreUniqueRM);
        return vList;
    }

    @Override
    public List<LivreUnique> getListLivreUniqueTitreAuteurISBNBibliotheque(String titre, String auteur, String isbn, Integer bibliothequeId) {
        String vSQL = "SELECT * FROM livre_unique,livre WHERE livre.nom LIKE "+"'"+titre+"'" +
                " AND auteur LIKE "+"'"+auteur+"'" +
                " AND isbn LIKE "+"'"+isbn+"'" +
                " AND livre.id = livre_unique.livre_id " +
                " AND bibliotheque_id = "+ bibliothequeId;
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<LivreUnique> vList = vJdbcTemplate.query(vSQL, livreUniqueRM);
        return vList;
    }

    @Override
    public List<LivreUnique> getListLivreUniqueTitreAuteurBibliotheque(String titre, String auteur,  Integer bibliothequeId) {
        String vSQL = "SELECT * FROM livre_unique,livre WHERE livre.nom LIKE "+"'"+titre+"'" +
                " AND auteur LIKE "+"'"+auteur+"'" +
                " AND livre.id = livre_unique.livre_id " +
                " AND bibliotheque_id = "+ bibliothequeId;
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<LivreUnique> vList = vJdbcTemplate.query(vSQL, livreUniqueRM);
        return vList;
    }

    @Override
    public List<LivreUnique> getListLivreUniqueAuteurISBNBibliotheque(String auteur, String isbn,  Integer bibliothequeId) {
        String vSQL = "SELECT * FROM livre_unique,livre WHERE "+
                " auteur LIKE "+"'"+auteur+"'" +
                " AND isbn LIKE "+"'"+isbn+"'" +
                " AND livre.id = livre_unique.livre_id " +
                " AND bibliotheque_id = "+ bibliothequeId;
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<LivreUnique> vList = vJdbcTemplate.query(vSQL, livreUniqueRM);
        return vList;
    }

    @Override
    public List<LivreUnique> getListLivreUniqueTitreISBNBibliotheque(String titre, String isbn, Integer bibliothequeId) {
        String vSQL = "SELECT * FROM livre_unique,livre WHERE livre.nom LIKE "+"'"+titre+"'" +
                " AND isbn LIKE "+"'"+isbn+"'" +
                " AND livre.id = livre_unique.livre_id " +
                " AND bibliotheque_id = "+ bibliothequeId;
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<LivreUnique> vList = vJdbcTemplate.query(vSQL, livreUniqueRM);
        return vList;
    }

    @Override
    public List<LivreUnique> getListLivreUniqueTitreBibliotheque(String titre, Integer bibliothequeId) {
        String vSQL = "SELECT * FROM livre_unique,livre WHERE livre.nom LIKE "+"'"+titre+"'" +
                " AND livre.id = livre_unique.livre_id " +
                " AND bibliotheque_id = "+ bibliothequeId;
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<LivreUnique> vList = vJdbcTemplate.query(vSQL, livreUniqueRM);
        return vList;
    }

    @Override
    public List<LivreUnique> getListLivreUniqueAuteurBibliotheque(String auteur,  Integer bibliothequeId) {
        String vSQL = "SELECT * FROM livre_unique,livre WHERE "+
                " auteur LIKE "+"'"+auteur+"'" +
                " AND livre.id = livre_unique.livre_id " +
                " AND bibliotheque_id = "+ bibliothequeId;
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<LivreUnique> vList = vJdbcTemplate.query(vSQL, livreUniqueRM);
        return vList;
    }

    @Override
    public List<LivreUnique> getListLivreUniqueISBNBibliotheque(String isbn,  Integer bibliothequeId) {
        String vSQL = "SELECT * FROM livre_unique,livre WHERE "+
                " isbn LIKE "+"'"+isbn+"'" +
                " AND livre.id = livre_unique.livre_id " +
                " AND bibliotheque_id = "+ bibliothequeId;
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<LivreUnique> vList = vJdbcTemplate.query(vSQL, livreUniqueRM);
        return vList;
    }


    @Override
    public List<LivreUnique> getListLivreUnique() {
        String vSQL = "SELECT * FROM livre_unique ";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<LivreUnique> vList = vJdbcTemplate.query(vSQL,livreUniqueRM);
        return vList;
    }
}

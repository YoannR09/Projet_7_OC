package fr.oc.projet.consumer.impl.dao.utilisateur;

import fr.oc.projet.consumer.contract.dao.utilisateur.CompteDao;
import fr.oc.projet.consumer.impl.dao.AbstractDaoImpl;
import fr.oc.projet.model.beans.utilisateur.Compte;


import javax.inject.Inject;
import javax.inject.Named;
import java.sql.Types;


/**
 * Class qui gère les données des comptes.
 * On peut récupérer un compte via pseudo/id,
 * Récupérer la liste des comptes dans la base de données,
 * Ajouter un compte dans la base de données.
 */
@Named
public class CompteDaoImpl extends AbstractDaoImpl implements CompteDao {



    @Override
    public Compte getCompte(Integer pId) {
        return null;
    }

    @Override
    public Compte getComptePseudo(String pseudo) {
        return null;
    }

    @Override
    public void addCompte(Compte compte) {

    }

    @Override
    public void updateMpd(Compte compte) {

    }

    @Override
    public void updateMail(Compte compte) {

    }
}

package fr.oc.projet.consumer.contract.dao.utilisateur;

import fr.oc.projet.model.beans.utilisateur.NiveauAcces;

import java.util.List;

public interface NiveauAccesDao {

    NiveauAcces getNiveauAcces(Integer pId);

    List<NiveauAcces> getListNiveauAcces();
}

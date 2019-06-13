package fr.oc.projet.business.contract.manager.utilisateur;

import fr.oc.projet.model.beans.utilisateur.NiveauAcces;

import java.util.List;

public interface NiveauAccesManager {

    NiveauAcces getNiveauAcces(Integer pId);

    List<NiveauAcces> getListNiveauAcces();
}

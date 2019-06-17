package fr.oc.projet.business.contract.manager.bibliotheque;

import fr.oc.projet.model.beans.bibliotheque.LivreUnique;

import java.util.List;


public interface LivreUniqueManager {
    LivreUnique getLivreUnique(Integer pId);
    List<LivreUnique> getListLivreUnique();
}

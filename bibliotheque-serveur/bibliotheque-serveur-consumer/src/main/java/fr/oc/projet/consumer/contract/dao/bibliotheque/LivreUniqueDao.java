package fr.oc.projet.consumer.contract.dao.bibliotheque;

import fr.oc.projet.model.beans.bibliotheque.LivreUnique;

import java.util.List;

public interface LivreUniqueDao {

    LivreUnique getLivreUnique(Integer pId);

    List<LivreUnique> getListLivreUnique();
}

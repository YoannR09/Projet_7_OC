package fr.oc.projet.consumer.contract.dao.bibliotheque;

import fr.oc.projet.model.beans.bibliotheque.Livre;

import java.util.List;

public interface LivreDao {

    Livre getLivre(Integer pId);

    List<Livre> getListLivre();

}

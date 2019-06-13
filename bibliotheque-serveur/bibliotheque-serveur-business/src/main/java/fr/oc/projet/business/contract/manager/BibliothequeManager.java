package fr.oc.projet.business.contract.manager;

import fr.oc.projet.model.beans.bibliotheque.Bibliotheque;

import java.util.List;

public interface BibliothequeManager {

    Bibliotheque getBibliotheque(Integer pId);
    List<Bibliotheque> getListBibliotheque();

}

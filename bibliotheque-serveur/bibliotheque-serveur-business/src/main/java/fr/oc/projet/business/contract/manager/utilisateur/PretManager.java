package fr.oc.projet.business.contract.manager.utilisateur;

import fr.oc.projet.model.beans.utilisateur.Pret;

import java.util.List;

public interface PretManager {

    Pret getPret(Integer pId);

    List<Pret> getListPret();

    List<Pret> getListPretLivre(Integer livreId);

    List<Pret> getListPretAbonne(Integer abonneId);

    void updateProlongation(Pret pret);

    void updateDateRestitution(Pret pret);
}

package fr.oc.projet.consumer.contract.dao.utilisateur;

import fr.oc.projet.model.beans.utilisateur.Pret;

import java.util.List;

public interface PretDao {

    Pret getPret(Integer pId);

    List<Pret> getListPret();

    List<Pret> getListPretLivre(Integer livreId);

    List<Pret> getListPretAbonne(Integer abonneId);

    List<Pret> getListPretLivreBibliotheque(Integer livreId,Integer bibliothequeId);

    List<Pret> getListPretAbonneBibliotheque(Integer abonneId,Integer bibliothequeId);

    void updateProlongation(Pret pret);

    void updateDateRestitution(Pret pret);

    void deletePret(Integer idPret);

    void addPret(Pret pret);

}

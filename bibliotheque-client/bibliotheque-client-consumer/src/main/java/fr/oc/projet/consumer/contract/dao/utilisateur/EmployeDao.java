package fr.oc.projet.consumer.contract.dao.utilisateur;

import fr.oc.projet.model.beans.utilisateur.Employe;

import java.util.List;

public interface EmployeDao {

    Employe getEmploye(Integer pId);

    List<Employe> getListEmploye();
}

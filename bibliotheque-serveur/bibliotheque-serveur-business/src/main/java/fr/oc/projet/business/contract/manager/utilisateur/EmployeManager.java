package fr.oc.projet.business.contract.manager.utilisateur;

import fr.oc.projet.model.beans.utilisateur.Employe;

import java.util.List;

public interface EmployeManager {

    Employe getEmploye(Integer pId);

    List<Employe> getListEmploye();
}

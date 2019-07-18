package fr.oc.projet.webapp.action;

import com.opensymphony.xwork2.ActionSupport;
import fr.oc.projet.business.contract.ManagerFactory;
import fr.oc.projet.model.beans.utilisateur.Employe;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;

import javax.inject.Inject;
import java.util.Map;

public class LoginAction extends ActionSupport implements SessionAware {

    private         Map<String, Object> session;
    private         String              motDePasse;
    private         Employe             employe;
    private         String              identifiant;

    @Inject
    ManagerFactory managerFactory;

    public String doLogin(){

            String vResult;

            if (identifiant != null) {
                employe = managerFactory.getEmployeManager().getEmployeEmail(identifiant);
            }
            if (employe == null) {
                this.addActionMessage("Identifiant invalide");
                vResult = ActionSupport.ERROR;
            }
            else {
                if (motDePasse.equals(employe.getMotDePasse())) {
                    this.session.put("user", employe);
                    this.session.put("email", employe.getEmail());
                    this.session.put("role", employe.getRole());
                    vResult = ActionSupport.SUCCESS;
                } else {
                    this.addActionMessage("Mot de passe invalide");
                    vResult = ActionSupport.ERROR;
                }
            }
            return vResult;
        }

    public String doLogout(){

        this.session.remove("user");
        this.session.remove("pseudo");
        this.session.remove("role");

        return ActionSupport.SUCCESS;
    }



    @Override
    public void setSession(Map<String, Object> map) {
         this.session= map;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public Employe getEmploye() {
        return employe;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }
}

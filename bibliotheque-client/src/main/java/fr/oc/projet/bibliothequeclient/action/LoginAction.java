package fr.oc.projet.bibliothequeclient.action;

import com.opensymphony.xwork2.ActionSupport;
import fr.oc.projet.bibliothequeclient.beans.Abonne;
import fr.oc.projet.bibliothequeclient.proxies.MicroServiceAbonneProxy;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class LoginAction extends ActionSupport implements SessionAware {

    // ----- Eléments Struts

    private Map<String, Object> session;

    @Autowired
    private MicroServiceAbonneProxy microServiceAbonneProxy;


    private String email;
    private String identifiant;
    private String motDePasse;
    private Abonne abonne;

    public String doLogin() {

        if (identifiant != null) {
            abonne = microServiceAbonneProxy.getAbonnePseudo(identifiant);
            if (abonne == null) {
                abonne = microServiceAbonneProxy.getAbonneEmail(identifiant);
            }
        }

        if (abonne == null) {
            this.addActionMessage("Identifiant invalide");
        }
        else

        {
            if (motDePasse.equals(abonne.getMotDePasse())) {
                this.session.put("user", abonne);
                this.session.put("pseudo", abonne.getPseudo());
                this.session.put("niveau", abonne.getRole());
            } else {
                this.addActionMessage("Identifiant invalide");
            }
        }
        return ActionSupport.SUCCESS;
    }




    @Override
    public void setSession(Map<String, Object> map) {
        this.session = map;
    }

    public Map<String, Object> getSession() {
        return session;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public Abonne getAbonne() {
        return abonne;
    }

    public void setAbonne(Abonne abonne) {
        this.abonne = abonne;
    }
}

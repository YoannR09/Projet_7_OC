package fr.oc.projet.bibliothequeclient.action;

import com.opensymphony.xwork2.ActionSupport;
import fr.oc.projet.bibliothequeclient.beans.Abonne;
import fr.oc.projet.bibliothequeclient.beans.Categorie;
import fr.oc.projet.bibliothequeclient.proxies.MicroServiceAbonneProxy;
import fr.oc.projet.bibliothequeclient.proxies.MicroServiceCategorieProxy;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class LoginAction extends ActionSupport implements SessionAware {

    // ----- Eléments Struts

    private Map<String, Object> session;

    @Autowired
    private MicroServiceAbonneProxy microServiceAbonneProxy;
    @Autowired
    private MicroServiceCategorieProxy microServiceCategorieProxy;

    private Categorie categorie;
    private List<Categorie> categorieList;
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
                this.session.put("role", abonne.getRole());
                categorieList = microServiceCategorieProxy.getListCategorie();
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

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public List<Categorie> getCategorieList() {
        return categorieList;
    }

    public void setCategorieList(List<Categorie> categorieList) {
        this.categorieList = categorieList;
    }
}

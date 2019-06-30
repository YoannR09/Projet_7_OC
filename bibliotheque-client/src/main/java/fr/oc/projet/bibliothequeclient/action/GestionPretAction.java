package fr.oc.projet.bibliothequeclient.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import fr.oc.projet.bibliothequeclient.beans.Abonne;
import fr.oc.projet.bibliothequeclient.beans.Pret;
import fr.oc.projet.bibliothequeclient.proxies.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GestionPretAction extends ActionSupport {

    @Autowired
    MicroServiceAbonneProxy microServiceAbonneProxy;
    @Autowired
    MicroServiceLivreProxy microServiceLivreProxy;
    @Autowired
    MicroServicePretProxy microServicePretProxy;
    @Autowired
    MicroServiceLivreUniqueProxy microServiceLivreUniqueProxy;
    @Autowired
    MicroServiceBibliothequeProxy microServiceBibliothequeProxy;

    private String pseudo;
    private Abonne abonne;
    private List<Pret> pretList;
    private Integer countResultat;

    public String doListPret(){
        pseudo = (String) ActionContext.getContext().getSession().get("pseudo");
        abonne = microServiceAbonneProxy.getAbonnePseudo(pseudo);
        pretList = microServicePretProxy.getListPretAbonne(abonne.getId());
        for(Pret pret: pretList){
            pret.setLivre(microServiceLivreProxy.getLivre(microServiceLivreUniqueProxy.findById(pret.getLivreUniqueId()).getLivreId()));
            pret.setLivreUnique(microServiceLivreUniqueProxy.findById(pret.getLivreUniqueId()));
            pret.setBibliotheque(microServiceBibliothequeProxy.getBibliotheque(microServiceLivreUniqueProxy.findById(pret.getLivreUniqueId()).getBibliothequeId()));
        }
        return ActionSupport.SUCCESS;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public Abonne getAbonne() {
        return abonne;
    }

    public void setAbonne(Abonne abonne) {
        this.abonne = abonne;
    }

    public List<Pret> getPretList() {
        return pretList;
    }

    public void setPretList(List<Pret> pretList) {
        this.pretList = pretList;
    }

    public Integer getCountResultat() {
        return countResultat;
    }

    public void setCountResultat(Integer countResultat) {
        this.countResultat = countResultat;
    }
}

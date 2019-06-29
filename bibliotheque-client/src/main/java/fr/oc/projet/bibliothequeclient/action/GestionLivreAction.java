package fr.oc.projet.bibliothequeclient.action;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import fr.oc.projet.bibliothequeclient.beans.Categorie;
import fr.oc.projet.bibliothequeclient.beans.Illustration;
import fr.oc.projet.bibliothequeclient.beans.Livre;
import fr.oc.projet.bibliothequeclient.proxies.MicroServiceCategorieProxy;
import fr.oc.projet.bibliothequeclient.proxies.MicroServiceIllustrationProxy;
import fr.oc.projet.bibliothequeclient.proxies.MicroServiceLivreProxy;
import fr.oc.projet.bibliothequeclient.proxies.MicroServiceLivreUniqueProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

@Component
public class GestionLivreAction extends ActionSupport {

    @Autowired
    private MicroServiceLivreProxy microServiceLivreProxy;
    @Autowired
    private MicroServiceLivreUniqueProxy microServiceLivreUniqueProxy;
    @Autowired
    private MicroServiceIllustrationProxy microServiceIllustrationProxy;
    @Autowired
    private MicroServiceCategorieProxy microServiceCategorieProxy;

    private String titre;
    private String auteur;
    private String isbn;
    private String recherche;
    private Integer livreId;
    private List<Livre> livreList;
    private Livre livre;
    private Illustration illustration;
    private Categorie categorie;
    private HashMap<Livre,Integer> livreIntegerHashMap;

    public String doListLivre(){

        if(!titre.equals("") && !auteur.equals("") && !isbn.equals("")){
            livreList = microServiceLivreProxy.findLivresByTitreAndAuteurAndIsbn(titre,auteur,isbn);
        }else if (titre.equals("") && !auteur.equals("") && !isbn.equals("")){
            livreList = microServiceLivreProxy.findLivresByAuteurContainingAndIsbnContaining(auteur,isbn);
        }else if (!titre.equals("") && !auteur.equals("") && isbn.equals("")){
            livreList = microServiceLivreProxy.findLivresByTitreContainingAndAuteurContaining(titre,auteur);
        }else if (!titre.equals("") && auteur.equals("") && !isbn.equals("")){
            livreList = microServiceLivreProxy.findLivresByTitreContainingAndIsbnContaining(titre,isbn);
        }else if (!titre.equals("") && auteur.equals("") && isbn.equals("")){
            livreList = microServiceLivreProxy.findLivresByTitreContaining(titre);
        }else if (titre.equals("") && !auteur.equals("") && isbn.equals("")){
            livreList = microServiceLivreProxy.findLivresByAuteurContaining(auteur);
        }else if (titre.equals("") && auteur.equals("") && !isbn.equals("")){
            livreList = microServiceLivreProxy.findLivresByIsbnContaining(isbn);
        }
        for (Livre livre : livreList) {
            if(recherche.equals("Toutes les bibliothèques")) {
                livre.setNbreDispo(microServiceLivreUniqueProxy.countLivreUniqueDisponible(livre.getId()));
            }else {
                livre.setNbreDispo(microServiceLivreUniqueProxy.countLivreUniqueBibliothequeDisponible(livre.getId(),1));
            }
        }
        return Action.SUCCESS;
    }

    public String doDetailLivre(){

        livre = microServiceLivreProxy.getLivre(livreId);
        categorie = microServiceCategorieProxy.getCategorie(livre.getCategorieId());
        illustration = microServiceIllustrationProxy.getIllustration(livre.getIllustrationId());

        return Action.SUCCESS;
    }


    public HashMap<Livre, Integer> getLivreIntegerHashMap() {
        return livreIntegerHashMap;
    }

    public void setLivreIntegerHashMap(HashMap<Livre, Integer> livreIntegerHashMap) {
        this.livreIntegerHashMap = livreIntegerHashMap;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public List<Livre> getLivreList() {
        return livreList;
    }

    public void setLivreList(List<Livre> livreList) {
        this.livreList = livreList;
    }

    public Integer getLivreId() {
        return livreId;
    }

    public void setLivreId(Integer livreId) {
        this.livreId = livreId;
    }

    public Livre getLivre() {
        return livre;
    }

    public void setLivre(Livre livre) {
        this.livre = livre;
    }

    public Illustration getIllustration() {
        return illustration;
    }

    public void setIllustration(Illustration illustration) {
        this.illustration = illustration;
    }

    public String getRecherche() {
        return recherche;
    }

    public void setRecherche(String recherche) {
        this.recherche = recherche;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }
}

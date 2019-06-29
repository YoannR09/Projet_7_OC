package fr.oc.projet.bibliothequeclient.beans;


import java.util.Date;

public class Livre {


    private int id;

    private String titre;

    private String auteur;

    private String editeur;

    private String isbn;

    private String langue;

    private String resume;

    private int categorieId;

    private Date dateDeCreation;

    private int illustrationId;

    private int nbreDispo;

    public Livre() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getEditeur() {
        return editeur;
    }

    public void setEditeur(String editeur) {
        this.editeur = editeur;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getLangue() {
        return langue;
    }

    public void setLangue(String langue) {
        this.langue = langue;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public int getCategorieId() {
        return categorieId;
    }

    public void setCategorieId(int categorieId) {
        this.categorieId = categorieId;
    }

    public int getIllustrationId() {
        return illustrationId;
    }

    public void setIllustrationId(int illustrationId) {
        this.illustrationId = illustrationId;
    }

    public int getNbreDispo() {
        return nbreDispo;
    }

    public void setNbreDispo(int nbreDispo) {
        this.nbreDispo = nbreDispo;
    }

    public Date getDateDeCreation() {
        return dateDeCreation;
    }

    public void setDateDeCreation(Date dateDeCreation) {
        this.dateDeCreation = dateDeCreation;
    }

    @Override
    public String toString() {
        return "Livre{" +
                "id=" + id +
                ", titre='" + titre + '\'' +
                ", auteur='" + auteur + '\'' +
                ", editeur='" + editeur + '\'' +
                ", isbn='" + isbn + '\'' +
                ", langue='" + langue + '\'' +
                ", resume='" + resume + '\'' +
                ", categorieId=" + categorieId +
                ", dateDeCreation=" + dateDeCreation +
                ", illustrationId=" + illustrationId +
                ", nbreDispo=" + nbreDispo +
                '}';
    }
}

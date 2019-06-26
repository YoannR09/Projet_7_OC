package fr.oc.projet.microserviceabonne.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Abonne {

    @Id
    @GeneratedValue
    private int id;

    private String pseudo;

    private String email;

    private String motDePasse;

    private String nom;

    private String prenom;

    private String numeroTelephone;

    private int adresseId;

    private int roleId;

    private int bibliothequeId;

    public Abonne() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNumeroTelephone() {
        return numeroTelephone;
    }

    public void setNumeroTelephone(String numeroTelephone) {
        this.numeroTelephone = numeroTelephone;
    }

    public int getAdresseId() {
        return adresseId;
    }

    public void setAdresseId(int adresseId) {
        this.adresseId = adresseId;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public int getBibliothequeId() {
        return bibliothequeId;
    }

    public void setBibliothequeId(int bibliothequeId) {
        this.bibliothequeId = bibliothequeId;
    }

    @Override
    public String toString() {
        return "Abonne{" +
                "id=" + id +
                ", pseudo='" + pseudo + '\'' +
                ", email='" + email + '\'' +
                ", motDePasse='" + motDePasse + '\'' +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", numeroTelephone='" + numeroTelephone + '\'' +
                ", adresseId=" + adresseId +
                ", roleId=" + roleId +
                ", bibliothequeId=" + bibliothequeId +
                '}';
    }
}

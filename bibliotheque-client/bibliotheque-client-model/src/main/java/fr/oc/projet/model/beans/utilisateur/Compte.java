package fr.oc.projet.model.beans.utilisateur;

import fr.oc.projet.model.beans.bibliotheque.Bibliotheque;

public class Compte {


    private         Integer             id;
    private         String              pseudo;
    private         String              nom;
    private         String              prenom;
    private         String              email;
    private         String              numero;
    private         String              motDePasse;
    private         String              adresse;
    private         NiveauAcces         niveauAcces;
    private         Bibliotheque        bibliotheque;

    public Compte() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }


    public NiveauAcces getNiveauAcces() {
        return niveauAcces;
    }

    public void setNiveauAcces(NiveauAcces niveauAcces) {
        this.niveauAcces = niveauAcces;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Bibliotheque getBibliotheque() {
        return bibliotheque;
    }

    public void setBibliotheque(Bibliotheque bibliotheque) {
        this.bibliotheque = bibliotheque;
    }
}

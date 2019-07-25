package fr.oc.projet.bibliothequeclient.beans;


public class LivreUnique {


    private int id;
    private int numeroInterne;
    private int bibliothequeId;
    private int livreId;
    private Boolean disponible;

    public LivreUnique() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumeroInterne() {
        return numeroInterne;
    }

    public void setNumeroInterne(int numeroInterne) {
        this.numeroInterne = numeroInterne;
    }

    public int getBibliothequeId() {
        return bibliothequeId;
    }

    public void setBibliothequeId(int bibliothequeId) {
        this.bibliothequeId = bibliothequeId;
    }

    public int getLivreId() {
        return livreId;
    }

    public void setLivreId(int livreId) {
        this.livreId = livreId;
    }

    public Boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(Boolean disponible) {
        this.disponible = disponible;
    }

    @Override
    public String toString() {
        return "LivreUnique{" +
                "id=" + id +
                ", numeroInterne=" + numeroInterne +
                ", bibliothequeId=" + bibliothequeId +
                ", livreId=" + livreId +
                ", disponible=" + disponible +
                '}';
    }
}

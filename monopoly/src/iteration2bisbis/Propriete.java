package iteration2bisbis;

public abstract class Propriete extends Case {

    private int tarifAchat;
    private Joueur proprietaire;

    public Propriete(String nom, int tarif, Joueur proprietaire) {
        super(nom);
        setTarifAchat(tarif);
        setProprietaire(proprietaire);
    }

    public Propriete(String nom, int tarif) {
        this(nom, tarif, null);
    }

    @Override
    public String toString() {
        return nom.toUpperCase() + " [tarif=" + tarifAchat
                + ", proprietaire=" + proprietaire
                + "]";
    }

    public int getTarifAchat() {
        return tarifAchat;
    }

    private void setTarifAchat(int tarif) {
        if (tarif < 0) {
            throw new IllegalArgumentException("Le tarif doit être positif");
        }
        this.tarifAchat = tarif;
    }

    public Joueur getProprietaire() {
        return proprietaire;
    }

    public void setProprietaire(Joueur proprietaire) {
        this.proprietaire = proprietaire;
    }

}

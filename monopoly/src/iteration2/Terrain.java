package iteration2;

public abstract class Terrain extends Case {

    private GroupeTerrain groupe;
    private int tarif;
    private Joueur proprietaire;

    public Terrain(String nom, int position, GroupeTerrain groupe, int tarif) {
        super(nom, position);
        this.groupe = groupe;
        setTarif(tarif);
    }

    @Override
    public String toString() {
        return this.nom.toUpperCase();
    }

    public GroupeTerrain getGroupe() {
        return groupe;
    }

    public int getTarif() {
        return tarif;
    }

    private void setTarif(int tarif) {
        if (tarif < 0) {
            throw new IllegalArgumentException("Le tarif doit être positif");
        }
        this.tarif = tarif;
    }

    public Joueur getProprietaire() {
        return proprietaire;
    }

    public void setProprietaire(Joueur proprietaire) {
        this.proprietaire = proprietaire;
    }

}

package iteration2;

public abstract class Propriete extends Case {

    private int tarif;
    private GroupePropriete groupe;
    private Joueur proprietaire;

    public Propriete(String nom, int tarif, GroupePropriete groupe, Joueur proprietaire) {
        super(nom);
        setTarif(tarif);
        setGroupe(groupe);
        setProprietaire(proprietaire);
    }

    public Propriete(String nom, int tarif, GroupePropriete groupe) {
        this(nom, tarif, groupe, null);
    }

    @Override
    public String toString() {
        return nom.toUpperCase() + " [tarif=" + tarif
                + ", groupe=" + groupe
                + ", proprietaire=" + proprietaire
                + "]";
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

    public GroupePropriete getGroupe() {
        return groupe;
    }

    private void setGroupe(GroupePropriete groupe) {
        if (groupe == null) {
            throw new IllegalArgumentException("Le groupe ne peut pas être null");
        }
        this.groupe = groupe;
    }

    public Joueur getProprietaire() {
        return proprietaire;
    }

    public void setProprietaire(Joueur proprietaire) {
        this.proprietaire = proprietaire;
    }

}

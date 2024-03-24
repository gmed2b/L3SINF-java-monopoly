package iteration3;

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

    @Override
    public void action(Joueur joueur) {
        if (joueur.getNbTours() < Monopoly.NB_TOURS_AVANT_ACHAT) {
            System.out.println("Vous ne pouvez pas acheter de propriété avant d'avoir fait "
                    + Monopoly.NB_TOURS_AVANT_ACHAT + " tours");
            return;
        }

        if (this.getProprietaire() == null) {
            boolean joueurVeutAcheter = Cli.acheterPropriete(this);
            if (!joueurVeutAcheter)
                return;

            boolean achatReussi = joueur.acheterPropriete(this);
            if (!achatReussi)
                return;

            Cli.achatReussi(this);

        } else if (this.getProprietaire() != joueur) {
            System.out.println("Vous êtes sur le terrain de " + this.getProprietaire().getNom());
        } else {
            System.out.println("Vous êtes sur votre terrain");
        }
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

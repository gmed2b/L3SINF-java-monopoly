package iteration_3;

public class Propriete extends Case {

    private int tarifAchat;
    private Joueur proprietaire;

    public Propriete(String nom, int tarifAchat, Joueur proprietaire) {
        super(nom);
        this.setTarifAchat(tarifAchat);
        this.setProprietaire(proprietaire);
    }

    public Propriete(String nom, int tarifAchat) {
        this(nom, tarifAchat, null);
    }

    @Override
    public String toString() {
        return STR."\{this.getNom().toUpperCase()} {tarifAchat=\{tarifAchat}, proprietaire=\{proprietaire} }";
    }

    @Override
    public void action(Joueur joueur, Plateau plateau) {
        if (joueur.getNbTours() < Monopoly.NB_TOURS_AVANT_ACHAT) {
            Cli.messageAchatImpossible();
            return;
        }

        Joueur proprietaire = this.getProprietaire();
        if (proprietaire == null) {
            boolean joueurVeutAcheter = Cli.acheterPropriete(this);
            if (! joueurVeutAcheter) {
                return;
            }

            boolean achatReussi = joueur.acheterPropriete(this);
            if (! achatReussi) {
                return;
            }

            Cli.messageAchatProprieteReussi(this);
        } else if (proprietaire.equals(joueur)) {
            Cli.messageJoueurDansProprietePersonnelle();
        } else {
            Cli.messageJoueurDansProprieteAdverse(this);
        }
    }

    public int getTarifAchat() {
        return tarifAchat;
    }

    public void setTarifAchat(int tarifAchat) {
        if (tarifAchat < 0) {
            throw new IllegalArgumentException("Le tarif d'achat doit être positif");
        }
        this.tarifAchat = tarifAchat;
    }

    public Joueur getProprietaire() {
        return proprietaire;
    }

    public void setProprietaire(Joueur proprietaire) {
        this.proprietaire = proprietaire;
    }
}

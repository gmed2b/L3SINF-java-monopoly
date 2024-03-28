package iteration3;

public class Terrain extends Propriete {

    public GroupeTerrain groupe;

    public Terrain(String nom, int tarifAchat, GroupeTerrain groupe) {
        super(nom, tarifAchat);
        setGroupe(groupe);
    }

    @Override
    public String toString() {
        return nom.toUpperCase() + " [tarif=" + this.getTarifAchat()
                + ", proprietaire=" + this.getProprietaire()
                + ", groupe=" + this.getGroupe()
                + "]";
    }

    @Override
    public void action(Joueur joueur, Plateau plateau) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'action'");
    }

    // @Override
    // public void action(Joueur joueur) {
    // if (this.getProprietaire() == null) {
    // boolean joueurVeutAcheter = Cli.acheterPropriete(this);
    // if (!joueurVeutAcheter)
    // return;

    // boolean achatReussi = joueur.acheterPropriete(this);
    // if (!achatReussi)
    // return;

    // Cli.achatReussi(this);

    // } else if (this.getProprietaire() != joueur) {
    // System.out.println("Vous êtes sur le terrain de " +
    // this.getProprietaire().getNom());
    // } else {
    // System.out.println("Vous êtes sur votre terrain");
    // }
    // }

    public GroupeTerrain getGroupe() {
        return groupe;
    }

    public void setGroupe(GroupeTerrain groupe) {
        this.groupe = groupe;
    }

}
